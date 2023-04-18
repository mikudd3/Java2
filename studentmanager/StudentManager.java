package itheima.java2.studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @project: 学生管理系统
 * @author: mikudd3
 * @version: 1.0
 */
public class StudentManager {
    static int userSel = -1;//选择
    static ArrayList<Student> array = new ArrayList<>();//储存学生信息

    public static void main(String[] args) {

        while (true) {
            int res = menu();
            if (res == 0)
                break;
        }
    }

    //主界面
    public static int menu() {
        System.out.println("----------欢迎来到学生管理系统----------");
        System.out.println("1。添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看所有学生");
        System.out.println("0.推出");
        System.out.println("请输入你的选择：");

        Scanner input = new Scanner(System.in);//输入
        userSel = input.nextInt();
        switch (userSel) {
            case 1:
                addStudent(array);
                break;
            case 2:
                deleteStudent(array);
                break;
            case 3:
                updateStudent(array);
                break;
            case 4:
                findStudent(array);
                break;
            case 0:
                System.out.println("感谢你的使用，再见！！");
                break;
            default:
                System.out.println("你的输入有误，请重新输入！！");
                break;
        }
        return userSel;
    }

    //添加学生信息
    public static void addStudent(ArrayList<Student> array) {
        //创建学生对象

        Scanner input = new Scanner(System.in);//输入
        Student s = new Student();

        //添加数据
        while (true) {
            System.out.println("请输入学生的学号：");
            String sid = input.nextLine();
            s.setsId(sid);
            if (isUsed(array, sid)) {
                System.out.println("添加失败，学号已存在");
            } else {
                break;
            }
        }
        System.out.println("请输入学生的姓名：");
        String name = input.nextLine();
        s.setName(name);

        System.out.println("请输入学生的年龄：");
        String age = input.nextLine();
        s.setAge(age);

        System.out.println("请输入学生的地址：");
        String address = input.nextLine();
        s.setAddress(address);

        //将数据添加到集合
        array.add(s);

        //输出信号
        System.out.println("添加学生信息成功！");

    }

    //判断学号是否重复
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getsId().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //查看学生信息
    public static void findStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("查找失败，请先添加信息！");
            return;
        } else {
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println("学号：" + s.getsId() + "\t" + "姓名：" + s.getName() + "\t" + "年龄：" + s.getAddress() + "\t" + "地址：" + s.getAddress());
            }
        }

    }

    //删除学生信息
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请选择入：");
        System.out.println("1.根据学号删除");
        System.out.println("2.根据姓名删除");
        int choose = input.nextInt();
        switch (choose) {
            case 1: {
                System.out.println("请输入需要删除的学生的学号：");
                Scanner in = new Scanner(System.in);
                String sid = in.nextLine();
                int index = -1;
                for (int i = 0; i < array.size(); i++) {
                    Student s = array.get(i);
                    if (s.getsId().equals(sid)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("删除失败，该学生不存在");
                } else {
                    array.remove(index);
                    System.out.println("删除成功！");
                }
                break;
            }
            case 2: {
                Scanner in = new Scanner(System.in);
                System.out.println("请输入需要删除的学生的姓名：");
                String name = in.nextLine();
                int index = -1;
                for (int i = 0; i < array.size(); i++) {
                    Student s = array.get(i);
                    if (s.getName().equals(name)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    System.out.println("删除失败，该学生不存在");
                } else {
                    array.remove(index);
                    System.out.println("删除成功！");
                }
                break;
            }
            default:
                System.out.println("输入错误，请重新输入");
                break;
        }
    }

    //修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);//输入

        Student s = new Student();

        System.out.println("请输入你要修改的学生的学号：");
        String id = input.nextLine();

        //添加数据
        System.out.println("请输入你要修改的学生的新学号：");
        String sid = input.nextLine();
        s.setsId(sid);

        System.out.println("请输入你要修改的学生的新姓名：");
        String name = input.nextLine();
        s.setName(name);

        System.out.println("请输入你要修改的学生的新年龄：");
        String age = input.nextLine();
        s.setAge(age);

        System.out.println("请输入你要修改的学生的新地址：");
        String address = input.nextLine();
        s.setAddress(address);

        //遍历集合找到需要修改学生
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s1 = array.get(i);
            if (s1.getsId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("修改失败，该学生不存在");
        } else {
            array.set(index, s);
            System.out.println("修改成功");
        }
    }
}
