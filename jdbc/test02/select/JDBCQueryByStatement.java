package com.lanqiao.javalearn.java2.jdbc.test02.select;

import java.sql.*;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class JDBCQueryByStatement {
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
    public static boolean executeQuery() {
        boolean flag = false;

        try {
            //1.加载数据库驱动
            Class.forName(DRIVER);
            //2.获取数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3 通过连接，获取一个 Statement 的对象，用来操作数据库
            stmt = connection.createStatement();
            // 4 通过 executeUpdate()实现插入操作
            String querySql = "SELECT * FROM student WHERE stuNo = 1";

            //影响行数
            rs = stmt.executeQuery(querySql);

            // 5 通过循环读取结果集中的数据
            while (rs.next()) {
                // 等价于 rs.getInt(1);
                int stuNo = rs.getInt("stuNo");
                // rs.getString(2);
                String stuName = rs.getString("stuName");
                // rs.getString(3);
                int stuAge = rs.getInt("stuAge");
                System.out.println(stuNo + "\t" + stuName + "\t" + stuAge);
            }

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
        executeQuery();
    }
}
