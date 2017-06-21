package com.redding.rbac.service.impl;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.constant.DefaultStateEnum;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.*;
import com.redding.rbac.infrastructure.manager.OrganizationRoleManager;
import com.redding.rbac.infrastructure.manager.OrganizationUserManager;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.infrastructure.manager.UserRoleManager;
import com.redding.rbac.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleManager roleManager;

    @Autowired
    private OrganizationRoleManager organizationRoleManager;

    @Autowired
    private OrganizationUserManager organizationUserManager;

    @Autowired
    private UserRoleManager userRoleManager;

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
        //先查询用户当前组织所拥有的角色
        Set<Integer> roleIds = new HashSet<Integer>();
        OrganizationUser orgUserQuery = new OrganizationUser();
        orgUserQuery.setUserId(userId);
        organizationUserManager.selectList(orgUserQuery);
        List<OrganizationUser> orgUsers = organizationUserManager.selectList(orgUserQuery);
        if(null != orgUsers && orgUsers.size() > 0){
            Example orgRoleExample = new Example(OrganizationRole.class);
            orgRoleExample.createCriteria().andIn("organizationId", orgUsers.stream().map(OrganizationUser::getOrganizationId).collect(Collectors.toList()));
            List<OrganizationRole> orgRoles = organizationRoleManager.selectByExample(orgRoleExample);
            if(null != orgRoles && orgRoles.size() > 0){
                roleIds.addAll(orgRoles.stream().map(OrganizationRole::getRoleId).collect(Collectors.toList()));
            }
        }
        //查询用户当前所分配的角色
        UserRole userRoleQuery = new UserRole();
        userRoleQuery.setUserId(userId);
        List<UserRole> userRoles = userRoleManager.selectList(userRoleQuery);
        if(null != userRoles && userRoles.size() > 0)
            roleIds.addAll(userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        if(null == roleIds || roleIds.size() == 0)
            return null;
        Example roleExample = new Example(Role.class);
        roleExample.createCriteria().andIn("id", roleIds).andEqualTo("state", DefaultStateEnum.ENABLED.getValue());
        List<Role> roles = roleManager.selectByExample(roleExample);
        if(null == roles || roles.size() == 0)
            throw new SPIException(BasicEcode.DATA_ERROR);
        for(Role r : roles){
            if(StringUtils.isNotEmpty(r.getPidList())){
                String[] pidList = r.getPidList().split(",");
                for(String pid: pidList){
                    roleIds.add(Integer.parseInt(pid));
                }
            }
            roleIds.add(r.getId());
        }
        roleExample.clear();
        roleExample.createCriteria().andIn("id", roleIds);
        return BeanMapper.mapList(roleManager.selectByExample(roleExample), RoleDto.class);
    }
}