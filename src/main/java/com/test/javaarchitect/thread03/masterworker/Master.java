package com.test.javaarchitect.thread03.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//承装任务的集合
	private ConcurrentLinkedQueue<Task> workQueue =new ConcurrentLinkedQueue<Task>();
	//使用hashmap去承装所有的work对象
	private HashMap<String,Thread> workers = new HashMap<String,Thread>();
	//使用一个容器承装每一个work执行的结果，并发
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String,Object>();
	
	//构造方法
	public Master(Worker worker,int workerCount) {
		//每一个worker都需要有Master的引用
		worker.setWorkerQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		
		for(int i=0;i<workerCount;i++) {
			//key表示每一个worker的名字，value表示线程执行对象
			workers.put("子节点"+Integer.toString(i), new Thread(worker));
		}
	}
	
	//提交任务的方法
	public void submit(Task task) {
		workQueue.add(task);
	}
	
	//启动应用程序，让所有的worker工作。master启动了，worker就开始执行
	public void execute() {
		for(Map.Entry<String,Thread> me : workers.entrySet()) {
			me.getValue().start();
		}
	}

	//判断线程是否执行完毕
	public boolean isComplete() {
		for(Map.Entry<String,Thread> me : workers.entrySet()) {
			if(me.getValue().getState() ==Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	//返回结果，如果所有的worker都执行完了，就求和
	public int getResult() {
		int sum = 0;
		for(Map.Entry<String,Object> me : this.resultMap.entrySet()) {
			sum += (Integer)me.getValue();
		}
		return sum;
	}
}



























