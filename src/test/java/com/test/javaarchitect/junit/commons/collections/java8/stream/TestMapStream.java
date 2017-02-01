package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tao on 17/1/24.
 */

public class TestMapStream {
    List<Employee> listEmployee = Arrays.asList(
            new Employee(1,"zhangsan",10,90.0, Employee.Status.BUSY),
            new Employee(1,"lisi",23,80.0, Employee.Status.FREE),
            new Employee(1,"wangwu",10,70.0, Employee.Status.VOCATION),
            new Employee(1,"zhaosi",30,60.0, Employee.Status.FREE),
            new Employee(1,"tianqi",2,50.0, Employee.Status.VOCATION)
    );

    /**
     * 映射
     * map 接受lambda,将元素转换成其它形式或提取信息.接受一个函数做为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素
     */
    @Test
    public void test1(){
        List<String> list1 = Arrays.asList("aa","bb","cc","dd");
        list1.stream()
            .map((str)->str.toUpperCase())
            .forEach(System.out::println);
        //---------------------------------------------------------

        listEmployee.stream()
            .map(Employee::getUsername)
            .forEach(System.out::println);
        //----------------以下是关键-----------------------------------

        Stream<Stream<Character>> streamStream = list1.stream()
                .map(TestMapStream::filterString);
        streamStream.forEach((s)->{
            s.forEach(System.out::println);
        });
        //----------------以上操作太麻烦,推荐使用flatmap,如下的代码,跟上面的代码,效果一致-------------------------------------------
        list1.stream()
             .flatMap(TestMapStream::filterString)
             .forEach(System.out::println);
    }

    /**
     * flatmap 接收一个函数做为参数,将流中的每个值都换成另一个流,然后把所有的流连成一个流
     *
     * 首先看一个需求,将一个String中的每一个char拿出来,放到一个流中
     *
     */
    public  static Stream<Character> filterString(String str) {
        List<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    /**
     * 排序
     * sorted() 自然排序
     * sorted(Comparator com) 自定义排序
     */
    @Test
    public void test2(){
        List<String> list = Arrays.asList("bbbb","ddd","aaaa","eee");
        list.stream()
            .sorted()
            .forEach(System.out::println);
        System.out.println("-------------------------------");

        listEmployee.stream()
                    .sorted((e1,e2)-> {
                        if(e1.getAge().equals(e2.getAge())) {
                            return e1.getUsername().compareTo(e2.getUsername());
                        }else {
                            return e1.getAge().compareTo(e2.getAge());
                        }
                    }).forEach(System.out::println);

    }

}





















































