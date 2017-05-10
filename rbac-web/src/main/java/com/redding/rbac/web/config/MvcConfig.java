package com.redding.rbac.web.config;

import com.redding.rbac.web.context.ApplicationContextProvider;
import com.redding.rbac.web.context.ResponseBodyWrapFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by redding on 4/2/17.
 */
@Configuration
public class MvcConfig {

    @Bean
    ApplicationContextProvider getApplicationContextProvider(){return new ApplicationContextProvider();}

    @Bean
    ResponseBodyWrapFactoryBean getResponseBodyWrapFactoryBean(){return new ResponseBodyWrapFactoryBean();}

}
