package com.test.javaarchitect.alibaba.rocketmq.model;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.test.javaarchitect.alibaba.rocketmq.quickstart.Consumer;

import java.util.List;

/**
 * Created by tao on 17/1/6.
 */

public class Consumer1 {
    public Consumer1() {
        try {
            String group_name = "message_consumer";

            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group_name);
            consumer.setNamesrvAddr("ip:port");
            consumer.subscribe("Topic1", "Tag1 || Tag2 || Tag3");

            consumer.registerMessageListener(new Listener());
            consumer.start();
        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    class Listener implements MessageListenerConcurrently {

        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            try {
                for(MessageExt msg : msgs) {
                    String topic = msg.getTopic();
                    String msgBody = new String(msg.getBody(),"utf-8");
                    String tags = msg.getTags();
                    System.out.println("收到消息->topic:"+topic+",tags:"+tags+",message:"+msgBody);
                }
            }catch(Exception ex) {
                ex.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }


    public static void main(String[] args) {
        Consumer1 consumer = new Consumer1();
        System.out.println("consumer start...");
    }
}


























































