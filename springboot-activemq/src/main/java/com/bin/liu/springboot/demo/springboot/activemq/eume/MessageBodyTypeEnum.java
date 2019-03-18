package com.bin.liu.springboot.demo.springboot.activemq.eume;

/**
 * @program: springboot-parent
 * @description: 消息体类型
 * @author: bin.liu
 * @create: 2019-03-18 16:25
 **/

public enum MessageBodyTypeEnum {

    TEXT(1,"字符"),
    OBJECT(2,"对象"),
    STREAM(3,"流"),
    BYTE(4,"字节"),
    MAP(5,"map"),
    COMMON(0,"通用");

    private Integer value;
    private String description;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    MessageBodyTypeEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }}
