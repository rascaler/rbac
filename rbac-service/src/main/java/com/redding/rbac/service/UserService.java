package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.PageParams;

public interface UserService {
    PageInfo<UserDto> pageUsers(UserQuery userQuery, PageParams pageParams) throws SPIException;

}