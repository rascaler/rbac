package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface PrivilegeManager extends BaseManager<Privilege> {
    List<Privilege> getPrivileges(List<Integer> roleIds);
}