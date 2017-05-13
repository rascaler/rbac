package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.LoginLog;
import com.redding.rbac.infrastructure.manager.LoginLogManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class LoginLogManagerImpl extends DefaultManager<LoginLog> implements LoginLogManager {
}