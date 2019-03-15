package com.bin.liu.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-parent
 * @description: 测试
 * @author: bin.liu
 * @create: 2019-03-14 15:33
 **/

@RestController
public class TestController {

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String demo(){
        return "hello springboot";
    }
}
