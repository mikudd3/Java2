package itheima.java2.d02_list.arrarlist.Student;

import java.util.ArrayList;

/**
 * @project: 集合存储学生对象并遍历
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
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
