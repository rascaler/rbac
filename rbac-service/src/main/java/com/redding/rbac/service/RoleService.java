package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.commons.pojo.dto.RoleEditDto;
import com.redding.rbac.commons.pojo.query.RoleQuery;
import com.redding.rbac.commons.utils.PageParams;

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

    /**
     * 查询角色
     * @param roleQuery
     * @param pageParams
     * @return
     */
    PageInfo<RoleDto> pageRoles(RoleQuery roleQuery, PageParams pageParams);

    /**
     * 保存角色
     * @param roleEditDto
     * @return
     */
    int save(RoleEditDto roleEditDto);

    /**
     * 更新角色
     * @param roleEditDto
     * @return
     */
    int update(RoleEditDto roleEditDto);

}