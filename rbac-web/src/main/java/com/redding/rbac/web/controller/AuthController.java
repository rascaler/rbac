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
import com.redding.rbac.web.utils.shiro.UsernamePasswordCaptchaToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
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

    @RequestMapping(method = RequestMethod.GET)
    @OuterResponseBody
    boolean auth(){
        if(null != SessionUtils.getUserAuth()) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @OuterResponseBody
    UserAuthDto login(@Validated LoginForm loginForm){
        UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(loginForm.getUsername(), loginForm.getPassword(), loginForm.getSecurityCode(), true);
        SecurityUtils.getSubject().login(token);
        return SessionUtils.getUserAuth();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @OuterResponseBody
    void logout(){
        SecurityUtils.getSubject().logout();
    }


}
