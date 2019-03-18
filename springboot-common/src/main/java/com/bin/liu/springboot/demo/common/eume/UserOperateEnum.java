package com.bin.liu.springboot.demo.common.eume;

/**
 * @program: springboot-parent
 * @description: 用户业务状态码
 * @author: bin.liu
 * @create: 2019-03-18 07:13
 **/

public enum UserOperateEnum {

    ADD_USER_SUCESS(200001L,"添加用户成功"),
    USER_NOT_EXESIT(500002L,"用户不存在");


    private Long value;

    private String message;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    UserOperateEnum(Long value, String message) {
        this.value = value;
        this.message = message;
    }}
