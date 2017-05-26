package com.redding.rbac.service;

import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.OrganizationDto;
import com.redding.rbac.commons.pojo.dto.OrganizationEditDto;
import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;

import java.util.List;

public interface OrganizationService {
    /**
     * 获取组织树
     * @param id
     * @param enterpriseId
     * @return
     * @throws SPIException
     */
    List<OrganizationNodeDto> getOrgTree(Integer id, Integer enterpriseId) throws SPIException;

    /**
     * 保存组织
     * 验证：同一级组织的名称不能相同
     * @param organizationEditDto
     * @throws SPIException
     */
    OrganizationDto saveOrganization(OrganizationEditDto organizationEditDto) throws SPIException;

    /**
     * 更新组织
     * 验证：同一级组织的名称不能相同
     * @param organizationEditDto
     * @throws SPIException
     */
    OrganizationDto updateOrganization(OrganizationEditDto organizationEditDto) throws SPIException;

    /**
     * 删除组织
     * @param id
     * @throws SPIException
     */
    void remove(Integer id) throws SPIException;

    /**
     * 获取详情
     * @param id
     * @return
     * @throws SPIException
     */
    OrganizationEditDto getDetail(Integer id) throws SPIException;
}