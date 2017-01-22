package com.test.javaarchitect.junit.commons.collections.java8;

/**
 * Created by tao on 17/1/22.
 */
public class Employee {
    private Integer id;
    private String username;
    private Integer age;
    private Double salay;

    public Employee(Integer id, String username, Integer age, Double salay) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.salay = salay;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalay() {
        return salay;
    }

    public void setSalay(Double salay) {
        this.salay = salay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"age\":")
                .append(age);
        sb.append(",\"salay\":")
                .append(salay);
        sb.append('}');
        return sb.toString();
    }
}
