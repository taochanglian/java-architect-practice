package com.test.javaarchitect.thread01;

import java.util.ArrayList;
import java.util.List;
//t1线程中增加到5个元素的时候，t2线程中断。 t2用轮询的方式非常的不好，优化一下
//查看TestWaitAndNotify02
public class TestWaitAndNotify {
	//首先必需用volatile关键字
	private volatile  static List list = new ArrayList();
	
	public void add() {
		list.add("hello");
	}
	public int size() {
		return list.size();
	}
	public static void main(String[] args) {
		final TestWaitAndNotify list1 = new TestWaitAndNotify();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					for(int i=0;i<10;i++) {
						list1.add();
						System.out.println("当前线程" +Thread.currentThread().getName() + " 添加了一个元素");
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while(true ) {
					if(list1.size()==5) {
						System.out.println("当前线程收到通知："+Thread.currentThread().getName() + ",list size==5,中断线程");
						throw new RuntimeException();
					}
				}
			}
		},"t2");
		
		t1.start();
		t2.start();
	}
}
