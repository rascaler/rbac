package com.redding.rbac.web.controller;

import com.github.pagehelper.PageInfo;
import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.EnterpriseDto;
import com.redding.rbac.commons.pojo.dto.UserDetailDto;
import com.redding.rbac.commons.pojo.dto.UserDto;
import com.redding.rbac.commons.pojo.dto.UserEditDto;
import com.redding.rbac.commons.pojo.dto.auth.LoginForm;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.commons.pojo.query.UserQuery;
import com.redding.rbac.commons.utils.PageParams;
import com.redding.rbac.commons.utils.validation.Add;
import com.redding.rbac.commons.utils.validation.Update;
import com.redding.rbac.service.UserService;
import com.redding.rbac.web.utils.SessionUtils;
import com.redding.rbac.web.utils.annotation.OuterResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:09
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @OuterResponseBody
    UserAuthDto login(@Validated LoginForm loginForm){
        //先验证验证码
        String code = (String)SecurityUtils.getSubject().getSession().getAttribute("securityCode");
        if(StringUtils.isEmpty(code))
            throw new SPIException(BasicEcode.FAILED);
        if(!loginForm.getSecurityCode().equals(code))
            throw new SPIException(BasicEcode.FAILED);
        if(userService.validateUser(loginForm)) {
            SecurityUtils.getSubject().getSession().setAttribute("userAuth", userService.getUserAuth(loginForm.getUsername()));
        }
        return SessionUtils.getUserAuth();
    }

    @RequestMapping(method = RequestMethod.GET)
    @OuterResponseBody
    boolean auth(){
        if(null != SessionUtils.getUserAuth()) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @OuterResponseBody
    void logout(){
        SecurityUtils.getSubject().logout();
    }


}
