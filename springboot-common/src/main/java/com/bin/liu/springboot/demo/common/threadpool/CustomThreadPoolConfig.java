package com.bin.liu.springboot.demo.common.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

/**
 * @program: springboot-parent
 * @description: 自定义线程池
 * @author: bin.liu
 * @create: 2019-03-22 07:23
 **/

@Configuration
@EnableAsync
public class CustomThreadPoolConfig {

    @Resource
    private ThreadPoolPropertyConfig threadPoolPropertyConfig;

    /**
     * 自定义线程池
     * @return
     */
    @Bean(name = "scheduledPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(threadPoolPropertyConfig.getCorePoolSize());
        taskExecutor.setMaxPoolSize(threadPoolPropertyConfig.getMaxPoolSize());
        taskExecutor.setQueueCapacity(threadPoolPropertyConfig.getQueueCapacity());
        taskExecutor.setKeepAliveSeconds(threadPoolPropertyConfig.getKeepAliveSeconds());
        taskExecutor.setThreadNamePrefix(threadPoolPropertyConfig.getThreadNamePrefix());
        taskExecutor.setAwaitTerminationSeconds(threadPoolPropertyConfig.getAwaitTerminationSeconds());
        return taskExecutor;
    }
}
