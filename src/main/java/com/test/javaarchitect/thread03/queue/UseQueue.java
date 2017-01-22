package com.test.javaarchitect.thread03.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class UseQueue {
	public static void main(String[] args) throws Exception{
//		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
//		queue.offer("a");
//		queue.offer("b");
//		queue.offer("c");
//		queue.offer("d");
//		
//		System.out.println(queue.poll());//取出第一个元素，并删除
//		System.out.println(queue.size());
//		System.out.println(queue.peek());//取出第一个元素，不删除
//		System.out.println(queue.size());
		
		
//		ArrayBlockingQueue<String> arr = new ArrayBlockingQueue<>(5);//有界阻塞队列
//		arr.put("a");
//		arr.offer("b");
//		arr.add("c");
//		arr.add("d");
//		arr.add("e");
//		
//		System.out.println(arr.offer("f", 2, TimeUnit.SECONDS));//由于空间已满，等2秒后，返回false
//		System.out.println(arr.add("f"));//add方法，当队列满的时候，抛出异常 Queue full exception
		
//		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(); //无界阻塞队列
//		queue.offer("a");
//		queue.offer("b");
//		queue.offer("c");
//		queue.offer("d");
//		queue.offer("e");
//		System.out.println(queue.size());
//		
//		List<String> list = new ArrayList<String>();
//		System.out.println(queue.drainTo(list,3));
//		for(String s : list) {
//			System.out.println(s);
//		}
//		System.out.println("---");
//		for(String s : queue){
//			System.out.println(s);
//		}
		
		
		//SynchronousQueue<String> queue = new SynchronousQueue<>();//不可以初始化
		//queue.add("hello");//会抛异常，此队列不可以加元素
		
	}
}
