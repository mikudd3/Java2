package com.lanqiao.javalearn.java2.test4.testclass_2.person;

/**
 * @project: 学生类
 * @author: mikudd3
 * @version: 1.0
 */
public class Student extends Person {
    //年级
    private String grade;

    public Student() {

    }

    public Student(String grade) {
        super();
        this.grade = grade;
    }

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [name=" + super.getName() + ", age=" + super.getAge() +", grade= " + grade + "]";
    }

}

