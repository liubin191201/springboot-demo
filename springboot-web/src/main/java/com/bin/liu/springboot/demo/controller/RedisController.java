package com.bin.liu.springboot.demo.controller;

import com.alibaba.fastjson.JSON;
import com.bin.liu.springboot.demo.springboot.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-parent
 * @description: redis测试
 * @author: bin.liu
 * @create: 2019-03-18 11:31
 **/

@RestController
@RequestMapping(value = "/redis")
@Api(tags = "redis测试")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisService redisService;


    @GetMapping(value = "set/{key}/{value}")
    @ApiOperation("设置缓存")
    public String set(@PathVariable("key") String key,@PathVariable("value") String value){
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }

    @GetMapping(value = "get/{key}")
    @ApiOperation("根据key获取缓存")
    public String get(@PathVariable("key") String key){
        Object o = redisTemplate.opsForValue().get(key);
        return JSON.toJSONString(o);
    }

    @GetMapping(value = "service/set/{key}/{value}")
    @ApiOperation("设置缓存")
    public String serviceSet(@PathVariable("key") String key,@PathVariable("value") String value){
        redisService.set(key, value, null);
        return key + "," + value;
    }

    @GetMapping(value = "service/get/{key}")
    @ApiOperation("根据key获取缓存")
    public String serviceGet(@PathVariable("key") String key){
        return redisService.get(key).toString();
    }

    @PostMapping(value = "service/set/list")
    @ApiOperation("设置list")
    public void setList(){
        List<Object> data = new ArrayList<>();
        data.add("小明");
        data.add("小红");
        data.add("小丽");
        redisService.setListCollection("student", data, 10L);

    }


}
