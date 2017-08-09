package com.redding.rbac.web.utils;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.service.UserService;
import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 15:10
 */
public class SessionUtils implements EnvironmentAware{

    private final static Logger log = LoggerFactory.getLogger(SessionUtils.class);

    //    @Value("${login.required:true}")
    private static boolean loginRequired;

//    @Value("${login.username}")
    private static String username;

    private static UserService userService;

    static {
        userService = ApplicationContextUtils.getBeanByClass(UserService.class);
    }
    public static UserAuthDto getUserAuth() throws SPIException {
        Session session = SecurityUtils.getSubject().getSession();
        UserAuthDto userAuth = (UserAuthDto)session.getAttribute("userAuth");
        if(null == userAuth && !loginRequired) {
            if(StringUtils.isEmpty(username)) {
                log.error("免登陆时 login.username 不能为空");
                throw new SPIException(BasicEcode.FAILED);
            }
            userAuth = userService.getUserAuth(username);
            session.setAttribute("userAuth", userAuth);
        }
        return userAuth;
    }

    @Override
    public void setEnvironment(Environment environment) {
        String loginRequiredStr = environment.getProperty("login.required");
        username = environment.getProperty("login.username");
        if(StringUtils.isEmpty(loginRequiredStr)){
            log.error("属性 ${login.required} 不能为空");
            throw new SPIException(BasicEcode.FAILED);
        }
        loginRequired = new Boolean(loginRequiredStr);
    }
}
