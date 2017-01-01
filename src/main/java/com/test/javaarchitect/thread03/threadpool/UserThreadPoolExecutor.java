package com.test.javaarchitect.thread03.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPoolExecutor {
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
		
		Task task1 = new Task(1,"任务1");
		Task task2 = new Task(2,"任务1");
		Task task3 = new Task(3,"任务1");
		Task task4 = new Task(4,"任务1");
		Task task5 = new Task(5,"任务1");
		Task task6 = new Task(6,"任务1");
		
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.execute(task5);
		pool.execute(task6);
		
		pool.shutdown();
	}
	
}

class Task implements Runnable {
	private Integer taskId;
	private String taskName;
	
	
	
	public Integer getTaskId() {
		return taskId;
	}



	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Task() {
		
	}

	public Task(Integer taskId, String taskName) {
		this.taskId = taskId;
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println("runing... taskid = "+this.taskId);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public String toString() {
		return "{\"taskId\":\"" + taskId + "\",\"taskName\":\"" + taskName + "\"}  ";
	}
	
	
	
}