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
        UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authenticationToken;
        String username = token.getUsername();
        String code = (String)SecurityUtils.getSubject().getSession().getAttribute("securityCode");
        if(StringUtils.isEmpty(token.getCaptcha()) || StringUtils.isEmpty(code) || !token.getCaptcha().equals(code)) //验证码错误
            throw new SPIException(BasicEcode.SECURITY_CODE_ERROR);
        if(StringUtils.isEmpty(token.getUsername())) //账号错误
            throw new SPIException(BasicEcode.USER_ERR_LOGIN);
        if(null == token.getPassword() || token.getPassword().length == 0) //密码错误
            throw new SPIException(BasicEcode.USER_ERR_LOGIN);
        UserAuthDto userAuth = userService.getUserAuth(username);
        if(null == userAuth || !userAuth.getPassword().equals(new String(token.getPassword())))
            throw new SPIException(BasicEcode.USER_ERR_LOGIN);
        SecurityUtils.getSubject().getSession().setAttribute("userAuth", userAuth);
        return new SimpleAuthenticationInfo(userAuth.getUsername(), userAuth.getPassword(), getName());
    }

}