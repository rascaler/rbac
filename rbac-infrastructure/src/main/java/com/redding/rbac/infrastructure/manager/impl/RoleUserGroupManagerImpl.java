package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.RoleUserGroup;
import com.redding.rbac.infrastructure.manager.RoleUserGroupManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class RoleUserGroupManagerImpl extends DefaultManager<RoleUserGroup> implements RoleUserGroupManager {
}