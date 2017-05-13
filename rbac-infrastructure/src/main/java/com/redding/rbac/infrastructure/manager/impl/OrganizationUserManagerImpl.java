package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.OrganizationUser;
import com.redding.rbac.infrastructure.manager.OrganizationUserManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class OrganizationUserManagerImpl extends DefaultManager<OrganizationUser> implements OrganizationUserManager {
}