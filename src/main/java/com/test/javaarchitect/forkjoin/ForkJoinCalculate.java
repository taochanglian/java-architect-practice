package com.test.javaarchitect.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by tao on 17/1/27.
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;

    public static final long THRESHOLD = 10000;//临界值

    public ForkJoinCalculate(long start,long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length<=THRESHOLD) {
            long sum = 0;
            for(long i=start;i<=end;i++) {
                sum +=i;
            }
            return sum;
        }else {
            long middle = (start + end) /2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();

            return left.join() + right.join();
        }
    }

}
