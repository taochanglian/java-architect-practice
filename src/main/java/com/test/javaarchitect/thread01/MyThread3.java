package com.test.javaarchitect.thread01;

public class MyThread3 {
	public synchronized void method1() {
		System.out.println("method1~");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//如果加了synchronized,则method2需要等method1执行完后才可以执行，
	public  void method2() {
		System.out.println("method2~");
	}
	
	public static void main(String[] args) {
		final MyThread3 mt3 = new MyThread3();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				mt3.method1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				mt3.method2();
			}
		});
		
		t1.start();
		t2.start();
	}
}
