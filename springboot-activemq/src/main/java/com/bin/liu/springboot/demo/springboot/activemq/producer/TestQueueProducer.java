package com.bin.liu.springboot.demo.springboot.activemq.producer;

import com.alibaba.fastjson.JSON;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @program: springboot-parent
 * @description: test_queue发送消息
 * @author: bin.liu
 * @create: 2019-03-18 16:20
 **/

@Service("testQueueProducer")
//@EnableScheduling
public class TestQueueProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Queue testQueue;



    public void sendMessageToQueue(final Object messageBody){
      jmsTemplate.send(testQueue, new MessageCreator() {
          @Override
          public Message createMessage(Session session) throws JMSException {
              TextMessage textMessage = session.createTextMessage(JSON.toJSONString(messageBody));
              return textMessage;
          }
      });
    }



}
