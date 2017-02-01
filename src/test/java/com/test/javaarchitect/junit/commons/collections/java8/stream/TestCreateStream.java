package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tao on 17/1/23.
 *
 * Strem的执行流程:
 * 创建Stream
 * 进行Stream的相关操作
 * 终止Stream
 */
public class TestCreateStream {

    //创建Stream
    public void test1(){
        //1.通过collection的实现类,通过stream(串形流)或者parallelStream(并行流)创建Stream
        List<String> list = new ArrayList<String>();
        Stream<String> stream = list.stream();


        //2.通过Arrays中的静态方法stream(),获取一个数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //3通过Stream的静态方法of,获取一个流
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        //创建无限流 会产生无限流,如果要限定,那么可以limit
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.forEach(System.out::println);

        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成无限流
        Stream.generate(()->Math.random())
              .forEach(System.out::println);
            
        }



}
































