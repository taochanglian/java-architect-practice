package com.test.javaarchitect.thread01;

public class DirtyRead {
	private String username = "zhangsan";
	private String password = "123456";
	
	public synchronized void setValue(String username ,String password){
		this.username = username;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("username:"+username + ",password:"+password);
	}
	
	//如果不加synchronized，会出现脏读
	public  void getValue() {
		System.out.println("username:"+username + ",password:"+password);
	}
	
	public static void main(String[] args) throws Exception {
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				dr.setValue("lisi", "123");
			}
		});
		t1.start();
		Thread.sleep(1000);
		dr.getValue();
	}
}
