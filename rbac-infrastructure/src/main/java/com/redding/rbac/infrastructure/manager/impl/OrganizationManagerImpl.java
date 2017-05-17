package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Organization;
import com.redding.rbac.infrastructure.manager.OrganizationManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class OrganizationManagerImpl extends DefaultManager<Organization> implements OrganizationManager {
}