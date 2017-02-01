package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tao on 17/1/24.
 * 规约 reduce 可以将该元素反复结合起来,得到一个值
 */

public class TestReduceStream {
    List<Employee> employees = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0, Employee.Status.BUSY),
            new Employee(1,"lisi",23,80.0, Employee.Status.FREE),
            new Employee(1,"wangwu",10,70.0, Employee.Status.VOCATION),
            new Employee(1,"zhaosi",30,60.0, Employee.Status.FREE),
            new Employee(1,"tianqi",2,50.0, Employee.Status.VOCATION)
    );
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Double> reduce1 = employees.stream()
                .map(Employee::getSalay)
                .reduce(Double::sum);//没有起始值,所以用optional
        System.out.println(reduce1.get());


    }
    /**
     * 收集
     * collect 将流转换为其它形式,接受一个Collector接口的实现,用于给Stream中元素做汇总的方法
     * 将Employee中所有的姓名放到一个list中
     */
    @Test
    public void test2(){
        List<String> collect = employees.stream()
                .map(Employee::getUsername)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        HashSet<String> collect1 = employees.stream()
                .map(Employee::getUsername)
                .collect(Collectors.toCollection(HashSet::new));
        //---------------工资平均值
        Double collect2 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalay));
        System.out.println(collect2);
        //-------------工资总和
        Double collect3 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalay));
        System.out.println(collect3);
        //-----------工资最大的员工
        Optional<Employee> collect4 = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalay(), e2.getSalay())));
        System.out.println(collect4.get());
        //-----------工资最小
        Optional<Double> collect5 = employees.stream()
                .map(Employee::getSalay)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(collect5.get());
    }

    /**
     * 分组,可以通过状态来分组
     */
    @Test
    public void test3(){
        Map<Employee.Status, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }
    //多级分组
    @Test
    public void test4(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "qn";
                    } else if (e.getAge() <= 50) {
                        return "zn";
                    } else {
                        return "ln";
                    }
                })));
        System.out.println(collect);
    }

    //分区--满足条件的一个区,不满足条件的一个区
    @Test
    public void test5(){
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalay() >= 80.0));
        System.out.println(collect);

    }

    //数学计算的另一种方式
    @Test
    public void test6(){
        DoubleSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalay));
        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());

    }
    //拼接字符串
    @Test
    public void test7(){
        String collect = employees.stream()
                .map(Employee::getUsername)
                .collect(Collectors.joining()); //collect(Collectors.joining(","))//collect(Collectors.joining(",","===","==="))
        System.out.println(collect);
    }
}




























