package com.bin.liu.springboot.demo.controller;

import com.bin.liu.springboot.demo.common.ResultDto;
import com.bin.liu.springboot.demo.common.eume.FileUpLoadEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: springboot-parent
 * @description: 文件上传
 * @author: bin.liu
 * @create: 2019-03-19 14:01
 **/

@RestController(value = "/file")
@Slf4j
@Api(tags = "文件操作")
public class FileUpLoadController {

    //文件目录
    private static final String FILE_PAHT="/Users/liubin/Downloads/";


    @PostMapping(value = "uplaod")
    @ApiOperation("文件上传")
    @ApiParam(name = "file",value = "文件",required = true)
    public ResultDto fileUpLoad(@RequestParam MultipartFile file)throws IllegalStateException, IOException{
        if (file == null){
            return ResultDto.FAIL(FileUpLoadEnum.FILE_IS_NULL.getValue(), FileUpLoadEnum.FILE_IS_NULL.getMessage());
        }

        //文件类型
        String contentType = file.getContentType();

        //文件名称
        String fileName = file.getName();

        //原文件名称
        String originalFilename = file.getOriginalFilename();

        //文件大小
        long size = file.getSize();

        log.info("上传文件,文件类型:%s,文件名称:%s,原文件名称:%s,文件大小%n",contentType,fileName,originalFilename,size);
        //保存文件
        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");

        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        File newFile = new File(FILE_PAHT + newFileName  + suffix);
        file.transferTo(newFile);
        return ResultDto.SUCCESS(FileUpLoadEnum.FILE_UP_LOAD_SUCCESS.getValue(), FileUpLoadEnum.FILE_UP_LOAD_SUCCESS.getMessage());
    }
}
