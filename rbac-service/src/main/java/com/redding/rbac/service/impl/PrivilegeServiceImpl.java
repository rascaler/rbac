package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.RbacEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;
import com.redding.rbac.commons.pojo.dto.PrivilegeEditDto;
import com.redding.rbac.commons.pojo.query.PrivilegeQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.MenuPrivilege;
import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.MenuPrivilegeManager;
import com.redding.rbac.infrastructure.manager.PrivilegeManager;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.service.PrivilegeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private PrivilegeManager privilegeManager;

    @Autowired
    private MenuPrivilegeManager menuPrivilegeManager;
    @Override
    public List<PrivilegeDto> getPrivileges(Integer userId) throws SPIException {
        // 获取当前用户的所有角色
        List<Role> roles = roleManager.getUserRoles(userId);
        if(null == roles)
            throw new SPIException(RbacEcode.ROLE_NOT_EXISTS);
        // 获取角色所有权限
        List<Privilege> privileges = privilegeManager.getPrivileges(roles.stream().map(Role::getId).collect(Collectors.toList()));
        if(null == privileges || privileges.size() == 0)
            throw new SPIException(RbacEcode.PRIVILEGE_NOT_EXISTS);
        return BeanMapper.mapList(privileges, PrivilegeDto.class);
    }

    @Override
    public PageInfo<PrivilegeDto> pagePrivileges(PageParams pageParams, PrivilegeQuery query) {
        Example example = new Example(Privilege.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(query.getCode()))
            criteria.andEqualTo("code", query.getCode());
        if(StringUtils.isNotEmpty(query.getName()))
            criteria.andLike("name", query.getName() + "%");
        criteria.andEqualTo("enterpriseId", query.getEnterpriseId());
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        List<Privilege> list = privilegeManager.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(BeanMapper.mapList(list, PrivilegeDto.class));
        return pageInfo;
    }

    @Override
    public int save(PrivilegeEditDto privilegeEditDto) {
        Privilege privilege = BeanMapper.map(privilegeEditDto, Privilege.class);
        List<MenuPrivilege> list = new ArrayList<MenuPrivilege>();
        privilegeEditDto.getMenuIds().forEach(m -> {
            MenuPrivilege menuPrivilege = new MenuPrivilege();
            menuPrivilege.setMenuId(m);
            list.add(menuPrivilege);
        });
        int result = privilegeManager.save(privilege, list);
        if(result <= 0)
            throw new SPIException(BasicEcode.SAVE_ERROR);
        return result;
    }

    public int update(PrivilegeEditDto privilegeEditDto) {
        Privilege privilege = BeanMapper.map(privilegeEditDto, Privilege.class);
        List<MenuPrivilege> list = new ArrayList<MenuPrivilege>();
        privilegeEditDto.getMenuIds().forEach(m -> {
            MenuPrivilege menuPrivilege = new MenuPrivilege();
            menuPrivilege.setPrivilegeId(privilege.getId());
            menuPrivilege.setMenuId(m);
            list.add(menuPrivilege);
        });
        int result = privilegeManager.update(privilege, list);
        if(result <= 0)
            throw new SPIException(BasicEcode.UPDATE_ERROR);
        return result;
    }

    @Override
    public int delete(Integer id) {
        return privilegeManager.deletePrivilege(id);
    }

    @Override
    public PrivilegeEditDto getEditDetail(Integer id) throws SPIException {
        Privilege privilege = privilegeManager.selectByKey(id);
        PrivilegeEditDto privilegeEdit = BeanMapper.map(privilege, PrivilegeEditDto.class);
        // 菜单
        MenuPrivilege query = new MenuPrivilege();
        query.setPrivilegeId(id);
        List<MenuPrivilege> menuPrivs = menuPrivilegeManager.selectList(query);
        if(null != menuPrivs && menuPrivs.size() > 0)
            privilegeEdit.setMenuIds(menuPrivs.stream()
                                                .map(MenuPrivilege::getMenuId)
                                                .collect(Collectors.toList()) );
        return privilegeEdit;
    }

}