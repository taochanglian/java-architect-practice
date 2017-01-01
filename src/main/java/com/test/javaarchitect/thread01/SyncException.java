package com.test.javaarchitect.thread01;


public class SyncException {
	private int i = 0;

	public synchronized void op() {
		while (true) {
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + ", i=" + i);
				if (i == 10) {
					Integer.parseInt("aa");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("log info i=" + i);
				//抛出异常，否则会一直持续
				//throw new RuntimeException();
				//continue ,如果continue，则继续运行任务
				//continue;
			}
		}
	}

	public static void main(String[] args) {
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				se.op();
			}
		});
		t1.start();
	}
}
