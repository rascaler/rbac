package com.redding.rbac.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:43
 */
@SpringBootApplication(scanBasePackages = "com.redding.rbac")
@ImportResource({"classpath:spring-context.xml","classpath:spring-mvc.xml"})
@PropertySource({"classpath:application.properties"})
public class WebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

}
