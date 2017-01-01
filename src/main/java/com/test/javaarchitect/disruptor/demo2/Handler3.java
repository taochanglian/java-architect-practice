package com.test.javaarchitect.disruptor.demo2;

import com.lmax.disruptor.EventHandler;
import com.test.javaarchitect.disruptor.demo1.Order;

public class Handler3 implements EventHandler<Order> {

	@Override
	public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("handle3 print:name="+event.getName()+",price="+event.getPrice()+",instance="+event.toString());
	}

}
