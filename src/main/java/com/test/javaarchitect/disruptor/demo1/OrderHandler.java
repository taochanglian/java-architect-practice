package com.test.javaarchitect.disruptor.demo1;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class OrderHandler implements EventHandler<Order>,WorkHandler<Order> {

	@Override
	public void onEvent(Order event) throws Exception {
		event.setId(UUID.randomUUID().toString());
		System.out.println(event.getId());
	}

	@Override
	public void onEvent(Order event, long sequence, boolean endOfBatch) throws Exception {
		this.onEvent(event);
	}

}
