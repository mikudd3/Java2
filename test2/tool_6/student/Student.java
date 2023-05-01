package com.lanqiao.javalearn.java2.test2.tool_6.student;

/**
 * @project: 班级成绩排序学生类
 * @author: mikudd3
 * @version: 1.0
 */
public class Student {
    private int id;
    private String name;
    private int score;

    public Student() {
    }

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "学号：" + this.id + ", 姓名：" + this.name + ", 成绩：" + this.score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
