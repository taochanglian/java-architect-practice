package com.test.javaarchitect.disruptor.demo2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.test.javaarchitect.disruptor.demo1.Order;

public class Handler1 implements EventHandler<Order>,WorkHandler<Order> {

	
	@Override
	public void onEvent(Order event) throws Exception {
		System.out.println("handler:set name");
		event.setName("h1");
		//Thread.sleep(1000);
	}

	@Override
	public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
		this.onEvent(event);
	}

}
