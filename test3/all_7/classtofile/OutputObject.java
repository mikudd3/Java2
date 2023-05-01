package com.lanqiao.javalearn.java2.test3.all_7.classtofile;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class OutputObject {
    public static void main(String[] args) {
//        Student s = new Student("mikudd3",20);
//        System.out.println(s);

        //创建对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 19);

        String pathname = "src/com/lanqiao/javalearn/java2/test3/classtofile/Object.txt";
        BufferedWriter out = null;
        //写入文件
        try {
            out = new BufferedWriter(new FileWriter(pathname));

            //写入文件
            out.write(s1 + "、" + s2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
