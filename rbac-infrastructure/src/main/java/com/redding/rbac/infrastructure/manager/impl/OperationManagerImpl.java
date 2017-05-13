package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Operation;
import com.redding.rbac.infrastructure.manager.OperationManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class OperationManagerImpl extends DefaultManager<Operation> implements OperationManager {
}