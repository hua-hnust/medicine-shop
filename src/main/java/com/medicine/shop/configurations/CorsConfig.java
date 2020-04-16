package com.medicine.shop.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/** 跨域处理
 * @Author xhua
 * @Date 2020/4/13 21:32
 **/
@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 放行哪些原始域
        config.addAllowedOrigin("*");
        // 是否发送cookie信息
        config.setAllowCredentials(true);
        // 放行的请求方式
        config.addAllowedMethod("*");
        // 放行的头部信息
        config.addAllowedHeader("*");
        // 添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        // 将新的CorsFilter注册到FilterRegistrationBean中
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(configSource));
        // 设置优先级
        bean.setOrder(0);
        return bean;
    }
}
