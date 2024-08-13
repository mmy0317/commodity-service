package com.mayang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，并设置拦截的路径和排除的路径
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/login","/register", "/static/**", "/css/**", "/js/**", "/images/**"); // 排除登录接口和静态资源
    }
}
