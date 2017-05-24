package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.domain.OrganizationRole;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface OrganizationManager extends BaseManager<Organization> {
    /**
     * 查询本组织和子组织
     * @param id
     * @param enterpriseId
     * @return
     */
    List<Organization> querySelfAndSub(Integer id, Integer enterpriseId);

    /**
     * 保存组织
     * @param organization
     * @param organizationRoles
     */
    void saveOrganization(Organization organization, List<OrganizationRole> organizationRoles);

    /**
     * 更新组织
     * @param organization
     * @param organizationRoles
     */
    void updateOrganization(Organization organization, List<OrganizationRole> organizationRoles);
}