package com.lanqiao.javalearn.java2.test3.all_7.classtofile;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Student {
    private String name;    //姓名
    private int age;        //年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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
        return String.format("[name='%s',age='%d']", this.name, this.age);
    }
}
