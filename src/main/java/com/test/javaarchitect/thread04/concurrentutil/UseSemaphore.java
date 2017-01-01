package com.test.javaarchitect.thread04.concurrentutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemaphore {
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		final Semaphore semp = new Semaphore(5);
		
		for(int index=0;index<20;index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					try {
						semp.acquire();
						System.out.println("Access :"+NO);
						Thread.sleep((long)(Math.random()*10000));
						semp.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			newCachedThreadPool.execute(run);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newCachedThreadPool.shutdown();
	}
}
