package com.test.javaarchitect.thread03.queue;

import java.util.concurrent.DelayQueue;

public class WangBa implements Runnable{
	private DelayQueue<Wangmin> queue = new DelayQueue<Wangmin>();
	public boolean yinye = true;

	public void shangji(String name,String id,int money) {
		Wangmin man = new Wangmin(name, id, money*1000 + System.currentTimeMillis());
		System.out.println("网名："+man.getName() + "身份证"+man.getId() + "交钱"+money+"元，开始上机。。。");
	}
	public void xiaji(Wangmin man) {
		System.out.println("网名"+man.getName() + "身份证" + man.getId() + "时间到下机。。。");
	}
	@Override
	public void run() {
		while(yinye) {
			try {
				Wangmin man = queue.take();
				xiaji(man);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		WangBa wb = new WangBa();
		Thread t = new Thread(wb);
		t.start();
		
		wb.shangji("zhangsan", "001", 1);
		wb.shangji("lisi", "002", 10);
		wb.shangji("wangwu", "003", 15);
	}
}































