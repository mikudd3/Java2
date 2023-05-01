package com.lanqiao.javalearn.java2.test4.org;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Person {
    private int id;         //id
    private String name;    //姓名


    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
