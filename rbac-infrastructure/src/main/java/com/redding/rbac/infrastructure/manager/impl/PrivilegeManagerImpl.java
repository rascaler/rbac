package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Privilege;
import com.redding.rbac.infrastructure.manager.PrivilegeManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeManagerImpl extends DefaultManager<Privilege> implements PrivilegeManager {
}