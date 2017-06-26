package com.redding.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.BeanMapper;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.infrastructure.domain.User;
import com.redding.rbac.infrastructure.manager.UserManager;
import com.redding.rbac.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public PageInfo<UserDto> pageUsers(UserQuery userQuery,PageParams pageParam) throws SPIException {
        if(StringUtils.isNotEmpty(userQuery.getKeyword()))
            userQuery.setKeyword(userQuery.getKeyword() + "%");
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), pageParam.getOrderBy());
        List<User> users = userManager.queryOrgUsers(userQuery);
        PageInfo pageInfo = new PageInfo(users);
        pageInfo.setList(BeanMapper.mapList(pageInfo.getList(), UserDto.class));
        return pageInfo;
    }

    @Override
    public void saveOrUpdate(UserEditDto userEditDto) {
        if (null == userEditDto.getId()) { //新增
            userManager.save(userEditDto);
        } else {
            userManager.update(userEditDto);
        }
    }


}