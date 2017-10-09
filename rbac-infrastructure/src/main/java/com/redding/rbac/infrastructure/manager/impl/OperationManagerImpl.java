package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Operation;
import com.redding.rbac.infrastructure.manager.OperationManager;
import com.redding.rbac.infrastructure.mapper.OperationMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationManagerImpl extends DefaultManager<Operation> implements OperationManager {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public List<Operation> queryAppOperations(Integer appId) {
        return operationMapper.seletAppOperations(appId);
    }
}