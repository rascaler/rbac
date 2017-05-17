package com.redding.rbac.service;


import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserDto;

public interface UserService {
    PageInfo<UserDto> pageUsers(Integer organizationId, int enterpriseIdMock) throws SPIException;

}