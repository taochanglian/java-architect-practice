package com.test.javaarchitect.thread04.concurrentutil;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {
	public static void main(String[] args) {
		final CountDownLatch countDown = new CountDownLatch(2);//等待2个线程回复countdown
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("进入线程t1，等待其他线程执行完成");
					countDown.await();//等待唤醒
					System.out.println("t1线程继续执行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t2线程开始执行，需要3秒");
					Thread.sleep(3000);
					System.out.println("t2线程执行完成，通知t1线程");
					countDown.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("t3线程开始执行，需要3秒");
					Thread.sleep(3000);
					System.out.println("t3线程执行完成，通知t1线程");
					countDown.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2");
		
		t1.start();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
		
	}
}
