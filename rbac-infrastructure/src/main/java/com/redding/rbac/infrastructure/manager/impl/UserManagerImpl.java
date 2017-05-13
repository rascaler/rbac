package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.manager.UserManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl extends DefaultManager<User> implements UserManager {
}