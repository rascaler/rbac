package com.redding.rbac.infrastructure.mapper;

import com.redding.rbac.infrastructure.domain.Operation;
import com.redding.rbac.infrastructure.utils.MyMapper;

import java.util.List;

public interface OperationMapper extends MyMapper<Operation> {
    List<Operation> seletAppOperations(Integer appId);
}