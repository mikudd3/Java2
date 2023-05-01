package com.lanqiao.javalearn.java2.jdbc.test02.update;

import java.sql.*;

/**
 * @project: 使用jdbc对数据库执行插入操作
 * @author: mikudd3
 * @version: 1.0
 */
public class JDBCUpdateByStatement {
    //加载数据库驱动
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库实例名
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    //用户名
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";

    //创建对象
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    //执行插入的方法
    public static boolean executeUpdate() {
        boolean flag = false;

        try {
            //1.加载数据库驱动
            Class.forName(DRIVER);
            //2.获取数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3 通过连接，获取一个 Statement 的对象，用来操作数据库
            stmt = connection.createStatement();
            // 4 通过 executeUpdate()实现插入操作
            String addSql = "INSERT INTO student VALUES(11,'wxc',22)";

            //影响行数
            int count = stmt.executeUpdate(addSql);
            System.out.println("受影响的行数为：" + count);

            flag = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return flag;
    }

    public static void main(String[] args) {
        executeUpdate();
    }

}
