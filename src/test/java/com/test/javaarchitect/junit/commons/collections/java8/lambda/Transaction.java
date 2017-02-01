package com.test.javaarchitect.junit.commons.collections.java8.lambda;

/**
 * Created by tao on 17/1/25.
 */
public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"trader\":")
                .append(trader);
        sb.append(",\"year\":")
                .append(year);
        sb.append(",\"value\":")
                .append(value);
        sb.append('}');
        return sb.toString();
    }
}
