package com.cloud.mall.ccmweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web配置
 *
 * @author Jon_China
 * @create 2017/11/11
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getUserAuthInterceptor(){
        return new UserAuthInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserAuthInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/user-login"
                ,"/get-public-key"
                ,"/captcha-image");
    }
}
