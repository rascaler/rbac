package com.redding.rbac.web.config;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.websocket.Session;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by redding on 4/2/17.
 */
@Configuration
public class ShiroConfig {

    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    @Value("${login.required:true}")
    private static boolean loginEnable;

    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean(name = "shiroEhcacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myRealm());
        dwsm.setCacheManager(getEhCacheManager());
        return dwsm;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        if(loginEnable)
            shiroFilterFactoryBean.setLoginUrl("/login");
        else
            shiroFilterFactoryBean.setLoginUrl("/autoLogin");
        shiroFilterFactoryBean.setSuccessUrl("/sa/index");
        filterChainDefinitionMap.put("/sa/**", "authc");
        filterChainDefinitionMap.put("/role/**", "authc,perms[admin:role]");
        filterChainDefinitionMap.put("/user/**", "authc,perms[admin:user]");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}

class MyRealm extends AuthorizingRealm{

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

