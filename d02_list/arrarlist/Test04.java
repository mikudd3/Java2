package itheima.java2.d02_list.arrarlist;

import itheima.java2.d02_list.arrarlist.Student.Student;

import java.util.ArrayList;

/**
 * @project: 添加学生对象并遍历
 * 需求:定义一个集合，添加一些学生对象，并进行遍历
 * 学生类的属性为:姓名，年龄。
 * @author: mikudd3
 * @version: 1.0
 */
public class Test04 {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();

        arr.add(new Student("mikudd1", 18));
        arr.add(new Student("mikudd2", 19));
        arr.add(new Student("mikudd3", 20));

        for (Student s : arr) {
            System.out.println("姓名：" + s.getName() + "," + "年龄：" + s.getAge());
        }
    }
}
