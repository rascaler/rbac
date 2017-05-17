package com.redding.rbac.web.config;

import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import com.redding.rbac.web.utils.context.ResponseBodyWrapFactoryBean;
import com.redding.rbac.web.utils.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by redding on 4/2/17.
 */
@Configuration
public class MvcConfig {

    @Bean
    ApplicationContextUtils getApplicationContextProvider(){return new ApplicationContextUtils();}

    @Bean
    ResponseBodyWrapFactoryBean getResponseBodyWrapFactoryBean(){return new ResponseBodyWrapFactoryBean();}

    @Bean
    CorsFilter getCorsFilter(){
       return new CorsFilter();
    }
}

