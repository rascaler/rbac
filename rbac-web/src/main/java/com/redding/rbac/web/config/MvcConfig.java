package com.redding.rbac.web.config;

import com.redding.rbac.web.context.ApplicationContextProvider;
import com.redding.rbac.web.context.ResponseBodyWrapFactoryBean;
import com.redding.rbac.web.utils.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
