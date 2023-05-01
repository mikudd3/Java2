package com.lanqiao.javalearn.java2.test3.dom4j_6.person;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: 人员信息类
 * @author: mikudd3
 * @version: 1.0
 */
public class Person {
    private String id;
    private String name;
    private String sex;
    private int age;

    public Person() {
    }

    public Person(String id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取人员信息列表
     *
     * @return Person 集合
     */
    public static List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("1001", "Tom", "Male", 40));
        list.add(new Person("1002", "Tony", "Male", 30));
        list.add(new Person("1003", "Rose", "Female", 20));
        list.add(new Person("1004", "CoCo", "Female", 10));
        return list;
    }
}
