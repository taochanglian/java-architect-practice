package com.test.javaarchitect.disruptor.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.WorkerPool;

public class Main2 {
	public static void main(String[] args) throws InterruptedException {
		int BUFFER_SIZE = 1024*1024;
		int THREAD_NUMBER=4;
		
		EventFactory<Order> eventFactory = new EventFactory<Order>() {
			@Override
			public Order newInstance() {
				return new Order();
			}
		};
		RingBuffer<Order> ringBuffer = RingBuffer.createSingleProducer(eventFactory, BUFFER_SIZE);
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUMBER);
		
		WorkHandler<Order> handler = new OrderHandler();
		WorkerPool workerPool = new WorkerPool<Order>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), handler);
		
		workerPool.start(executor);
		
		//生产8个数据
		for(int i=0;i<8;i++) {
			long seq = ringBuffer.next();
			ringBuffer.get(seq).setPrice(Math.random() * 9999);
			ringBuffer.publish(seq);
		}
		Thread.sleep(1000);;
		workerPool.halt();
		executor.shutdown();
		
		
	}
}




































