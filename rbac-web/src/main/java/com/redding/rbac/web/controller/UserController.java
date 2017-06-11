package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.service.UserService;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/pageUsers", method = RequestMethod.GET)
    @OuterResponseBody
    PageInfo<UserDto> pageUsers(UserQuery userQuery, PageParams pageParams) {
        userQuery.setEnterpriseId(EnterpriseDto.ENTERPRISE_ID_MOCK);
        return userService.pageUsers(userQuery,pageParams);
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @OuterResponseBody
    void saveOrUpdate(@RequestBody @Valid UserEditDto userEditDto) {
        userEditDto.setEnterpriseId(EnterpriseDto.ENTERPRISE_ID_MOCK);
        userService.saveOrUpdate(userEditDto);
    }

}
