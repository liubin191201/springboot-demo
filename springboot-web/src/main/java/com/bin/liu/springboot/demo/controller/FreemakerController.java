package com.bin.liu.springboot.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot-parent
 * @description: freemaker测试
 * @author: bin.liu
 * @create: 2019-03-19 13:45
 **/

@Controller
@RequestMapping(value = "/freemaker")
@Api(tags = "freemaker测试")
public class FreemakerController {

    @GetMapping(value = "hello")
    @ApiOperation("返回hello页面")
    public String hello(ModelMap modelMap){
        modelMap.put("name", "liuliu");
        modelMap.put("from", "china");
        return "hello";
    }
}
