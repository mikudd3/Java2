package com.lanqiao.javalearn.java2.test1.myecception_3.org;

/**
 * @project: 学生类
 * @author: mikudd3
 * @version: 1.0
 */
public class Student {
    //成员变量
    private String name;    //姓名
    private double score;     //年龄

    public Student() {
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) throws ScoreException {
        if (score < 0 || score > 150) {
            throw new ScoreException("成绩设置为：" + score + "不合理");
        } else {
            this.score = score;
            System.out.println("成绩设置为" + score + "合理");
        }

    }
}
