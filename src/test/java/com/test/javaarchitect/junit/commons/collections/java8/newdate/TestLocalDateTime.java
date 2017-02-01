package com.test.javaarchitect.junit.commons.collections.java8.newdate;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by tao on 17/1/27.
 */
public class TestLocalDateTime {
    @Test
    public void testLocalDateTime(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime of = LocalDateTime.of(2012, 12, 12, 12, 12, 12);
        System.out.println(of);

        //当前时间加2年
        LocalDateTime localDateTime = ldt.plusYears(2);
        System.out.println(localDateTime);

        //减,减2个月
        LocalDateTime localDateTime1 = ldt.minusMonths(2);
        System.out.println(localDateTime1);

        //返回具体的值
        int year = ldt.getYear();
        int monthValue = ldt.getMonthValue();
        s

    }
}
