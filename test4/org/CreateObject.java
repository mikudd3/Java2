package com.lanqiao.javalearn.java2.test4.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class CreateObject {
    public static void main(String[] args) {
        //读取配置文件
        File f = new File("src/com/lanqiao/javalearn/java2/test4/org/object.properties");
        //创建输入流
        InputStream is = null;
        try {
            is = new FileInputStream(f);
            //创建 Properties 对象
            Properties cof = new Properties();
            //将配置文件加载入properties对象
            cof.load(is);
            //读取配置文件中的name字段的值
            //获取姓名
            String name = cof.getProperty("name");
            //获取id
            int id = Integer.parseInt(cof.getProperty("id"));
            // System.out.println(name);
//            System.out.println(id);
            //创建Class对象
            Class<?> c = Class.forName("org.lanqiao.entity.Person");
            //利用newInstance创建对象
            //获取构造器
            Constructor<?> con = c.getDeclaredConstructor(int.class, String.class);
            //创建对象
            Person p = (Person) con.newInstance(id, name);
            //输出
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(name + id);

    }
}
