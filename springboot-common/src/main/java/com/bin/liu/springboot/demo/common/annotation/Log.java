package com.bin.liu.springboot.demo.common.annotation;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Log {

    @AliasFor("desc")
    String value() default "";

    @AliasFor("value")
    String desc() default "";

    boolean ignore() default false;

}
