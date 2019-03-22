package com.bin.liu.springboot.demo;

import com.bin.liu.springboot.demo.filter.Custom2Filter;
import com.bin.liu.springboot.demo.filter.Custom3Filter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.Filter;

/**
 * @program: springboot-parent
 * @description: 启动类
 * @author: bin.liu
 * @create: 2019-03-14 15:31
 **/


@ComponentScan(basePackages = {"com.bin.liu.springboot.demo"})
@MapperScan("com.bin.liu.springboot.demo.mapper")
@EnableAutoConfiguration()
@PropertySource(value = {"classpath:application.properties","classpath:service.application.properties","classpath:dao.application.properties",
        "classpath:entity.application.properties","classpath:common.application.properties","classpath:redis.application.properties","classpath:activemq.application.properties"},
        ignoreResourceNotFound = true,encoding = "utf-8")
//扫描filter,listener,interceptor
@ServletComponentScan
//引入资源文件，入spring配置文件
//@ImportResource(locations = {})
//定时
@EnableScheduling
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean custom2FilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(custom2Filter());
        registration.setName("custom2Filter");
        registration.addUrlPatterns("/*");
        registration.setOrder(3);
        return registration;
    }
    @Bean
    public Filter custom2Filter(){
        return new Custom2Filter();
    }


    @Bean
    public FilterRegistrationBean custom3FilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(custom3Filter());
        registration.setName("custom3Filter");
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }
    @Bean
    public Filter custom3Filter(){
        return new Custom3Filter();
    }


    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }


}
