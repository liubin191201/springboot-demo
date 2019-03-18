package com.bin.liu.springboot.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-parent
 * @description: 自定义异常处理
 * @author: bin.liu
 * @create: 2019-03-17 20:33
 **/

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        Map<String,Object> result = new HashMap<>();
        result.put("resCode", "9999");
        result.put("resMsg", e.getMessage());
        return result;
    }

}
