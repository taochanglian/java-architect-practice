package com.test.javaarchitect.thread02.singlton;

//单例在多线程中最好的使用方式
public class InnerSingleTon {

	private static class Singletion {
		private static Singletion single = new Singletion();
	}
	public static Singletion getInstance() {
		return Singletion.single;
	}
}
