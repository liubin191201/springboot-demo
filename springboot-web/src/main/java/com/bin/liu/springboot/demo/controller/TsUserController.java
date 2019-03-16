package com.bin.liu.springboot.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bin.liu.springboot.demo.entity.TsUser;
import com.bin.liu.springboot.demo.service.TsUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<TsUser> list(){
        EntityWrapper wrapper = new  EntityWrapper<TsUser>();
        wrapper.eq("name", "小疯子");
        List<TsUser> tsUsers = tsUserService.selectList(wrapper);
        return tsUsers;
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public List<TsUser> page(@RequestParam("page_size")Integer pageSize,@RequestParam("page_num")Integer pageNumber,TsUser user){
        if (pageNumber == null){
            pageNumber = 1;
        }
        if (pageSize == null){
            pageSize = 5;
        }
        Page<TsUser> page = new Page<>(pageNumber, pageSize);
        Wrapper<TsUser> wrapper = new EntityWrapper<>();
        wrapper.gt("sex", 23);
        List<TsUser> userList = tsUserService.selectPage(page, wrapper).getRecords();
        return userList;


    }




}

