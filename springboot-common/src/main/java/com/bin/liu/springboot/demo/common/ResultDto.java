package com.bin.liu.springboot.demo.common;

import com.bin.liu.springboot.demo.common.annotation.FileName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-parent
 * @description: 返回结果统一格式
 * @author: bin.liu
 * @create: 2019-03-18 06:55
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    private static final Long SUCCESS_CODE = 200L;

    private static final Long FAIL_CODE = 500L;

    private static final String SUCCESS_MESSAGE= "操作成功";

    private static final String FAIL_MESSAGE = "操作失败";

    @FileName("状态码")
    private Long code;

    @FileName(value = "消息")
    private String message;


    @FileName(value = "数据")
    private Object content;


    public static ResultDto SUCCESS(Object content){
        ResultDto resultDto = new ResultDto(SUCCESS_CODE, SUCCESS_MESSAGE, content);
        return resultDto;
    }
    public static ResultDto SUCCESS(Long code,Object content){
        ResultDto resultDto = new ResultDto(code, SUCCESS_MESSAGE, content);
        return resultDto;
    }

    public static ResultDto FAIL(String message){
         ResultDto resultDto = new ResultDto(FAIL_CODE, message, null);
         return resultDto;
    }

    public static ResultDto FAIL(Long code,String message){
        ResultDto resultDto = new ResultDto(code, message, null);
        return resultDto;
    }

}
