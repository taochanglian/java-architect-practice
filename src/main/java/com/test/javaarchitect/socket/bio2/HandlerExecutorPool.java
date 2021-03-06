package com.test.javaarchitect.socket.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorPool {
	private ExecutorService execurot;
	
	public HandlerExecutorPool(int maxPoolSize,int queueSize) {
		this.execurot = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(), 
				maxPoolSize, 
				120L, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(queueSize));
	}
	public void execute(Runnable task) {
		this.execurot.execute(task);
	}
}
