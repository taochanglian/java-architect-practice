package com.test.javaarchitect.thread02.singlton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentHashMap {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String,Object>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		
		map.putIfAbsent("k4", "v4v4v4");//如果key不存在，就put；如果key存在，不put，还是原先的值
		
		for(Map.Entry<String, Object> me : map.entrySet()) {
			System.out.println(me.getKey() + ":" + me.getValue());
		}
	}
}
