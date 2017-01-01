package com.test.javaarchitect.thread03.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap;

	@Override
	public void run() {
		while(true) {
			Task task = this.workQueue.poll();
			if(task == null) {
				break;
			}
			//真正的业务处理
			Object output = handle(task);
			this.resultMap.put(task.getId()+"", output);
		}
	}
	

	private Object handle(Task task) {
		Object output =null;
		try {
			//表示处理任务的耗时，即模拟各种操作
			Thread.sleep(500);
			output = task.getPrice();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}


	public void setWorkerQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
		
	}

}






















