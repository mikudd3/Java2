package com.lanqiao.javalearn.java2.test4.method_3.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @project: 获取类中属性信息
 * @author: mikudd3
 * @version: 1.0
 */
public class TestField {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.method_3.field.Sub");
            System.out.print("请输入你想获取Sub类的哪个属性的类型：");
            String name = input.next();
            //通过指定属性名获取属性对象
            Field sf = c.getDeclaredField(name);
            //得到属性类型
            System.out.println("Sub类" + name + "属性的类型为：" + sf.getType());
            System.out.println("****************************************");
            //返回Field对象数组，存放该类或接口的所有属性（不包含父类或父接口中的方法）
            Field flist[] = c.getDeclaredFields();
            System.out.println("Sub类getDeclaredFields()得到的属性如下：");
            //遍历所有属性
            for (int i = 0; i < flist.length; i++) {
                System.out.println("****************************************");
                Field f = flist[i];
                System.out.println("属性" + (i + 1) + "名称为：" + f.getName());    //得到属性名
                System.out.println("该属性所在的类或接口为：" + f.getDeclaringClass());
                System.out.println("该属性的类型为：" + f.getType());        //得到属性类型
                //以整数形式返回由此Field对象表示的属性的Java访问权限修饰符
                int m = f.getModifiers();
                //使用Modifier类对表示访问权限修饰符的整数进行解码显示
                System.out.println("该属性的修饰符为：" + Modifier.toString(m));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
