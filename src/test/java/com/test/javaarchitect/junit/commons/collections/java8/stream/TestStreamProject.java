package com.test.javaarchitect.junit.commons.collections.java8.stream;


import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by tao on 17/1/25.
 */
public class TestStreamProject {
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0, Employee.Status.BUSY),
            new Employee(1,"lisi",23,80.0, Employee.Status.FREE),
            new Employee(1,"wangwu",10,70.0, Employee.Status.VOCATION),
            new Employee(1,"zhaosi",30,60.0, Employee.Status.FREE),
            new Employee(1,"tianqi",2,50.0, Employee.Status.VOCATION)
    );
    /**
     * 1\给定一个数字列表,如何返回一个由每个数的平方构成的新列表
     * 1 2 3 4 5 => 1 4 9 16 25
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
            .map((e)-> e * e)
            .forEach(System.out::println);

    }

    /**
     * 2\ 怎样用map和reduce方法数一数流中有多少个Employee呢
     */
    @Test
    public void test2(){
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }
}



































