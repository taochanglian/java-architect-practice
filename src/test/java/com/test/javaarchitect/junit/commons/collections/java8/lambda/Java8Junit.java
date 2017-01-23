package com.test.javaarchitect.junit.commons.collections.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by tao on 17/1/22.
 */
public class Java8Junit {
    //jdk的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> co = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> set = new TreeSet<Integer>(co);
    }

    //lamdam
    @Test
    public void test2(){
        Comparator<Integer> co = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> set = new TreeSet<Integer>(co);

    }
    //查询年龄大于35岁的employee

    List<Employee> list = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0),
            new Employee(1,"lisi",23,80.0),
            new Employee(1,"wangwu",44,70.0),
            new Employee(1,"zhaosi",30,60.0),
            new Employee(1,"tianqi",2,50.0)
    );
    @Test
    public void test3() {
        list.stream().filter((e) -> e.getAge() >= 30).forEach(System.out::println);
        list.stream().filter((e) -> e.getAge() >= 30).limit(2).forEach(System.out::println);
        System.out.println("-----------遍历所有的名字----------");
        list.stream().map(Employee::getUsername).forEach(System.out::println);
    }

}
