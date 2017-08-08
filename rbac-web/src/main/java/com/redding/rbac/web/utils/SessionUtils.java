package com.redding.rbac.web.utils;

import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 15:10
 */
public class SessionUtils {

    public static UserAuthDto getUserAuth() throws SPIException {
        return (UserAuthDto) SecurityUtils.getSubject().getSession().getAttribute("userAuth");
    }
}
