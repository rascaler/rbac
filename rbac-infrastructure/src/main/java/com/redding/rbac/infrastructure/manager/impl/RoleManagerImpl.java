package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Role;
import com.redding.rbac.infrastructure.manager.RoleManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class RoleManagerImpl extends DefaultManager<Role> implements RoleManager {
}