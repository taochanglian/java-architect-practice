package com.test.javaarchitect.thread01;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVoliatileAtmoic extends Thread{

	//变量的多线程原子性，需要使用atomic
	private static volatile int count = 0;
	//private static AtomicInteger count = new AtomicInteger(0);
	
	private static void addCount(){
		for(int i=0;i<1000;i++) {
			count++;
			//count.incrementAndGet();
		}
		System.out.println("count:"+count);
	}
	
	public void run(){
		addCount();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		TestVoliatileAtmoic[] arr = new TestVoliatileAtmoic[10];
		for(int i=0;i<10;i++) {
			arr[i] = new TestVoliatileAtmoic();
		}
		
		for(int i=0;i<10;i++) {
			arr[i].start();
		}
		
		
	}
}	
