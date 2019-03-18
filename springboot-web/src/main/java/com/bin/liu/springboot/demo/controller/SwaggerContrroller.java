package com.bin.liu.springboot.demo.controller;

import com.bin.liu.springboot.demo.common.ResultDto;
import com.bin.liu.springboot.demo.common.eume.UserOperateEnum;
import com.bin.liu.springboot.demo.entity.TsUser;
import com.bin.liu.springboot.demo.exception.CommonExceptionHandler;
import com.bin.liu.springboot.demo.requst.UserReq;
import com.bin.liu.springboot.demo.service.TsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: springboot-parent
 * @description: swagger控制器
 * @author: bin.liu
 * @create: 2019-03-18 06:23
 **/

@RestController
@RequestMapping("/user")
@Api(tags = {"用户API"})
public class SwaggerContrroller {

    @Resource
    private TsUserService tsUserService;


    @PostMapping(value = "add")
    @ApiOperation(value = "用户新增")
    public ResultDto addUser(@Valid @RequestBody UserReq userReq){

        TsUser user = new TsUser();
        user.setId(userReq.getId());
        user.setName(userReq.getName());
        user.setLevel(userReq.getLevel());

        tsUserService.insert(user);
        return ResultDto.SUCCESS(null);
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "用户查询")
    @ApiParam(name = "id",value = "查询ID",required = true)
    public ResultDto getUser(@PathVariable("id") Long id){
        TsUser user = tsUserService.selectById(id);
        if (null == user){
            return ResultDto.FAIL(UserOperateEnum.USER_NOT_EXESIT.getValue(), UserOperateEnum.USER_NOT_EXESIT.getMessage());
        }
        return ResultDto.SUCCESS(user);
    }


}
