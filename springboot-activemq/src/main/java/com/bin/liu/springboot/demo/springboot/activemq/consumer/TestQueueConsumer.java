package com.bin.liu.springboot.demo.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @program: springboot-parent
 * @description: testQueue消费
 * @author: bin.liu
 * @create: 2019-03-18 17:09
 **/

@Component()
public class TestQueueConsumer {


    @JmsListener(destination = "${queue.testQueue.name}",containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(Message message) throws JMSException{
        TextMessage textMessage = (TextMessage) message;
        System.out.println("TestQueueConsumer接收的报文为:" + textMessage.getText());

    }
}
