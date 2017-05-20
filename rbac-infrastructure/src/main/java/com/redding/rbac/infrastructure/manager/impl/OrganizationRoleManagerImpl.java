package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.OrganizationRole;
import com.redding.rbac.infrastructure.manager.OrganizationRoleManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRoleManagerImpl extends DefaultManager<OrganizationRole> implements OrganizationRoleManager {
}