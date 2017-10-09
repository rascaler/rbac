package com.redding.rbac.infrastructure.manager;

import com.redding.rbac.infrastructure.domain.Operation;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface OperationManager extends BaseManager<Operation> {
    List<Operation> queryAppOperations(Integer appId);
}