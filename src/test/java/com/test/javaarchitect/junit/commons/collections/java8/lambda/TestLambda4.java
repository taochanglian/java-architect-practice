package com.test.javaarchitect.junit.commons.collections.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by tao on 17/1/22.
 * jdk8提供的4大核心函数式接口
 *
 * Consumer<T>: 消费型接口
 *      void accept(T t);
 * Supplier(T):供给型接口
 *      T get();
 * Function<T,R>:T 参数 R 返回值
 *      R apply(T t);
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 *
 */
public class TestLambda4 {
    //Consumer<T> 消费型接口
    @Test
    public void test1() {
        happy(10000,(money)-> System.out.println("消费了"+money+"元"));
    }
    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
//-------------------------------------------------------------------------
    //supplier<T> 供给型接口.产生一些数,放到集合中
    @Test
    public void test2(){
        List<Integer> list = getNumList(10,()->(int)(Math.random()*100));
        for(Integer i : list) {
            System.out.println(i);
        }
    }
    //需求:产生指定个数的整数,并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }
//----------------------------------------------------------------------------
    @Test
    public void test3(){
        String str = handlerString("hello",(s)->s.toUpperCase());
        System.out.println(str);


    }
    //函数式接口 Function<T,R>函数接口
    //用于处理字符串
    public String  handlerString(String str, Function<String,String> strFunc) {
        return strFunc.apply(str);
    }
//----------------------------------------------------------------------------
    @Test
    public void test4(){
        List<String> list =  Arrays.asList("Hello","World","www","ppp");
        List<String> result = filterStr(list,(str)->str.length()>3);
        for(String s : result) {
            System.out.println(s);
        }
    }
    //断言型接口 Predicate<T> 返回boolean
    //将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> strList = new ArrayList<>();
        for(String str : list) {
            if(predicate.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }
}








































