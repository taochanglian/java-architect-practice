package com.test.javaarchitect.thread01;

public class TestVoliatile extends Thread{
	//volatile 如果这里不加volatile关键字，则子线程无法感知main方法对变量的修改
	//volatile解决了变量在多线程情况下的可见性，但是无法解决在多线程下的原子性，原子性需要用atmoic
	private  boolean isRunning = true;
	private void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public void run() {
		System.out.println("进入Run方法");
		while(isRunning==true) {
			
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws Exception {
		TestVoliatile tv = new TestVoliatile();
		tv.start();
		Thread.sleep(3000);
		tv.setRunning(false);
		System.out.println("isRunning的值已经被设置为false");
		Thread.sleep(1000);
		System.out.println(tv.isRunning);
	}
}
