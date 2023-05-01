package com.lanqiao.javalearn.java2.test3.serializable_8;

import java.io.*;

/**
 * @project: 序列化
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        intoFile();
        outFile();
    }

    /**
     * 将对象写入文件
     */
    public static void intoFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/lanqiao/javalearn/java2/test3/serializable/person.txt"))) {
            //写入文件
            oos.writeObject(new Person("张三", 20));
            oos.writeObject(new Person("李四", 20));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void outFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/lanqiao/javalearn/java2/test3/serializable/person.txt"))) {
            //读取对象
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            //打印
            System.out.println(p1);
            System.out.println(p2);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
