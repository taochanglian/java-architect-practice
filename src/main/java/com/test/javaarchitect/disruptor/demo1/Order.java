package com.test.javaarchitect.disruptor.demo1;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {
	private String id;//订单编号
	private String name;//订单名称
	private double price;//订单价格
	private AtomicInteger count = new AtomicInteger(0);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AtomicInteger getCount() {
		return count;
	}
	public void setCount(AtomicInteger count) {
		this.count = count;
	}
	
	
}
