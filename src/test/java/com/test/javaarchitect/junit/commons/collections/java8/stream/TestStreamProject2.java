package com.test.javaarchitect.junit.commons.collections.java8.stream;

import com.test.javaarchitect.junit.commons.collections.java8.lambda.Trader;
import com.test.javaarchitect.junit.commons.collections.java8.lambda.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by tao on 17/1/25.
 */
public class TestStreamProject2 {
    List<Transaction> transactions = null;
    @org.junit.Before
    public void before(){
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)

        );
    }

    /**
     * 找出2011年发生的所有交易,并按交易额排序,从低到高
     */
    @Test
    public void test1(){
        transactions.stream()
                    .filter((e)->e.getYear()==2011)
                    .sorted((t1,t2)->Integer.compare(t1.getValue(),t2.getValue()))
                    .forEach(System.out::println);
    }
    /**
     *  交易员在哪些城市工作过
     */
    @Test
    public void test2(){
        transactions.stream()
                    .map((s)->s.getTrader().getCity())
                    .distinct()
                    .forEach(System.out::println);
    }

    /**
     * 查找出所有剑桥的交易员,并按照姓名排序
     */
    @Test
    public void test3(){
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter((e)->e.getCity().equals("Cambridge"))
                    .sorted((e1,e2)->e1.getName().compareTo(e2.getName()))
                    .forEach(System.out::println);
    }
    /**
     * 返回所有交易员的姓名,并按照字母排序
     *
     */
    @Test
    public void test4() {
        transactions.stream()
                    .map((e)->e.getTrader().getName())
                    .sorted()
                    .forEach(System.out::println);

        System.out.println("--------------------------------");
        //排好序,拼接成一个字符串
        String reduce = transactions.stream()
                .map((e) -> e.getTrader().getName())
                .sorted()
                .reduce("", String::concat);
        System.out.println(reduce);
    }

    /**
     * 有没有交易员在米兰工作的
     */
    @Test
    public void test5(){
        boolean flag = transactions.stream()
                    .anyMatch((t)->t.getTrader().getCity().equals("Milan"));
        System.out.println(flag);
    }
    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test6 (){
        Optional<Integer> sum = transactions.stream()
                .filter((e) -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }
    /**
     * 所有交易中,最高的交易额是多少
     */
    @Test
    public void test7(){
        Optional<Integer> max = transactions.stream()
                .map((t) -> t.getValue())
                .max(Integer::compare);
        System.out.println(max.get());
    }
    /**
     * 找到最小的交易
     */
    @Test
    public void test8(){
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());


    }


}
































































