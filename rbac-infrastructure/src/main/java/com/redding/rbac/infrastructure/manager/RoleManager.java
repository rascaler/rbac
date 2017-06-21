package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.commons.pojo.dto.RoleDto;
import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface RoleManager extends BaseManager<Role> {

    /**
     *
     * @param enterpriseId
     * @return
     */
    List<Role> getAll(Integer enterpriseId);

    /**
     * 查询用户角色
     * @param userId
     * @param enterpriseId
     * @return
     */
    List<RoleDto> queryUserRoles(Integer userId, Integer enterpriseId);
}