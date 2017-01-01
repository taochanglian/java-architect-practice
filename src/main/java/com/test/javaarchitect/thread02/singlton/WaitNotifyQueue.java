package com.test.javaarchitect.thread02.singlton;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitNotifyQueue {
	// create a list
	private LinkedList<Object> list = new LinkedList<Object>();
	// 由于list没有上界，所以用一个计数器
	private AtomicInteger count = new AtomicInteger(0);
	// 确定上界，下界
	private final int minSize = 0;
	private final int maxSize;

	public WaitNotifyQueue(int size) {
		this.maxSize = size;
	}

	// 初始化一个对象，用于加锁
	private Object lock = new Object();

	// 模拟put操作,如果Queue没有空间，则此方法一直阻塞
	public void put(Object obj) {
		synchronized (lock) {
			while(count.get() == this.maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//加入元素
			list.add(obj);
			//计数器累加
			count.incrementAndGet();
			
			System.out.println("新加入的元素为："+obj);
			lock.notify();//通知另外一个线程
		}
	}

	// 模拟take操作,如果Queue没有元素，则阻塞
	public Object take() {
		Object ret = null;
		synchronized (lock) {
			while(count.get()==this.minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ret = list.removeFirst();
			count.decrementAndGet();
			//唤醒另外一个线程
			lock.notify();
			
		}
		return ret;
	}

	public int getSize() {
		return this.count.get();
	}
	
	public static void main(String[] args) {
		WaitNotifyQueue queue = new WaitNotifyQueue(5);
		queue.put("a");
		queue.put("b");
		queue.put("c");
		queue.put("d");
		queue.put("e");
		System.out.println("当前长度："+queue.getSize());
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				queue.put("f");
				queue.put("g");
			}
		},"t1");
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Object o1 = queue.take();
				System.out.println("移除的元素为"+o1);
				Object o2 = queue.take();
				System.out.println("移除的元素为"+o2);
			}
		});
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}





















