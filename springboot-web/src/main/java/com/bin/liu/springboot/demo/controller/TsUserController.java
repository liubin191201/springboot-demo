package com.bin.liu.springboot.demo.controller;


import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.entity.TsUser;
import com.bin.liu.springboot.demo.service.TsUserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bin.liu123
 * @since 2019-03-15
 */
@Controller
@RequestMapping("/tsUser")
public class TsUserController {

    @Resource
    private TsUserService tsUserService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    private String list(){
        List<TsUser> tsUsers = tsUserService.selectList(null);
        return JSON.toJSONString(tsUsers);
    }

}

