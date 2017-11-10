package com.redding.rbac.web.config;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletException;

/**
    kaptcha:
            session:
            key: kaptcha.code
            #border: no
            #渲染效果：水纹：WaterRipple；鱼眼：FishEyeGimpy；阴影：ShadowGimpy
            obscurificator:
            impl: com.google.code.kaptcha.impl.WaterRipple
            #不要噪点
            noise:
            impl: com.google.code.kaptcha.impl.NoNoise
            image:
            width: 90
            height: 33
            textproducer:
            font:
            size: 25
            color: black
            char:
            length: 4
            space: 5
            #和登录框背景颜色一致
            background:
            clear:
            from: 247,247,247
            to: 247,247,247
*/

@Configuration
public class KaptchaConfig extends WebMvcConfigurerAdapter {

    /*@Value("${kaptcha.border}")
    private String kborder;*/

//    @Value("${kaptcha.session.key}")
//    private String skey;
//
//    @Value("${kaptcha.textproducer.font.color}")
//    private String fcolor;
//
//    @Value("${kaptcha.textproducer.font.size}")
//    private String fsize;
//
//    @Value("${kaptcha.obscurificator.impl}")
//    private String obscurificator;
//
//    @Value("${kaptcha.noise.impl}")
//    private String noise;
//
//    @Value("${kaptcha.image.width}")
//    private String width;
//
//    @Value("${kaptcha.image.height}")
//    private String height;
//
//    @Value("${kaptcha.textproducer.char.length}")
//    private String clength;
//
//    @Value("${kaptcha.textproducer.char.space}")
//    private String cspace;
//
//    @Value("${kaptcha.background.clear.from}")
//    private String from;
//
//    @Value("${kaptcha.background.clear.to}")
//    private String to;

//    kaptcha.session.key = kaptcha.code
//    kaptcha.obscurificator.impl = com.google.code.kaptcha.impl.WaterRipple
//    kaptcha.noise.impl = com.google.code.kaptcha.impl.NoNoise
//    kaptcha.image.width = 110
//    kaptcha.image.height = 36
//    kaptcha.textproducer.font.size = 25
//    kaptcha.textproducer.font.color = black
//    kaptcha.textproducer.char.length = 4
//    kaptcha.textproducer.char.space = 5
//    kaptcha.background.clear.from = 247,247,247
//    kaptcha.background.clear.to = 247,247,247
    @Bean
    public ServletRegistrationBean servletRegistrationBean() throws ServletException{
        ServletRegistrationBean servlet = new ServletRegistrationBean(new KaptchaServlet(),"/images/kaptcha.jpg");
//        servlet.addInitParameter("kaptcha.border", "no"/*kborder*/);//无边框
//        servlet.addInitParameter("kaptcha.session.key", skey);//session key
//        servlet.addInitParameter("kaptcha.textproducer.font.color", fcolor);
//        servlet.addInitParameter("kaptcha.textproducer.font.size", fsize);
//        servlet.addInitParameter("kaptcha.obscurificator.impl", obscurificator);
//        servlet.addInitParameter("kaptcha.noise.impl", noise);
//        servlet.addInitParameter("kaptcha.image.width", width);
//        servlet.addInitParameter("kaptcha.image.height", height);
//        servlet.addInitParameter("kaptcha.textproducer.char.length", clength);
//        servlet.addInitParameter("kaptcha.textproducer.char.space", cspace);
//        servlet.addInitParameter("kaptcha.background.clear.from", from); //和登录框背景颜色一致
//        servlet.addInitParameter("kaptcha.background.clear.to", to);

        servlet.addInitParameter("kaptcha.session.key", "securityCode");
        servlet.addInitParameter("kaptcha.textproducer.char.length", "4");
        servlet.addInitParameter("kaptcha.textproducer.font.color", "red");
        servlet.addInitParameter("kaptcha.textproducer.font.size", "25");
        servlet.addInitParameter("kaptcha.textproducer.char.space", "5");
        servlet.addInitParameter("kaptcha.image.width", "110");
        servlet.addInitParameter("kaptcha.image.height", "36");
        servlet.addInitParameter("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        return servlet;
    }
}