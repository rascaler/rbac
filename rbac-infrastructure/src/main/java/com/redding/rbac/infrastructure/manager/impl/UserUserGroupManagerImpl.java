package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.infrastructure.domain.UserUserGroup;
import com.redding.rbac.infrastructure.manager.UserUserGroupManager;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.stereotype.Service;

@Service
public class UserUserGroupManagerImpl extends DefaultManager<UserUserGroup> implements UserUserGroupManager {
}