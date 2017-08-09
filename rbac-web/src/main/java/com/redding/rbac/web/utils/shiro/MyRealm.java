package com.redding.rbac.web.utils.shiro;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    /**
     * 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.fromRealm(getName()).iterator().next();
        if( username != null ){
            UserAuthDto userAuth = userService.getUserAuth(username);
            if( null != userAuth && null != userAuth.getRoles() && userAuth.getRoles().size() > 0){
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                // 权限
                userAuth.getRoles().forEach(r -> {
                    info.addRole(r.getCode());
                    info.addStringPermissions(r.getPrivileges());
                });
                return info;
            }
        }
        return null;
    }

    /**
     * 认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if(StringUtils.isNotEmpty(username)){
            UserAuthDto userAuth = userService.getUserAuth(username);
            if(null == userAuth || !userAuth.getPassword().equals(new String(token.getPassword())))
                throw new SPIException(BasicEcode.USER_ERR_LOGIN);
            SecurityUtils.getSubject().getSession().setAttribute("userAuth", userAuth);
            return new SimpleAuthenticationInfo(userAuth.getUsername(), userAuth.getPassword(), getName());
        }
        return null;
    }

}