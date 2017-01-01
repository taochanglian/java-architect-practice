package com.test.javaarchitect.thread02.singlton;

public class TestThreadLocal {
	public static ThreadLocal<String> th = new ThreadLocal<String>();
	
	public void setTh(String value) {
		th.set(value);
	}
	
	public void getTh() {
		System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
	}
	
	public static void main(String[] args) {
		final TestThreadLocal ct = new TestThreadLocal();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ct.setTh("张三");
				ct.getTh();
			}
		},"t1");
		//第二个线程，得不到"张三"，因为每个线程一个变量
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					ct.getTh();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
