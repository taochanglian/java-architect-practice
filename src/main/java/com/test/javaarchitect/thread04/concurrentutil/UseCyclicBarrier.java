package com.test.javaarchitect.thread04.concurrentutil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseCyclicBarrier {
	
	static class Runner implements Runnable {
		private CyclicBarrier barrier;
		private String name;
		
		public Runner(CyclicBarrier barrier,String name) {
			this.barrier = barrier;
			this.name = name;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000 * (new Random()).nextInt(5));
				System.out.println(name + "准备ok");
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ready go");
		}
	}
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		newFixedThreadPool.submit(new Thread(new Runner(barrier,"张三")));
		newFixedThreadPool.submit(new Thread(new Runner(barrier,"李四")));
		newFixedThreadPool.submit(new Thread(new Runner(barrier,"王五")));
		
		newFixedThreadPool.shutdown();
	}
	
}













