package com.lanqiao.javalearn.java2.jdbc.test02.update;

/**
 * @project: 使用 Statement 增加学生表信息
 * @author: mikudd3
 * @version: 1.0
 */

import java.sql.*;

public class JDBCInsertByStatement {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库的实例名是
    final static String URL = "jdbc:mysql://localhost:3306/edusys?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // 执行 `插入` 的方法
    public static boolean executeUpdate() {
        boolean flag = false;
        try {
            // 1 加载数据库驱动
            Class.forName(DRIVER);
            // 2 获取数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3 通过连接，获取一个 Statement 的对象，用来操作数据库
            stmt = connection.createStatement();
            // 4 通过 executeUpdate()实现插入操作
            String addSql = "INSERT INTO student(ID,studnet_name,dept_name,tot_cred) VALUES(33123,'Rong','Music',67)";
            int count = stmt.executeUpdate(addSql);
            System.out.println("受影响的行数是：" + count);
            flag = true;    // 如果一切正常，没有发生异常，则将 flag 设置为 true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        executeUpdate();
    }
}
