package com.lanqiao.javalearn.java2.jdbc.test02.preparedstatement;

/**
 * @project: 使用 PreparedStatement 实现增删改操作
 * @author: mikudd3
 * @version: 1.0
 */

import java.sql.*;

public class JDBCUpdateByPreparedStatement {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
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
            String deleteSql = "DELETE FROM student WHERE stuName = ? AND stuAge = ?";
            pstmt = connection.prepareStatement(deleteSql);
            // 将第一个占位符？的值替换为 `张三` （占位符的位置是从 1 开始的）
            pstmt.setString(1, "wxc");
            // 将第二个占位符？的值替换为 23
            pstmt.setInt(2, 22);
            int count = pstmt.executeUpdate();
            System.out.println("受影响的行数是：" + count);
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
