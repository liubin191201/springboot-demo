package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.common.TestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: 测试
 * @author: bin.liu
 * @create: 2019-03-14 15:33
 **/

@RestController
public class TestController {

    @Value("${user.name}")
    private String name;

    @Resource
    private TestConfig testConfig;

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(){
        return name;
    }

    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public String config(){
        return JSON.toJSONString(testConfig);
    }
}
