package com.test.javaarchitect.junit.commons.collections.java8.lambda;

import com.test.javaarchitect.java8.LongFunc;
import com.test.javaarchitect.java8.StringFunc;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tao on 17/1/22.
 */
public class TestLambda3 {

    List<Employee> list = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0),
            new Employee(1,"lisi",23,80.0),
            new Employee(1,"wangwu",10,70.0),
            new Employee(1,"zhaosi",30,60.0),
            new Employee(1,"tianqi",2,50.0)
    );
    /**
     * 定制排序,比较两个Employee,先按照年龄比较,年龄相同按姓名比
     */
    @Test
    public void test1() {
        Collections.sort(list,(e1,e2)->{
            if(e1.getAge()==e2.getAge()) {
                return -e1.getUsername().compareTo(e2.getUsername());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for(Employee emp: list) {
            System.out.println(emp);
        }
    }

    /**
     * 处理字符串
     */
    @Test
    public void test2(){
        System.out.println(op("Hello",(str)->str.toUpperCase()));
        System.out.println(op("abcdefghijklmn",(str)->str.substring(3,4)));
    }

    public String op(String str, StringFunc func) {
        return func.getValue(str);
    }

    /**
     * 计算2个long
     */
    @Test
    public void test3(){
        opLong(100L,200L,(x,y)->x+y);
        opLong(100L,200L,(x,y)->x*y);
    }
    public void opLong(Long l1, Long l2, LongFunc<Long,Long> func) {
        System.out.println(func.getValue(l1,l2));
    }
}

