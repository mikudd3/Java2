package com.lanqiao.javalearn.java2.jdbc.connection;

/**
 * @project: 建立数据库连接
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        try {
            //导入jdbc驱动
            Class<?> jdbc = Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
