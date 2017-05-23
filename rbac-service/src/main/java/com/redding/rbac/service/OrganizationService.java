package com.redding.rbac.service;

import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.OrganizationEditDto;
import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;

import java.util.List;

public interface OrganizationService {
    List<OrganizationNodeDto> getOrgTree(Integer id, Integer enterpriseId) throws SPIException;

    void saveOrganization(OrganizationEditDto organizationEditDto) throws SPIException;

    void updateOrganization(OrganizationEditDto organizationEditDto) throws SPIException;
}