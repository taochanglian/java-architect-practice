package com.test.javaarchitect.java8;

/**
 * Created by tao on 17/1/22.
 */
@FunctionalInterface
public interface LongFunc<T,R> {
    public R getValue(T t1,T t2);
}
