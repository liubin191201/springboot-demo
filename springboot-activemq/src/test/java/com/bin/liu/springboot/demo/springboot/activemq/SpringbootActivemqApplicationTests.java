package com.bin.liu.springboot.demo.springboot.activemq;

import com.bin.liu.springboot.demo.springboot.activemq.consumer.TestQueueConsumer;
import com.bin.liu.springboot.demo.springboot.activemq.producer.TestQueueProducer;
import junit.textui.TestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRunner.class)
public class SpringbootActivemqApplicationTests {

    @Resource
    private TestQueueProducer testQueueProducer;

    @Resource
    private TestQueueConsumer testQueueConsumer;

    @Test
    public void sendMessage(){
       int i = 0;
       while (i<100){
           String messageBody = "message" + i;
           testQueueProducer.sendMessageToQueue(messageBody);
           i++;
       }
        System.out.println("消息发送完成");
    }


}
