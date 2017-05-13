package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.OperationPrivilege;
import com.redding.rbac.infrastructure.manager.OperationPrivilegeManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class OperationPrivilegeManagerImpl extends DefaultManager<OperationPrivilege> implements OperationPrivilegeManager {
}