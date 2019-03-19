package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.WebApplication;
import com.bin.liu.springboot.demo.entity.TsUser;
import com.bin.liu.springboot.demo.filter.Custom2Filter;
import com.bin.liu.springboot.demo.filter.Custom3Filter;
import com.bin.liu.springboot.demo.service.TsUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @program: springboot-parent
 * @description:
 * @author: bin.liu
 * @create: 2019-03-19 07:02
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class TsUserServiceTest {

    @Autowired
    private TsUserService tsUserService;

    @Test
    public void findByIdTest(){
        TsUser user = tsUserService.selectById(1);
        log.info(JSON.toJSONString(user));
    }

}
