package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.pojo.dto.OrganizationNodeDto;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.service.OrganizationService;
import com.redding.rbac.service.UserService;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    PageInfo<UserDto> pageUsers(@RequestParam Integer organizationId) {

        return userService.pageUsers(organizationId, EnterpriseDto.ENTERPRISE_ID_MOCK);
    }


}
