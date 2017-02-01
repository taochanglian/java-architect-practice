package com.test.javaarchitect.junit.commons.collections.java8.newdate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

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
        int day = ldt.getDayOfMonth();
        int hour = ldt.getHour();
        int minute = ldt.getMinute();
        int second = ldt.getSecond();
    }


    //Instant:时间戳 以Unix元年1970-01-01开始,到目前为止的毫秒数
    @Test
    public void test2(){
        Instant now = Instant.now();//默认获取的是UTC时区,不是本地时间
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(now.toEpochMilli());

        Instant instant = Instant.ofEpochSecond(1000);//从1970 01 01 过1000秒后的时间
        System.out.println(instant);

    }

    /**
     * Duration: 两个时间之间的间隔
     * period: 计算两个日期之间的间隔
     */
    @Test
    public void test3(){
        Instant inst1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant inst2 = Instant.now();

        Duration duration = Duration.between(inst1, inst2);
        System.out.println(duration.toMillis());
        System.out.println("-----------------------------------");

        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt2 = LocalTime.now();
        long l = Duration.between(lt1, lt2).toMillis();
        System.out.println(l);
    }

    @Test
    public void test4(){
        LocalDate ld1 = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
    }

    /**
     * TemporalAdjuster : 时间矫正器
     */
    @Test
    public void test5(){
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        //将本月的day变成10
        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        //时间矫正器
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义时间矫正器 下一个工作日,它是一个接口,并且可以使用lambda
        LocalDateTime myLdt = ldt1.with((l) -> {
            LocalDateTime tempLdt = (LocalDateTime) l;
            DayOfWeek dayOfWeek = tempLdt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return tempLdt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return tempLdt.plusDays(2);
            } else {
                return tempLdt.plusDays(1);
            }
        });
        System.out.println(myLdt);
    }

    /**
     * DateTimeFormatter 日期格式化
     */

    @Test
    public void test6(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();

        String format = now.format(isoDateTime);
        System.out.println(format);
        System.out.println("------------------------------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dateTimeFormatter.format(now);
        System.out.println(format1);

        LocalDateTime parse = now.parse(format1,dateTimeFormatter);
        System.out.println(parse);

    }

    /**
     * 时区处理 ZonedDate ZonedTime ZonedDateTime
     */

    @Test
    public void test7(){
        //所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
        //使用时区创建时间
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println(now);
        System.out.println("-----------------------------------------------");
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(zonedDateTime);

    }
}

















































