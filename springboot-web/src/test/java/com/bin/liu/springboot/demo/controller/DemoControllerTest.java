package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.WebApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program: springboot-parent
 * @description: controller测试
 * @author: bin.liu
 * @create: 2019-03-19 10:38
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//测试单一接口时 ，也可利用注解@WebMvcTest 进行单一测试
//@WebMvcTest(DemoController.class)
public class DemoControllerTest extends AbstractTest{


    @Test
    public void demoTest()throws Exception{
        MvcResult result = mockMvc.perform(get("/demo")).andDo(print()).andExpect(status().isOk())
                .andReturn();
        log.info(result.getResponse().toString());
    }

    @Test
    public void redisAddStringTest()throws Exception{
        String key = "liuliu";
        String value = "binbin";
        String uri = "/redis/set/{key}/{value}";
        uri = uri.replace("{key}",  key );
        uri = uri.replace("{value}", value);
        mockMvc.perform(get(uri)).andDo(print()).andExpect(status().isOk()).andReturn();
    }







}
