package com.test.javaarchitect.thread01;

public class SyncLockDouble1 {
	public synchronized void method1(){
		System.out.println("method1");
		method2();
	}
	public synchronized void method2(){
		System.out.println("method2");
		method3();
	}
	public synchronized void method3(){
		System.out.println("method3");
	}
	
	public static void main(String[] args) {
		final SyncLockDouble1 sld = new SyncLockDouble1();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				sld.method1();
			}
		});
		t1.start();
	}
}
