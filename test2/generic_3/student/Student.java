package com.lanqiao.javalearn.java2.test2.generic_3.student;

import java.util.Objects;

/**
 * @project: 学生类实现 Comparable 接口
 * @author: mikudd3
 * @version: 1.0
 */
public class Student implements Comparable{
    private String name;    //姓名
    private String grade;   //年级


    public Student() {
    }

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return " Student:name=" + this.name + ",grade=" + this.grade;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {

        int result = 0;
        result = result * 31 + this.name.hashCode();
        result = result * 31 + this.grade.hashCode();
        return result;
    }


    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;

        return s.getName().compareTo(this.getName());
    }
}
