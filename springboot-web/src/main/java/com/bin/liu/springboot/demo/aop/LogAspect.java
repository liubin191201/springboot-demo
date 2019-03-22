package com.bin.liu.springboot.demo.aop;

import com.bin.liu.springboot.demo.common.annotation.Log;
import com.bin.liu.springboot.demo.common.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: springboot-parent
 * @description: 日志切面类
 * @author: bin.liu
 * @create: 2019-03-22 15:22
 **/

@Aspect
@Slf4j
@Component
public class LogAspect {


    /**
     * 设置切入点
     */
    @Pointcut("within(com.bin.liu.springboot.demo.controller.*)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{

        //开始时间
        long beginTime = System.currentTimeMillis();
        //利用RequestContentHolder获取request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        String uri = requestAttributes.getRequest().getRequestURI();

        log.info("开始计时:{} URI:{}",new Date(),uri);
        //访问目标方法的参数 可动态改变参数值
        Object[] args = joinPoint.getArgs();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        log.info("请求方法:{},请求参数:{}",methodName, Arrays.toString(args));
        //获取ip
        IPUtil.getIpAddr(requestAttributes.getRequest());

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)){
            throw new IllegalAccessError("暂不支持非方法注解");
        }

        //调用实际方法
        Object object = joinPoint.proceed();
        //获取执行的方法
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //判断是否包含了 无需记录日志的方法
        Log logAnnotation = AnnotationUtils.getAnnotation(method, Log.class);
        if (logAnnotation != null && !logAnnotation.ignore()){
            log.info("执行了日志记录方法");
            return object;
        }

        log.info("log注解描述:{}",logAnnotation.desc());
        long endTime = System.currentTimeMillis();
        log.info("结束计时:{},URI:{},耗时:{}",new Date(),uri,(endTime - beginTime));

        return object;
    }


    @AfterThrowing(pointcut = "pointcut()",throwing = "e")
    public void afterThrowable(Throwable e){
        log.error("切面发生异常",e);
    }







}
