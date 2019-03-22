package com.bin.liu.springboot.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: springboot-parent
 * @description: servlet方式实现异步请求
 * @author: bin.liu
 * @create: 2019-03-19 16:07
 **/

@RestController
@Slf4j
@Api(tags = "Servlet方式实现异步请求")
public class ServletController {

    @GetMapping("/servlet/org")
    @ApiOperation("同步")
    public void todo(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Thread.sleep(1000);
        response.getWriter().println("这是【正常】的请求返回");
    }


    @GetMapping(value = "/servlet/async")
    @ApiOperation("异步")
    public void todoAsync(HttpServletRequest request,HttpServletResponse response)throws Exception{
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log.info("执行完成");
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log.info("超时了");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log.error("发生错误",asyncEvent.getThrowable());
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log.info("线程开始");
            }
        });
        asyncContext.setTimeout(200);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    log.info("内部线程:" + Thread.currentThread().getName());
                    asyncContext.getResponse().setCharacterEncoding("utf-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("这是【异步】的请求返回的");
                }catch (Exception e){
                    log.error("异常",e);
                }
            }
        });

        log.info("线程:" + Thread.currentThread().getName());
    }




}
