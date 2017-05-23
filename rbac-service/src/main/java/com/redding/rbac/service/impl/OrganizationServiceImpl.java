package com.redding.rbac.service.impl;

import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.OrganizationDto;
import com.redding.rbac.commons.pojo.dto.OrganizationEditDto;
import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.domain.OrganizationRole;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.OrganizationManager;
import com.redding.rbac.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationManager organizationManager;

    @Override
    public List<OrganizationNodeDto> getOrgTree(Integer id,Integer enterpriseId) throws SPIException {
        List<Organization> organizations =  organizationManager.querySelfAndSub(id, enterpriseId);
        if(null == organizations || organizations.isEmpty())
            return null;
        List<Organization> rootList = organizations.stream().filter(o -> o.getParentId().equals(OrganizationDto.ROOT_PARENT))
                                                            .collect(Collectors.toList());
        List<OrganizationNodeDto> roots = BeanMapper.mapList(rootList, OrganizationNodeDto.class);
        organizations.removeAll(rootList);
        if(null == roots || roots.isEmpty())
            return null;
        roots.forEach(r -> traverseOrganization(r, organizations) );
        return roots;
    }

    @Override
    public void saveOrganization(OrganizationEditDto organizationEditDto) throws SPIException {
        Organization organization = BeanMapper.map(organizationEditDto, Organization.class);
        List<OrganizationRole> organizationRoles = new ArrayList<OrganizationRole>(organizationEditDto.getRoleIds().size());
        organizationEditDto.getRoleIds().forEach(id -> {
            OrganizationRole organizationRole = new OrganizationRole();
            organizationRole.setRoleId(id);
        });
        organizationManager.saveOrganization(organization,organizationRoles);
    }

    @Override
    public void updateOrganization(OrganizationEditDto organizationEditDto) throws SPIException {

    }
    /////////////////////////private method//////////////////////////////////

    //递归遍历
    private void traverseOrganization(OrganizationNodeDto parent,List<Organization> allOrgs){
        if(null == allOrgs || allOrgs.isEmpty())
            return;
        List<Organization> subList = allOrgs.stream().filter(o -> o.getParentId().equals(parent.getId()))
                                                     .collect(Collectors.toList());
        if(null == subList || subList.isEmpty())
            return;
        parent.setChildren(BeanMapper.mapList(subList, OrganizationNodeDto.class));
        allOrgs.remove(subList);
        parent.getChildren().forEach(o -> traverseOrganization(o, allOrgs) );
    }
}