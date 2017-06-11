package com.redding.rbac.service.impl;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.OrganizationRole;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.OrganizationRoleManager;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleManager roleManager;

    @Autowired
    private OrganizationRoleManager organizationRoleManager;

    @Override
    public List<RoleDto> getAll(Integer enterpriseId) {
        return BeanMapper.mapList(roleManager.getAll(enterpriseId), RoleDto.class);
    }

    @Override
    public List<RoleDto> getOrganizationRoles(Integer organizationId, int enterpriseId) {
        OrganizationRole orgRoleQuery = new OrganizationRole();
        orgRoleQuery.setOrganizationId(organizationId);
        List<OrganizationRole> orgRoles = organizationRoleManager.select(orgRoleQuery);
        if(null == orgRoles || orgRoles.size() == 0)
            return null;
        Example example = new Example(Role.class);
        example.createCriteria().andIn("id", orgRoles.stream().map(OrganizationRole::getRoleId).collect(Collectors.toList()));
        List<Role> roles = roleManager.selectByExample(example);
        if(null == roles && roles.size() == 0)
            throw new SPIException(BasicEcode.DATA_ERROR);
        return BeanMapper.mapList(roles, RoleDto.class);
    }
}