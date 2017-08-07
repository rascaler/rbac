package com.redding.rbac.web.utils;

import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.service.RoleService;
import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/6/21 15:10
 */
public class SessionUtils {

    @Value("${login.required:true}")
    private static boolean loginEnable;

    private static RoleService roleService;

    private static UserAuthDto userTemp;
    static {
        UserAuthDto userAuthDto = null;
        if(!loginEnable){
            userAuthDto = new UserAuthDto();
            userAuthDto.setId(1);
            userAuthDto.setEnterpriseId(1);
            userAuthDto.setUsername("admin");
            roleService = ApplicationContextUtils.getBeansByClass(RoleService.class).get(0);
            userTemp = userAuthDto;
        }
    }

    public static UserAuthDto getUserAuth() throws SPIException {
        return userTemp;
    }
}
