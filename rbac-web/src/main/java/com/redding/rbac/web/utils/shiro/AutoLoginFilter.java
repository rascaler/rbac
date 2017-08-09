package com.redding.rbac.web.utils.shiro;


import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AutoLoginFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        UserAuthDto user = (UserAuthDto) subject.getSession().getAttribute("userAuth");
        if(null == user) {
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("admin","123");
            subject.login(usernamePasswordToken);
        }
        return true;
    }
}