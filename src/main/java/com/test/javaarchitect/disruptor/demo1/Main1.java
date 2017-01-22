package com.test.javaarchitect.disruptor.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class Main1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		int BUFFER_SIZE = 1024*1024;
//		int THREAD_NUMNERS = 4;
//		/**
//		 * createSingleProducer创建一个单生产者的producer
//		 */
//		RingBuffer<Order> ringBuffer = RingBuffer.createSingleProducer(new EventFactory<Order>() {
//			@Override
//			public Order newInstance() {
//				return new Order();
//			}
//
//		}, BUFFER_SIZE, new YieldingWaitStrategy());
//
//		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(THREAD_NUMNERS);
//		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
//		//创建消费
//		BatchEventProcessor<Order> batchEventProcessor = new BatchEventProcessor<Order>(ringBuffer, sequenceBarrier, new OrderHandler());
//		//消费者的位置信息引入到生产者，如果只有一个消费者的情况可以省略
//		ringBuffer.addGatingSequences(batchEventProcessor.getSequence());
//		//把消息处理器提交给框架
//		newFixedThreadPool.submit(batchEventProcessor);
//
//		Future<?> future = newFixedThreadPool.submit(new Callable<Void>() {
//			@Override
//			public Void call() throws Exception {
//				long seq;
//				for(int i=0;i<10;i++){
//					seq = ringBuffer.next();//占个坑，ringbuffer一个可用区块
//					ringBuffer.get(seq).setPrice(Math.random() * 9999);//给这个区块放入数据
//					ringBuffer.publish(seq);//发布这个区块使消费端可见
//				}
//
//				return null;
//			}
//		});
//		future.get();//等待生产结束
//		Thread.sleep(1000);//等1秒，消费结束
//		batchEventProcessor.halt();//通知事件处理器，可以结束了
//		newFixedThreadPool.shutdown();//终止线程
		
		
	}
}


















