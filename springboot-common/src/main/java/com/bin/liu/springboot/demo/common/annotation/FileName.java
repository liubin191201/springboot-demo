package com.bin.liu.springboot.demo.common.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileName {

    String value() default "";
}
