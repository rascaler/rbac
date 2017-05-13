package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.UserGroup;
import com.redding.rbac.infrastructure.manager.UserGroupManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class UserGroupManagerImpl extends DefaultManager<UserGroup> implements UserGroupManager {
}