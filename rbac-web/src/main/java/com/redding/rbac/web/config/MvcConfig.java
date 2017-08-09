package com.redding.rbac.web.config;

import com.redding.rbac.web.utils.SessionUtils;
import com.redding.rbac.web.utils.context.ApplicationContextUtils;
import com.redding.rbac.web.utils.context.EmptyToNullFormatAnnotationFormatterFactory;
import com.redding.rbac.web.utils.context.ResponseBodyWrapFactoryBean;
import org.hibernate.validator.HibernateValidator;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by redding on 4/2/17.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Value("${cors.enable}")
    private boolean corsEnable;

    @Bean
    ApplicationContextUtils applicationContextUtils(){return new ApplicationContextUtils();}

    @Bean
    ResponseBodyWrapFactoryBean responseBodyWrapFactoryBean(){return new ResponseBodyWrapFactoryBean();}

    @Bean
    LocalValidatorFactoryBean getLocalValidatorFactoryBean(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        return localValidatorFactoryBean;
    }

    @Bean
    SessionUtils sessionUtils(){
        return new SessionUtils();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        EmptyToNullFormatAnnotationFormatterFactory annoFormater =new EmptyToNullFormatAnnotationFormatterFactory();
        registry.addFormatterForFieldAnnotation(annoFormater);
    }

    //跨域配置，用于开发环境
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(corsEnable)
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowCredentials(true)
                    .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTION")
                    .allowedHeaders("Authorization","x-requested-with","Content-Type","Accept")
                    .maxAge(3600);
    }

}

