package com.lanqiao.javalearn.java2.test4.testclass_2.person;

/**
 * @project: 人类
 * @author: mikudd3
 * @version: 1.0
 */
public class Person {
    //姓名
    private String name;
    //年龄
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}

