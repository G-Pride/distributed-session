package com.imooc.distributedsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIntercepter loginIntercepter;

    //addPathPatterns 拦截的请求
    //excludePathPatterns 不拦截的请求
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercepter)
                .addPathPatterns("/user/uid")  //  /user/**
                .addPathPatterns("/user/infoWithJwt");

//        registry.addInterceptor(loginIntercepter)
//                .addPathPatterns("/user/**")   //未登录的都会被拦截
//                .excludePathPatterns("/user/login");
    }
}
