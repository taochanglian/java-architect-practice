package com.test.javaarchitect.junit.commons.collections.java8.optional;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.security.cert.PKIXRevocationChecker;
import java.util.Optional;

/**
 * Created by tao on 17/1/27.
 */
public class TestOptional {
    /**
     * 创建optional
     * isPresent optional,是否有值
     * orElse(T t),如果optional里面有值,就返回那个值,否则返回你写的T
     * orElseGet(Supplier s)如果optional里面有值,就返回那个值,否则返回你写的s
     */
    @Test
    public void test1(){
        Optional<Employee> employee = Optional.of(new Employee());
        if(employee.isPresent()) {
            System.out.println(employee.get());
        }
        System.out.println(employee.get());

        Employee employee1 = employee.orElse(new Employee());
        System.out.println(employee1);

        Employee employee2 = employee.orElseGet(() -> new Employee());
        System.out.println(employee2);
    }
    /**
     * 创建一个空的Optional实例
     */
    @Test
    public void test2(){
        Optional<Employee> employee = Optional.empty();
        System.out.println(employee);
    }
    /**
     * Optional.ofNullable(T t) 若t不为null,则创建optional实例,否则创建空实例
     */
    @Test
    public void test3(){
        Optional<Employee> employee = Optional.ofNullable(new Employee());
        System.out.println(employee.get());

        Optional<Employee> employee1 = Optional.ofNullable(null);
        System.out.println(employee1.get());
    }
    /**
     * map 如果有值,对其处理,如果没有值,返回Optional.empty
     * flatmap 与map类似,不过返回值必需是optional
     */
    @Test
    public void test4() {
        Optional<Employee> employee = Optional.ofNullable(new Employee(1, "zhangsan", 20, 88.88, Employee.Status.BUSY));
        Optional<String> s = employee.map(Employee::getUsername);
        System.out.println(s.get());

        Optional<String> s1 = employee.flatMap((e) -> Optional.of(e.getUsername()));
        System.out.println(s1.get());

    }
}


































