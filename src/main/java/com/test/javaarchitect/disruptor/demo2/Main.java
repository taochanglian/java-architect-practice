package com.test.javaarchitect.disruptor.demo2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import com.test.javaarchitect.disruptor.demo1.Order;
//生产者p1生产数据，同时发送给c1，c2
//c1 c2都消费完以后，在传递给C3
public class Main {
	public static void main(String[] args) throws InterruptedException {
		long beginTime = System.currentTimeMillis();
		int bufferSize = 1024;
		int THREAD_NUM = 8;
		
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);
		Disruptor disruptor = new Disruptor<Order>(new EventFactory<Order>() {
			@Override
			public Order newInstance() {
				return new Order();
			}
		}, bufferSize, executor, ProducerType.SINGLE, new BusySpinWaitStrategy());
		//菱形操作
		//使用disruptor创建消费者组 c1 c2
		EventHandlerGroup<Order> handleGroup = disruptor.handleEventsWith(new Handler1(),new Handler2());
		//c1 c2 执行结束后，传递给c3
		handleGroup.then(new Handler3());
		
		//六边形操作
//		Handler1 h1 = new Handler1();
//		Handler2 h2 = new Handler2();
//		Handler3 h3 = new Handler3();
//		Handler4 h4 = new Handler4();
//		Handler5 h5 = new Handler5();
//		disruptor.handleEventsWith(h1,h2);
//		disruptor.after(h1).handleEventsWith(h4);
//		disruptor.after(h2).handleEventsWith(h5);
//		disruptor.after(h4,h5).handleEventsWith(h3);
		
		//顺序执行
//		disruptor.handleEventsWith(new Handler1()).handleEventsWith(new Handler2()).handleEventsWith(new Handler3());		
		
		disruptor.start();
		CountDownLatch latch = new CountDownLatch(1);
		executor.submit(new TradePublisher(latch,disruptor));
		
		latch.await();//等待生产者完事
		disruptor.shutdown();
		executor.shutdown();
		System.out.println("总耗时："+(System.currentTimeMillis() - beginTime));
		
	}
}















































