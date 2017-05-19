package com.redding.rbac.infrastructure.mapper;

import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.utils.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<User> selectOrgUsers(UserQuery userQuery);
}