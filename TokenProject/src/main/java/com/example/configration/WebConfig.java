package com.example.configration;

import com.example.annotation.MyNeedtokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myNeedtokenInterceptor());
    }

    @Bean
    public MyNeedtokenInterceptor myNeedtokenInterceptor() {
        return new MyNeedtokenInterceptor();
    }

}
