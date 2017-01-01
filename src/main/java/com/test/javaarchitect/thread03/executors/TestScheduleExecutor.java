package com.test.javaarchitect.thread03.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TestScheduleExecutor {
	public static void main(String[] args) {
		Temp temp = new Temp();
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);//类似timer定时器
		ScheduledFuture<?> scheduleWithFixedDelay = newScheduledThreadPool.scheduleWithFixedDelay(temp, 2, 1, TimeUnit.SECONDS);//初始化2秒后，每隔一秒执行
		
		
	}
		
}

class Temp extends Thread {
	@Override
	public void run() {
		System.out.println("run");
	}
}
