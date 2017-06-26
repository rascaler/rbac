package com.redding.rbac.infrastructure.manager;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.utils.BaseManager;

import java.util.List;

public interface UserManager extends BaseManager<User> {

    List<User> queryOrgUsers(UserQuery userQuery);

    int save(UserEditDto userEditDto);


    int update(UserEditDto userEditDto);
}