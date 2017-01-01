package com.test.javaarchitect.thread01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
//wait notify必需配合synchionize进行配合使用
//wait释放锁，而notify不释放锁
//看启动线程的顺序，先启动t2线程，再启动t1线程
//如果需要wait到了以后，立刻停止线程，则需要使用CountDownLatch,如果用CountDownLatch，则不需要使用synchionized
public class TestWaitAndNotify02 {
	private volatile static List list = new ArrayList();

	public void add() {
		list.add("hello");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		final TestWaitAndNotify02 list1 = new TestWaitAndNotify02();
		final Object lock = new Object();
//		final CountDownLatch count = new CountDownLatch(1);

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					synchronized (lock) {
						for (int i = 0; i < 10; i++) {
							list1.add();
							System.out.println("当前线程" + Thread.currentThread().getName() + " 添加了一个元素");
							Thread.sleep(500);
							if (list1.size() == 5) {
								System.out.println("已经发出通知");
								lock.notify();
//								count.countDown();
							}
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					if (list1.size() != 5) {
						try {
							lock.wait();
//							count.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					System.out.println("当前线程收到通知：" + Thread.currentThread().getName() + ",list size==5,中断线程");
					throw new RuntimeException();
				}

			}
		}, "t2");
		t2.start();
		t1.start();
		
	}
}
