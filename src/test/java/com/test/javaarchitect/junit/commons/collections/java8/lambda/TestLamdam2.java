package com.test.javaarchitect.junit.commons.collections.java8.lambda;

import com.test.javaarchitect.java8.MyFunc;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by tao on 17/1/22.
 * 一\Lambda表达式的基础语法:java8中引入了一个新的操作符"->",该操作符称为箭头操作符或Lamdba操作符
 *   箭头操作符将Lamdba表达式查分为两部分:
 *   左侧:Lambda 表达式的参数列表.即对应接口中抽象方法的参数列表
 *   右侧:Lambda 表达式中所需执行的功能 即Lambda体,即对应接口中的实现逻辑
 *
 *   语法格式一:无参,无返回值
 *             ()->System.out.println("hello world")
 *   语法格式二:1个参数,并且无返回值
 *             (e)->System.out.println(e)
 *   语法格式三:如果只有1个参数,左侧的小括号,可以不写
 *             e->System.out.println(e)
 *   语法格式四:有两个以上的参数,又返回值,并且Lambda体中有多条语句
 *             Comparator<Integer> com = (x,y)->{
 *                    System.out.println("Integer compar");
 *                    return Integer.compare(x,y);
 *              };
 *   语法格式五: 若Lambda体中只有一条语句,return和大括号抖可以省略不写
 *              Comparator<Integer> com = (x,y)->Integer.compare(x,y);
 *   语法格式六: Lambda表达式的参数列表的参数类型,可以不写,因为jvm编译器通过上下文推断出数据类型,即:"类型推断"
 *
 *  二\ Lambda表达式需要"函数式接口的支持"
 *  函数式接口:若接口中只有一个抽象方法的接口,它就是一个函数式接口,可以使用注解@FunctionalInterface修饰,
 *            用此注解可以检查此接口是否是函数式接口
 *
 *
 */

public class TestLamdam2 {
    //无参无返回
    @Test
    public void test1() {
        int num = 0;//jdk1.7以前,局部内部类中用到同级别的变量,必需是final.现在不需要了.但是不能改变变量的值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World"+num);
            }
        };
        r1.run();
        System.out.println("--------------------------------");
        Runnable r2 = ()-> System.out.println("hello Lambda" + num);
        r2.run();
    }

    //一个参数,没有返回值
    @Test
    public void test2(){
        //Consumer的accept方法,一个参数,无返回值
        Consumer<String> consumer = (x)-> System.out.println(x);
        consumer.accept("helloworld");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x,y)->{
            System.out.println("Integer compar");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
    }

    //需求:对一个数进行运算,进行什么样的计算,不确定,声明一个函数式接口,MyFun
    @Test
    public void test5(){
        System.out.println(op(100,(x)-> x*x));

    }
    public Integer op(Integer num, MyFunc myFunc){
        return myFunc.getValue(num);
    }
}




































