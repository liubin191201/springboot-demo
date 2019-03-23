package com.bin.liu.springboot.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-parent
 * @description: 打印定时任务
 * @author: bin.liu
 * @create: 2019-03-22 07:12
 **/

@Component
@Slf4j
public class PrintTask {

    int count = 1;


    @Async(value = "scheduledPoolTaskExecutor")
    @Scheduled(cron = "*/5 * * * * ?")
    public void print(){
        //log.info("定时任务打印,当前次数:" + count);
        count++;
    }
}
