package com.bin.liu.springboot.demo.common.threadpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-parent
 * @description: 线程池属性定义
 * @author: bin.liu
 * @create: 2019-03-22 07:34
 **/

@Component
@ConfigurationProperties(prefix="taskexecutor")
@Data
public class ThreadPoolPropertyConfig {


     private Integer corePoolSize;

     private Integer maxPoolSize;

     private Integer queueCapacity;

     private Integer keepAliveSeconds;

     private String threadNamePrefix;

     private Integer awaitTerminationSeconds;






}
