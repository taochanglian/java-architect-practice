package com.test.javaarchitect.disruptor.helloworld;

import com.lmax.disruptor.EventHandler;

/**
 * 简单的事件处理，直接打印
 * @author tao
 *
 */
public class LongEventHandle implements EventHandler<LongEvent> {

	@Override
	public void onEvent(LongEvent arg0, long arg1, boolean arg2) throws Exception {
		System.out.println(arg0.getValue());
	}

}
