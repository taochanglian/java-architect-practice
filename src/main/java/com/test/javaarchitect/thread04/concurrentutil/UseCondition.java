package com.test.javaarchitect.thread04.concurrentutil;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseCondition {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void method1() {
		try {
			lock.lock();
			System.out.println("method1执行");
			condition.await();
			System.out.println("method1释放lock的锁");
			System.out.println("method1执行结束");
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
			System.out.println("method2执行");
			System.out.println("method2获得锁");
			condition.signal();
			System.out.println("metho2执行结束");
		} finally {
			lock.unlock();
		}
		
	}
	
	
	public static void main(String[] args) {
//		UseCondition uc = new UseCondition();
//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				uc.method1();
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				uc.method2();
//			}
//		});
//
//		t1.start();
//		t2.start();
	}

}
