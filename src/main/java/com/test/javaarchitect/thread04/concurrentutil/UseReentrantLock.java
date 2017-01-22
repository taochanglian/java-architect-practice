package com.test.javaarchitect.thread04.concurrentutil;

import java.util.concurrent.locks.ReentrantLock;

public class UseReentrantLock {
	private ReentrantLock lock = new ReentrantLock();
	
	public void method1() {
		try {
			lock.lock();
			System.out.println("进入method1");
			Thread.sleep(2000);
			System.out.println("method1推出");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void method2() {
		try {
			lock.lock();
			System.out.println("进入method2");
			Thread.sleep(2000);
			System.out.println("method2推出");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
//		UseReentrantLock url = new UseReentrantLock();
//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				url.method1();
//				url.method2();
//			}
//		});
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
