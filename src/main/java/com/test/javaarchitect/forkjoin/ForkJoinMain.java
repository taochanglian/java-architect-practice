package com.test.javaarchitect.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by tao on 17/1/27.
 */
public class ForkJoinMain {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,100000000000L);
        long sum = pool.invoke(task);
        System.out.println(sum);

        //-----------------java8并行流
        LongStream.rangeClosed(0l,1000000000l)
                  .parallel()
                  .reduce(0,Long::sum);
    }
}
