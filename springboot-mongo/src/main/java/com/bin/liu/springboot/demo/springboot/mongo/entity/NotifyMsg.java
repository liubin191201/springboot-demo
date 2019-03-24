package com.bin.liu.springboot.demo.springboot.mongo.entity;

import com.bin.liu.springboot.demo.common.annotation.FileName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @program: springboot-parent
 * @description: 消息通知对象
 * @author: bin.liu
 * @create: 2019-03-23 20:26
 **/

@Document(collection = "notify_msg")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotifyMsg {

    @Id
    @FileName("id")
    private String id;

    @Indexed
    @FileName("消息类型")
    private String notifyType;

    @Indexed
    @FileName("消息单号")
    private String notifyNo;

    @FileName("消息通知日期")
    private String notifyDate;

    @Field("notifyMsg")
    @FileName("消息体")
    private String notifyMsg;

    @CreatedDate
    @FileName("创建时间")
    private Date gmtCreate;

}
