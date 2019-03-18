package com.bin.liu.springboot.demo.controller;

import com.bin.liu.springboot.demo.springboot.activemq.producer.TestQueueProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: activemq
 * @author: bin.liu
 * @create: 2019-03-18 17:39
 **/

@RestController
@RequestMapping(value = "/activemq")
@Api(tags = "activemq消息")
public class ActivemqController {

    @Resource
    private TestQueueProducer testQueueProducer;

    @GetMapping(value = "send")
    @ApiOperation("发送消息")
    public void sendMessage(){
        int i = 0;
        while (i<100){
            String messageBody = "message" + i;
            testQueueProducer.sendMessageToQueue(messageBody);
            i++;
        }
        System.out.println("消息发送完成");

    }
}
