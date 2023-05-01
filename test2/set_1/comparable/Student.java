package com.lanqiao.javalearn.java2.test2.set_1.comparable;

/**
 * @project: 学生类实现 Comparable 接口
 * @author: mikudd3
 * @version: 1.0
 */
public class Student implements Comparable {
    //学生学号
    int stuNum = -1;
    //学生姓名
    String stuName = "";

    Student(String name, int num) {
        this.stuName = name;
        this.stuNum = num;
    }

    // 返回该对象的字符串表示，利于输出
    public String toString() {
        return "学号为：" + stuNum + " 的学生，姓名为：" + stuName;
    }

    // 实现 Comparable 的 compareTo() 方法
    public int compareTo(Object o) {
        Student input = (Student) o;

        // 此学生对象的学号和指定学生对象的学号比较
        // 此学生对象学号若大则res为1，若小则res为-1，相同的话res = 0
        int res = Integer.compare(stuNum, input.stuNum);

        // 若学号相同，则按照String类自然排序比较学生姓名
        if (0 == res) {
            res = stuName.compareTo(input.stuName);
        }
        return res;
    }


}
