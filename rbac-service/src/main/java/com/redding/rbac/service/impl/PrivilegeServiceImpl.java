package com.redding.rbac.service.impl;

import com.redding.rbac.commons.constant.RbacEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.PrivilegeDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.PrivilegeManager;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private PrivilegeManager privilegeManager;
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
}