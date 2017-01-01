package com.test.javaarchitect.thread01;

public class MyThread2 {

	//如果需要实现锁的效果，就把printNum中变成static关键字，同时num也变成static
	private int num = 0;
	
	//synchronized方法锁的是对象，2个对象，2个线程，没有锁竞争
	//但是如果是static方法，就不是对象锁了，而是类锁
	public synchronized void printNum(String tag) {
		try {
			if(tag.equals("a")) {
				num = 100;
				System.out.println("tag a,set num over");
				Thread.sleep(1000);
			}else {
				num = 200;
				System.out.println("tag b,set num over");
			}
			
			System.out.println("tag is "+tag+", num is "+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final MyThread2 mt1 = new MyThread2();
		final MyThread2 mt2 = new MyThread2();
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
					mt1.printNum("a");
				}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt2.printNum("b");
			}
		});
		
		t1.start();
		t2.start();
		
		
	}
}
