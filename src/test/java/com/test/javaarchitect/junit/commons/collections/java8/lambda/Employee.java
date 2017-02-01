package com.test.javaarchitect.junit.commons.collections.java8.lambda;

import java.util.Objects;

/**
 * Created by tao on 17/1/22.
 */
public class Employee {
    private Integer id;
    private String username;
    private Integer age;
    private Double salay;
    private Status status;

    public Employee(Integer id, String username, Integer age, Double salay) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.salay = salay;
    }

    public Employee(Integer id, String username, Integer age, Double salay, Status status) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.salay = salay;
        this.status = status;
    }

    public Employee(Integer id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        sb.append(",\"status\":")
                .append(status);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(username, employee.username) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salay, employee.salay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, age, salay);
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION
    }
}
