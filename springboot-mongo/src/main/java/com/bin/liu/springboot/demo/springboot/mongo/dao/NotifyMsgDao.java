package com.bin.liu.springboot.demo.springboot.mongo.dao;

import com.bin.liu.springboot.demo.springboot.mongo.entity.NotifyMsg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


/**
 * @program: springboot-parent
 * @description: notifyMsgDao
 * @author: bin.liu
 * @create: 2019-03-23 20:33
 **/

public interface NotifyMsgDao extends MongoRepository<NotifyMsg,String> {

    NotifyMsg findByNotifyNo(String notifyNo);

    @Query("{'notifyDate':?0}")
    Page<NotifyMsg> queryBySql(String notifyDate, Pageable pageable);


}
