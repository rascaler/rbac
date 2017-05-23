package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;
import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.domain.OrganizationRole;
import com.redding.rbac.infrastructure.manager.OrganizationManager;
import com.redding.rbac.infrastructure.mapper.OrganizationMapper;
import com.redding.rbac.infrastructure.mapper.OrganizationRoleMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationManagerImpl extends DefaultManager<Organization> implements OrganizationManager {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationRoleMapper organizationRoleMapper;
    @Override
    public List<Organization> querySelfAndSub(Integer id, Integer enterpriseId) {
        return organizationMapper.selectSelfAndSub(id, enterpriseId);
    }

    @Override
    public void saveOrganization(Organization organization, List<OrganizationRole> organizationRoles) {
        organizationMapper.insertSelective(organization);
        organizationRoles.forEach(r -> r.setOrganizationId(organization.getId()));
        organizationRoleMapper.insertList(organizationRoles);
    }
}