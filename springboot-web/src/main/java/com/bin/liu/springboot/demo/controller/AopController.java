package com.bin.liu.springboot.demo.controller;

import com.bin.liu.springboot.demo.common.annotation.Log;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-parent
 * @description: aop切面
 * @author: bin.liu
 * @create: 2019-03-22 16:06
 **/

@RestController
@RequestMapping("/aop")
@Slf4j
@Api(tags = "aop切面测试")
public class AopController {


    /**
    * @Description: 日志打印
    * @Param: [hello]
    * @return: java.lang.String
    * @Author: bin.liu
    * @Date: 2019-03-22
    */
    @GetMapping("aopDemo")
    @Log(desc = "请求了aopDemo方法")
    public String aopDemo(String hello){
        return "请求参数:" +  hello;
    }

    @GetMapping("noAopDemo")
    @Log(ignore = true)
    public String noAopDemo(String hello){
        return "此方法不记录日志，请求参数为:" + hello;
    }


}
