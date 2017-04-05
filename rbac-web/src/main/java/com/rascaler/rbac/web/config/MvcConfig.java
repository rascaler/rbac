package com.rascaler.rbac.web.config;

import com.rascaler.rbac.web.context.ApplicationContextProvider;
import com.rascaler.rbac.web.context.ResponseBodyWrapFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rascaler on 4/2/17.
 */
@Configuration
public class MvcConfig {

    @Bean
    ApplicationContextProvider getApplicationContextProvider(){return new ApplicationContextProvider();}

    @Bean
    ResponseBodyWrapFactoryBean getResponseBodyWrapFactoryBean(){return new ResponseBodyWrapFactoryBean();}

}
