package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.UserRole;
import com.redding.rbac.infrastructure.manager.UserRoleManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class UserRoleManagerImpl extends DefaultManager<UserRole> implements UserRoleManager {
}