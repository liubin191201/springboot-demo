package com.bin.liu.springboot.demo.common.eume;

/**
 * @program: springboot-parent
 * @description: 文件相关状态码
 * @author: bin.liu
 * @create: 2019-03-19 14:05
 **/

public enum FileUpLoadEnum {

    FILE_IS_NULL(500001L,"文件为空"),
    FILE_UP_LOAD_SUCCESS(200001L,"文件上传成功"),
    FILE_UP_LOAD_FAIL_(500002L,"文件上传失败"),
    FILE_DWON_SUCCESS(200002L,"文件下载成功"),
    FILE_DWON_FAIL(500003L,"文件下载失败");

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

    FileUpLoadEnum(Long value, String message) {
        this.value = value;
        this.message = message;
    }}
