package com.test.javaarchitect.disruptor.demo2;

import com.lmax.disruptor.EventHandler;
import com.test.javaarchitect.disruptor.demo1.Order;

public class Handler2 implements EventHandler<Order> { 

	@Override
	public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handler2:set Price");
		event.setPrice(17.00);
		//Thread.sleep(1000);
	}

}
