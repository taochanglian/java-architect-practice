package com.test.javaarchitect.thread01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtmoicUse {
	private static AtomicInteger count = new AtomicInteger(0);
	//synchronized
	//如果方法内部只有一个方法，那么不需要加synchronize，atomic可以实现原子性；但是方法内如果有多个原子方法，则不能保证整个方法原子性
	public /**synchronized**/ int multiAdd() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);
		return count.get();
	}
	
	public static void main(String[] args) {
		final AtmoicUse au = new AtmoicUse();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i=0;i<100;i++) {
			ts.add(new Thread(new Runnable() {
				
				public void run() {
					System.out.println(au.multiAdd());
				}
			}));
		}
		for(Thread t : ts) {
			t.start();
		}
	}
}
