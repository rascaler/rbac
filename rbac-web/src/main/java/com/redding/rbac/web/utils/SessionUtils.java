package com.redding.rbac.web.utils;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.UserAuthDto;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 15:10
 */
@Component
public class SessionUtils {

    @Value("${login.required:true}")
    private static boolean loginEnable;

    private static RoleService roleService;

    private static UserAuthDto userTemp;
    static {
        UserAuthDto userAuthDto = null;
        if(!loginEnable){
            userAuthDto = new UserAuthDto();
            userAuthDto.setEnterpriseId(1);
            userAuthDto.setUsername("admin");
            roleService = ApplicationContextUtils.getBeansByClass(RoleService.class).get(0);
        }
    }

    public static UserAuthDto getUserAuth() throws SPIException {
        return userTemp;
    }
}
