package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tao on 17/1/24.
 */
public class TestOpStream {
    List<Employee> list = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0),
            new Employee(1,"lisi",23,80.0),
            new Employee(1,"wangwu",44,70.0),
            new Employee(1,"zhaosi",30,60.0),
            new Employee(1,"tianqi",2,50.0),
            new Employee(1,"tianqi",2,50.0),
            new Employee(1,"tianqi",2,50.0)
    );
    /**
     * 创建玩Stream后,进行中间操作
     */
    /**
     * 筛选与切片
     * filter -接收lambda,从流中删除某些元素
     */
    @Test
    public void test1(){
        Stream<Employee> stream = list.stream()
            .filter((e)->e.getAge()>35);//中间操作不会执行,除非碰到终止操作.此操作会进行一个内部迭代操作,是有StreamAPI完成遍历过滤
        stream.forEach(System.out::println);
    }

    /**
     * limit
     */
    @Test
    public void test2(){
        list.stream()
            .filter((e)->e.getSalay()>=60.0)
            .limit(2)//找到2个符合的结果,立刻返回,不浪费资源,自动进行了优化
            .forEach(System.out::println);
    }

    /**
     * skip 跳过元素,返回一个扔掉了前N个元素的流,若流中元素不足N个,则返回一个空流,与limit互补
     *
     */
    @Test
    public void test3() {
        list.stream()
            .filter((e)->e.getSalay()>=60.0)
            .skip(2)
            .forEach(System.out::println);
    }

    /**
     * distinct 筛选,通过流所生成元素的hashcode和equals去掉重复的元素
     *
     */
    @Test
    public void test4() {
        list.stream()
                .filter((e)->e.getSalay()>=50.0)
                .skip(2)
                .distinct()//distince如果要有效,必需重写hashcode和equals
                .forEach(System.out::println);
    }
}






















































