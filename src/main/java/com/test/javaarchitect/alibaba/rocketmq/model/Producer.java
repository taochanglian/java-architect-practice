package com.test.javaarchitect.alibaba.rocketmq.model;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Created by tao on 17/1/6.
 */
public class Producer {
    public static void main(String[] args) throws MQClientException,  InterruptedException {
        String group_name = "message_producer";
        DefaultMQProducer producer = new DefaultMQProducer(group_name);

        producer.setNamesrvAddr("ip:port");
        producer.start();

        try {
            for (int i = 0; i <= 100; i++) {
                Message msg = new Message("Topic1",
                        "Tag1",
                        ("信息内容:" + i).getBytes()
                );
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);

            }
        }catch(Exception ex) {
            ex.printStackTrace();
            Thread.sleep(1000);
        }

        producer.shutdown();


    }
}


























































