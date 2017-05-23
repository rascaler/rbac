package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface RoleManager extends BaseManager<Role> {
    List<Role> getAll(Integer enterpriseId);
}