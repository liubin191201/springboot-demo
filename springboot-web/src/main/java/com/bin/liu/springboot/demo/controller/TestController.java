package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.common.TestConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: 测试
 * @author: bin.liu
 * @create: 2019-03-14 15:33
 **/

@Api(tags = "demo")
@RestController
public class TestController {

    @Value("${user.name}")
    private String name;

    @Resource
    private TestConfig testConfig;

    @ApiOperation(value = "demo")
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(){
        return name;
    }

    @ApiOperation("config")
    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public String config(){
        return JSON.toJSONString(testConfig);
    }


}
