package com.Jayce.ActiveMQ.Service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service
public class ConsumerService {
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination){
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        if(null == textMessage){
            System.out.println("队列数据已被消费完毕======================");
            return null;
        }
        try{
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + textMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textMessage;
    }
}
