package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.infrastructure.domain.MenuPrivilege;
import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface PrivilegeManager extends BaseManager<Privilege> {
    List<Privilege> getPrivileges(List<Integer> roleIds);

    int save(Privilege privilege, List<MenuPrivilege> list);

    int update(Privilege privilege, List<MenuPrivilege> list);

    int deletePrivilege(Integer id);
}