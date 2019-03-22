package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.common.threadpool.ThreadPoolPropertyConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: 属性
 * @author: bin.liu
 * @create: 2019-03-22 10:00
 **/
@RestController
@RequestMapping(value = "/config")
@Slf4j
@Api(tags = "属性配置")
public class ConfigPropertiesController {

    @Resource
    private ThreadPoolPropertyConfig threadPoolPropertyConfig;

    @GetMapping(value = "taskExecutorProperties")
    @ApiOperation("线程池参数")
    public String getTaskExecutorProperties(){
        return JSON.toJSONString(threadPoolPropertyConfig);
    }


}
