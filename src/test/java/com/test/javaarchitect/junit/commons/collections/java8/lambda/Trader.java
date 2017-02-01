package com.test.javaarchitect.junit.commons.collections.java8.lambda;

/**
 * Created by tao on 17/1/25.
 */
public class Trader {
    private String name;
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
