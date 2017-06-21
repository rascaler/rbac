package com.redding.rbac.service;


import com.redding.rbac.commons.pojo.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAll(Integer enterpriseId);

    /**
     * 查询部门可分配的角色
     *
     * @param organizationId
     * @param enterpriseId
     * @return
     */
    List<RoleDto> getOrganizationRoles(Integer organizationId, int enterpriseId);

    /**
     * 查询当前用户角色
     * @param userId
     * @param enterpriseId
     * @return
     */
    List<RoleDto> getUserRoles(Integer userId, Integer enterpriseId);
}