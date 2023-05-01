package com.lanqiao.javalearn.java2.test4.testclass_2.person;

import java.util.Date;

/**
 * @project: 老师类
 * @author: mikudd3
 * @version: 1.0
 */
public class Teacher extends Person {
    //参加工作日期
    private Date worktime;
    //职称
    private String title;

    public Teacher() {

    }

    public Teacher(Date worktime, String title) {
        super();
        this.worktime = worktime;
        this.title = title;
    }

    public Teacher(String name, int age, Date worktime, String title) {
        super(name, age);
        this.worktime = worktime;
        this.title = title;
    }

    public Date getWorktime() {
        return worktime;
    }

    public void setWorktime(Date worktime) {
        this.worktime = worktime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher [name=" + super.getName() + ", age=" + super.getAge() + ", worktime=" + worktime + ", title=" + title + "]";
    }

}

