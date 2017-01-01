package com.test.javaarchitect.disruptor.demo2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.test.javaarchitect.disruptor.demo1.Order;

public class TradePublisher implements Runnable{
	Disruptor<Order> disruptor;
	private CountDownLatch latch;
	
	private static int LOOP = 10;

	public TradePublisher(CountDownLatch latch,Disruptor<Order> disruptor) {
		this.latch = latch;
		this.disruptor = disruptor;
	}
	@Override
	public void run() {
		TradeEventTranslator tradeEventTranslator = new TradeEventTranslator();
		for(int i=0;i<LOOP;i++) {
			disruptor.publishEvent(tradeEventTranslator);
		}
		latch.countDown();
	}

}

class TradeEventTranslator implements EventTranslator<Order> {
	private Random random = new Random();
	@Override
	public void translateTo(Order event, long sequence) {
		this.generateOrder(event);
	}
	
	private Order generateOrder(Order order) {
		order.setPrice(random.nextDouble() * 9999);
		return order;
	}
	
}































