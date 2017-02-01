package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by tao on 17/1/24.
 * 终止操作
 */

public class TestStopStream {
    List<Employee> list = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0, Employee.Status.BUSY),
            new Employee(1,"lisi",23,80.0, Employee.Status.FREE),
            new Employee(1,"wangwu",10,70.0, Employee.Status.VOCATION),
            new Employee(1,"zhaosi",30,60.0, Employee.Status.FREE),
            new Employee(1,"tianqi",2,50.0, Employee.Status.VOCATION)
    );
    /**
     * 查找与匹配
     * allMatch- 检查是否匹配所有元素
     * anyMatch- 检查是否至少匹配一个元素
     * noneMatch- 检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count -返回总个数
     * max-返回流中的最大
     * min-返回流中的最小
     *
     */
    @Test
    public void test1(){
        boolean b1 = list.stream()
            .allMatch((e)->e.getStatus().equals(Employee.Status.BUSY));//匹配所有元素是不是都处于BUSY状态
        System.out.println(b1);

        boolean b2 = list.stream()
                .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY));//匹配是否至少有一个元素的状态为busy
        System.out.println(b2);

        boolean b3 = list.stream()
                .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY));//匹配是否没有一个元素的状态为busy
        System.out.println(b3);
        //findFirst 找到第一个.需求:找出工资最高的人,先通过salay排序,然后findFirst

        Optional<Employee> optional = list.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalay(), e2.getSalay()))
                .findFirst();
        System.out.println(optional.get());

        //findAny 找一个
        Optional<Employee> any = list.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any);
    }

    //count
    @Test
    public void test2(){
        long count = list.stream()
                .count();
        System.out.println(count);

        Optional<Employee> max = list.stream()
                .max((e1, e2) -> Double.compare(e1.getSalay(), e2.getSalay()));
        System.out.println(max.get());

        //min 找出工资最少的那个值
        Optional<Double> min = list.stream()
                .map(Employee::getSalay)
                .min(Double::compare);
        System.out.println(min.get());
    }

}






















































