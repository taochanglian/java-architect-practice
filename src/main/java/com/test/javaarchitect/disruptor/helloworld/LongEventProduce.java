package com.test.javaarchitect.disruptor.helloworld;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class LongEventProduce {
	private final RingBuffer<LongEvent> ringBuffer;
	public LongEventProduce(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	/*
	 * onData发布事件，没吊用一次就发布一次事件，它的参数会通过事件传递给消费者
	 */
	public void onData(ByteBuffer bb) {
		long sequence = ringBuffer.next();
		try {
			LongEvent event = ringBuffer.get(sequence);
			event.setValue(bb.getLong(0));
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}







































