package com.lanqiao.javalearn.java2.jdbc.clob;

import java.io.*;
import java.sql.*;

/**
 * @project: 从数据库读取小说
 * @author: mikudd3
 * @version: 1.0
 */
public class ReadText {

    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    /**
     * 从数据库读取小说
     */
    public static void readTextToText() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //3.读取数据库
            String sql = "SELECT * FROM myTxt WHERE id = ?";
            // 处理 text/blob，必须使用 PreparedStatement 对象
            ps = connection.prepareStatement(sql);
            //设置第一个参数
            ps.setInt(1, 1);//id = 1;

            //读取小说
            rs = ps.executeQuery();
            while (rs.next()) {
                // 将小说从数据库中读取出，类型为 Reader
                Reader reader = rs.getCharacterStream("clob");

                // 通过 IO 流将小说写到项目中（硬盘)
                // 将小说的输出路径设置为 src（相对路径）
                Writer writer = new FileWriter("src/com/lanqiao/javalearn/java2/jdbc/clob/new_introduce.txt");
                char[] temp = new char[200];
                int len = -1;
                while ((len = reader.read(temp)) != -1) {
                    writer.write(temp, 0, len);
                }
                writer.close();
                reader.close();
                System.out.println("Text 读取成功！");
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
        readTextToText();
    }
}
