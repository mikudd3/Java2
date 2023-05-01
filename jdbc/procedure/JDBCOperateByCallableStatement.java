package com.lanqiao.javalearn.java2.jdbc.procedure;

import java.sql.*;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class JDBCOperateByCallableStatement {

    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static CallableStatement cs = null;

    /**
     * 调用存储过程方法
     */
    public static void executeByCallableStatement() {
        try {
            //1。加载JDBC驱动
            Class.forName(DRIVER);
            //2.连接数据库
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //3.创建 CallableStatement 对象，并调用数据库中的存储过程 addTwoNum()
            cs = connection.prepareCall("{CALL addTwoNum(?,?,?)}");

            //设置参数,索引从1开始
            //设置第一个参数
            cs.setInt(1, 10);
            //设置第一个参数
            cs.setInt(2, 20);
            // 将第三个参数（输出参数）类型设置为 int
            cs.registerOutParameter(3, Types.INTEGER);
            // 执行存储过程
            cs.execute();
            // 执行完毕后，获取第三个参数（输出参数）的值
            int result = cs.getInt(3);

            //打印结果
            System.out.println("相加结果是：" + result);

        } catch (ClassNotFoundException e) {
            e.getSuppressed();
        } catch (SQLException e) {
            e.getSuppressed();
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
    }

    public static void main(String[] args) {
        executeByCallableStatement();
    }
}
