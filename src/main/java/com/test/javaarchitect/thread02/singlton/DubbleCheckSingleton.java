package com.test.javaarchitect.thread02.singlton;

public class DubbleCheckSingleton {
	private static DubbleCheckSingleton ds;

	public static DubbleCheckSingleton getDs() {
		if (ds == null) {
			try {
				// 模拟初始化对象准备时间
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (DubbleCheckSingleton.class) {
			if (ds == null) {
				ds = new DubbleCheckSingleton();
			}
		}
		return ds;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(DubbleCheckSingleton.getDs().hashCode());
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(DubbleCheckSingleton.getDs().hashCode());
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(DubbleCheckSingleton.getDs().hashCode());
			}
		}, "t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
