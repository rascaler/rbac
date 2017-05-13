package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.Enterprise;
import com.redding.rbac.infrastructure.manager.EnterpriseManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseManagerImpl extends DefaultManager<Enterprise> implements EnterpriseManager {
}