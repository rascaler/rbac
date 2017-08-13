package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.DefaultStateEnum;
import com.redding.rbac.commons.constant.RbacEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.pojo.dto.RoleEditDto;
import com.redding.rbac.commons.pojo.query.RoleQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.*;
import com.redding.rbac.infrastructure.manager.*;
import com.redding.rbac.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleManager roleManager;

    @Autowired
    private OrganizationRoleManager organizationRoleManager;

    @Autowired
    private OrganizationUserManager organizationUserManager;

    @Autowired
    private UserRoleManager userRoleManager;

    @Autowired
    private RolePrivilegeManager rolePrivilegeManager;

    @Override
    public List<RoleDto> getAll(Integer enterpriseId) {
        return BeanMapper.mapList(roleManager.getAll(enterpriseId), RoleDto.class);
    }

    @Override
    public List<RoleDto> getOrganizationRoles(Integer organizationId, int enterpriseId) {
        OrganizationRole orgRoleQuery = new OrganizationRole();
        orgRoleQuery.setOrganizationId(organizationId);
        List<OrganizationRole> orgRoles = organizationRoleManager.selectList(orgRoleQuery);
        if(null == orgRoles || orgRoles.size() == 0)
            return null;
        Example example = new Example(Role.class);
        example.createCriteria().andIn("id", orgRoles.stream().map(OrganizationRole::getRoleId).collect(Collectors.toList()));
        List<Role> roles = roleManager.selectByExample(example);
        if(null == roles && roles.size() == 0)
            throw new SPIException(BasicEcode.DATA_ERROR);
        return BeanMapper.mapList(roles, RoleDto.class);
    }

    @Override
    public List<RoleDto> getUserRoles(Integer userId, Integer enterpriseId) {
        return BeanMapper.mapList(roleManager.getUserRoles(userId), RoleDto.class);
    }

    @Override
    public PageInfo<RoleDto> pageRoles(RoleQuery roleQuery, PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageNum(), pageParams.getPageSize());
        Example example = new Example(Role.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(roleQuery.getName()))
            criteria.andLike("name", roleQuery.getName() + "%");
        if(null != roleQuery.getState())
            criteria.andEqualTo("state", roleQuery.getState());
        criteria.andEqualTo("enterpriseId", roleQuery.getEnterpriseId());
        PageInfo pageInfo = new PageInfo(roleManager.selectByExample(example));
        pageInfo.setList(BeanMapper.mapList(pageInfo.getList(), RoleDto.class));
        return pageInfo;
    }

    @Override
    public int save(RoleEditDto roleEditDto) {
        Role role = BeanMapper.map(roleEditDto, Role.class);
        List<RolePrivilege> rolePrivileges = new ArrayList<RolePrivilege>();
        roleEditDto.getPrivilegeIds().forEach(p -> {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setPrivilegeId(p);
            rolePrivileges.add(rolePrivilege);
        });
        // 查询父节点
        if(null != roleEditDto.getParentId()) {
          Role parent = roleManager.selectByKey(roleEditDto.getParentId());
          if(null == parent){
             logger.error("角色id={}不存在", roleEditDto.getParentId());
             throw new SPIException(RbacEcode.ROLE_NOT_EXISTS);
          }
          role.setPidList( StringUtils.isNotEmpty(parent.getPidList()) ? parent.getPidList() + "," + parent.getId() : parent.getId().toString());
        }
        return roleManager.save(role, rolePrivileges);
    }

    @Override
    public int update(RoleEditDto roleEditDto) {
        Role role = BeanMapper.map(roleEditDto, Role.class);
        List<RolePrivilege> rolePrivileges = new ArrayList<RolePrivilege>();
        roleEditDto.getPrivilegeIds().forEach(p -> {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setPrivilegeId(p);
            rolePrivilege.setRoleId(roleEditDto.getId());
            rolePrivileges.add(rolePrivilege);
        });
        // 查询父节点
        if(null != roleEditDto.getParentId()) {
            Role parent = roleManager.selectByKey(roleEditDto.getParentId());
            if(null == parent){
                logger.error("角色id={}不存在", roleEditDto.getParentId());
                throw new SPIException(RbacEcode.ROLE_NOT_EXISTS);
            }
            role.setPidList( StringUtils.isNotEmpty(parent.getPidList()) ? parent.getPidList() + "," + parent.getId() : parent.getId().toString());
        }
        return roleManager.update(role, rolePrivileges);
    }

    @Override
    public void delete(Integer id) throws SPIException {
        // 查询角色是否已在使用
        OrganizationRole orgRoleQuery = new OrganizationRole();
        orgRoleQuery.setRoleId(id);
        OrganizationRole orgRole = organizationRoleManager.selectFirst(orgRoleQuery);
        if(null != orgRole)
            throw new SPIException(RbacEcode.ROLE_IN_USE);
        UserRole userRoleQuery = new UserRole();
        userRoleQuery.setRoleId(id);
        UserRole userRole = userRoleManager.selectFirst(userRoleQuery);
        if(null != userRole)
            throw new SPIException(RbacEcode.ROLE_IN_USE);
        roleManager.deleteRole(id);
    }

    @Override
    public void updateState(RoleDto role) {
        roleManager.updateSelective(BeanMapper.map(role, Role.class));
    }

    @Override
    public RoleEditDto getEditDetail(Integer id, Integer enterpriseId) throws SPIException{
        Role query = new Role();
        query.setId(id);
        query.setEnterpriseId(enterpriseId);
        Role role = roleManager.selectOne(query);
        if(null == role)
            throw new SPIException(RbacEcode.ROLE_NOT_EXISTS);
        RoleEditDto editDto = BeanMapper.map(role, RoleEditDto.class);
        RolePrivilege rolePrivQuery = new RolePrivilege();
        rolePrivQuery.setRoleId(id);
        List<RolePrivilege> rolePrivileges = rolePrivilegeManager.selectList(rolePrivQuery);
        if(null == rolePrivileges)
            throw new SPIException(RbacEcode.PRIVILEGE_NOT_EXISTS);
        editDto.setPrivilegeIds(rolePrivileges.stream().map(RolePrivilege::getPrivilegeId).collect(Collectors.toList()));
        return editDto;
    }
}