package com.redding.rbac.infrastructure.manager.impl;

import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.manager.UserManager;
import com.redding.rbac.infrastructure.mapper.UserMapper;
import com.redding.rbac.infrastructure.utils.DefaultManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerImpl extends DefaultManager<User> implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryOrgUsers(UserQuery userQuery) {
        return userMapper.selectOrgUsers(userQuery);
    }
}