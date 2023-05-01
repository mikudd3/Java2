package com.lanqiao.javalearn.java2.jdbc.clob;

import java.io.*;
import java.sql.*;

/**
 * @project: 写入数据库
 * @author: mikudd3
 * @version: 1.0
 */
public class WriteText {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    /**
     * 将小说写入数据库
     */
    public static void writeTextToText() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //3.写入数据库
            String sql = "INSERT INTO myTxt(id,clob)VALUES(?,?)";
            // 处理 text/blob，必须使用 PreparedStatement 对象
            ps = connection.prepareStatement(sql);
            //设置第一个参数
            ps.setInt(1, 1);//id = 1;

            //写入文件
            // 将小说转为字符输入流，并设置编码格式为中文 GBK 格式
            File file = new File("src/com/lanqiao/javalearn/java2/jdbc/clob/introduce.txt");

            //创建字符输入流
            Reader reader = new InputStreamReader(new FileInputStream(file), "utf8");
            // 将字符输入流写入 myTxt 表
            ps.setCharacterStream(2, reader, (int) file.length());

            //判断是否写入成功
            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("小说写入成功！");
            } else {
                System.out.println("小说写入失败！");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 注意 rs、stmt、connection 三个对象的关闭顺序
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
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        writeTextToText();
    }
}
