package com.test.javaarchitect.junit.commons.collections.java8.funcRef;

import com.sun.tracing.dtrace.FunctionName;
import com.test.javaarchitect.junit.commons.collections.java8.lambda.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by tao on 17/1/22.
 * 如果lambda中需要实现的内容,已经有方法实现了,就可以用"方法引用"
 * 可以理解为:方法引用是Lambda表达式的另外一种表现形式
 *
 * 主要有三种语法格式:
 * 1) 对象::实例方法名
 * 2) 类::静态方法名
 * 3) 类::实例方法名
 * 注意:
 *  1 Lambda体中调用方法的参数列表和返回值要与函数式接口中的函数和返回值类型保持一致
 *
 *
 * 二\构造器引用
 * 格式:
 *  ClassName::new
 *
 *  三\数组引用:
 *  type::new;
 */
public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> consumer = (x)-> System.out.println(x);
        //println完成了我门要干的事情,所以,可以用方法应用
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;//要保证参数列表和返回值类型一致
    }

    //对象::实例方法名
    @Test
    public void test2(){
        Employee employee = new Employee(1,"zs",30,100.00);

        Supplier<String> sup = ()->employee.getUsername();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> supplier = employee::getAge;
        Integer age = supplier.get();
        System.out.println(age);
    }
    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        Integer result = com.compare(100,200);
        System.out.println(result);

        Comparator<Integer> com1 = Integer::compare;
        Integer result1 = com.compare(100,200);
        System.out.println(result1);
    }

    //类::实例方法名
    //如果第一个参数是方法的调用者,第二个参数是方法的参数时,才可以使用 className::methodname
    @Test
    public void test4() {
        BiPredicate<String,String> bp = (x,y)->x.equals(y);

        BiPredicate<String,String> bp1 = String::equals;
    }

    //构造器引用 classname::new
    //注意:需要调用的构造器的参数列表要与构造方法的参数列表保持一致
    @Test
    public void test5(){
        Supplier<Employee> sup = ()->new Employee();
        Employee employee = sup.get();

        //构造器引用
        Supplier<Employee> sup2 = Employee::new;//取决于Supplier
        Employee employee1 = sup2.get();//调用的是无参构造

        Function<Integer,Employee> function = (x)->new Employee(x);

        Function<Integer,Employee> function1 = Employee::new; //这个就是一个参数的构造器,取决于Function

    }
    //数组引用
    @Test
    public void test6(){
        Function<Integer,String[]> fun = (x)->new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);

    }
}




















































