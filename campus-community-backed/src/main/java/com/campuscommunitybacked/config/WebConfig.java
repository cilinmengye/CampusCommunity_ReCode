package com.campuscommunitybacked.config;

import com.campuscommunitybacked.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //登录和注册不拦截
        registry.addInterceptor(loginInterceptor).
                excludePathPatterns("/user/login", "/user/register","/billboard/queryByShow","/blog","/user/logout");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}) // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
