package com.redding.rbac.web.config;

import com.redding.rbac.commons.constant.BasicEcode;
import com.redding.rbac.commons.exception.SPIException;
import com.redding.rbac.commons.pojo.dto.auth.UserAuthDto;
import com.redding.rbac.web.utils.shiro.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by redding on 4/2/17.
 */
@Configuration
public class ShiroConfig implements EnvironmentAware{

    private Logger log = LoggerFactory.getLogger(ShiroConfig.class);

//    @Value("${login.required}")
    private boolean loginRequired;

    private String loginUrl;

    private String successUrl;

    public static boolean corsEnable;

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
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("http://localhost:8888/");
        shiroFilterFactoryBean.setSuccessUrl("/sa/index");
        if(!loginRequired) {
            filterChainDefinitionMap.put("/**", "anon");
        }
        // 自定义过滤器，以验证不通过以json形式返回结果
        shiroFilterFactoryBean.getFilters().put("authc", new CustomFormAuthenticationFilter());
        shiroFilterFactoryBean.getFilters().put("perms", new CustomPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.getFilters().put("roles", new CustomRolesAuthorizationFilter());
        filterChainDefinitionMap.put("/role/**", "authc,perms[admin:role]");
        filterChainDefinitionMap.put("/user/**", "authc,perms[admin:user]");
        filterChainDefinitionMap.put("/app/**", "authc,perms[admin:user]");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Override
    public void setEnvironment(Environment env) {
        String loginRequiredStr = env.getProperty("login.required");
        if(StringUtils.isEmpty(loginRequiredStr)){
            log.error("property login.required cannot be null");
            throw new SPIException(BasicEcode.FAILED);
        }
        loginRequired = new Boolean(loginRequiredStr);

        loginUrl = env.getProperty("login.url");
        if(StringUtils.isEmpty(loginUrl)){
            log.error("property login.url cannot be null");
            throw new SPIException(BasicEcode.FAILED);
        }

        successUrl = env.getProperty("success.url");
        if(StringUtils.isEmpty(successUrl)){
            log.error("property success.url cannot be null");
            throw new SPIException(BasicEcode.FAILED);
        }

        // 默认关闭跨域
        String corsEnableStr = env.getProperty("cors.enable");
        if(StringUtils.isNotEmpty(corsEnableStr))
            corsEnable = new Boolean(corsEnableStr);
    }
}
