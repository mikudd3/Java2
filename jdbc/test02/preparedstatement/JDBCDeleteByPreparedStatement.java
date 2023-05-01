package com.lanqiao.javalearn.java2.jdbc.test02.preparedstatement;

import java.sql.*;

/**
 * @project: 使用 PreparedStatement 修改教师表
 * @author: mikudd3
 * @version: 1.0
 */
public class JDBCDeleteByPreparedStatement {
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
            String deleteSql = "DELETE FROM instructor WHERE name = ?";
            pstmt = connection.prepareStatement(deleteSql);
            // 将第一个占位符？的值替换为 `张三` （占位符的位置是从 1 开始的）
            pstmt.setString(1, "wxc");
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
