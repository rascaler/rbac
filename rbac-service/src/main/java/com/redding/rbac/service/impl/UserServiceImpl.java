package com.redding.rbac.service.impl;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.infrastructure.manager.UserManager;
import com.redding.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public PageInfo<UserDto> pageUsers(Integer organizationId, int enterpriseIdMock) throws SPIException {

        return null;
    }
}