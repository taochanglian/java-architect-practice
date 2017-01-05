package com.test.javaarchitect.alibaba.rocketmq.quickstart;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.common.RemotingUtil;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Created by tao on 17/1/5.
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("quickstart_producer");
        producer.start();
        try {
            for (int i = 0; i < 100; i++) {
                // public Message(String topic, String tags, byte[] body)
                Message message = new Message("TopicQuickStart", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(message);
                LocalTransactionExecuter executer = new LocalTransactionExecuter() {
                    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
                        return null;
                    }
                };
                System.out.println(sendResult);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
            Thread.sleep(1000);
        }

        producer.shutdown();

    }
}
