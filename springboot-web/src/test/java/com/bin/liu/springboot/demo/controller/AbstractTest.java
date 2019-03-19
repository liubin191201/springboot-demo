package com.bin.liu.springboot.demo.controller;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: 测试基类
 * @author: bin.liu
 * @create: 2019-03-19 10:53
 **/

public abstract class AbstractTest {

    @Resource
    public WebApplicationContext context;

    public MockMvc mockMvc;

    @Before
    public void beforeSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
