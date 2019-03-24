package com.bin.liu.springboot.demo.mongodb;

import com.bin.liu.springboot.demo.common.ResultDto;
import com.bin.liu.springboot.demo.springboot.mongo.dao.NotifyMsgDao;
import com.bin.liu.springboot.demo.springboot.mongo.entity.NotifyMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: springboot-parent
 * @description: mongodb
 * @author: bin.liu
 * @create: 2019-03-23 20:38
 **/

@RestController
@RequestMapping(value = "/mongo")
@Slf4j
@Api(tags = "mongo操作")
public class MongoDbController {

    @Resource
    private NotifyMsgDao notifyMsgDao;

    @Resource
    private MongoTemplate mongoTemplate;

    @PostMapping(value = "save")
    @ApiOperation("新增")
    public ResultDto save(NotifyMsg msg){
        try {
            msg.setGmtCreate(new Date());
            notifyMsgDao.save(msg);
        } catch (Exception e) {
            log.error("save error",e);
            return ResultDto.FAIL("save error");
        }

        return ResultDto.SUCCESS("success");

    }
}
