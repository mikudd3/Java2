package com.lanqiao.javalearn.java2.jdbc.query;

import java.sql.*;
import java.util.Scanner;

/**
 * @project: 大学信息查询系统
 * @author: mikudd3
 * @version: 1.0
 */
public class Querysys {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库实例名
    final static String URL = "jdbc:mysql://localhost:3306/edusys?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    //用户名
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";

    //创建对象
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    // 补充代码
    public static void executeQuery() {
        try {
            //
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3 通过连接，获取一个 Statement 的对象，用来操作数据库
            stmt = connection.createStatement();
            // 4 通过 executeUpdate()实现插入操作
            String[] sql = new String[3];
            //查询学生信息
            sql[0] = "SELECT ID,studnet_name,dept_name FROM student";
            //查询课程信息
            sql[1] = "SELECT course_id,title,dept_name FROM course";
            //查询导师信息
            sql[2] = "SELECT ID,name,dept_name FROM instructor";

            System.out.println("请选择你要查询的信息类别：1.学生信息 2.课程信息 3．导师信息");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();

            rs = stmt.executeQuery(sql[select - 1]);
            // 5 通过循环读取结果集中的数据
            while (rs.next()) {
                //获取信息
                System.out.println(rs.getString(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        executeQuery();
    }
}
