package com.lanqiao.javalearn.java2.jdbc.test02.preparedstatement;

import java.sql.*;

/**
 * @project: 使用 PreparedStatement 查询教师工资
 * @author: mikudd3
 * @version: 1.0
 */
public class JDBCQueryByPreparedStatement {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/edusys?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;

    public static boolean executeUpdate() {
        boolean flag = false;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 用占位符来代替参数值
            String deleteSql = "SELECT name,salary FROM instructor WHERE salary > 6000";
            pstmt = connection.prepareStatement(deleteSql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //获取姓名
                String name = rs.getString("name");
                //获取薪水
                double salary = rs.getDouble("salary");

                System.out.println(name + "\t" + salary);
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
                // 注意 rs、stmt、connection 三个对象的关闭顺序
                if (rs != null) rs.close();
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
