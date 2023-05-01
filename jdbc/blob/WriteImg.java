package com.lanqiao.javalearn.java2.jdbc.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @project: 读写 BLOB 数据
 * @author: mikudd3
 * @version: 1.0
 */
public class WriteImg {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库的实例名是
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    // 将图片写入数据库
    public static void writeImgToBlob() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO myPicture(id, img) VALUES(?, ?)";
            // 处理 clob/blob，必须使用 PreparedStatement 对象
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 1); // id=1
            // 将图片转为输入流
            File file = new File("src/com/lanqiao/javalearn/java2/jdbc/blob/myPic.png");
            InputStream in = new FileInputStream(file);
            // 将输入流写入 myPicture 表
            ps.setBinaryStream(2, in, (int) file.length());
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("图片写入成功！");
            } else {
                System.out.println("图片写入失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
        writeImgToBlob();
    }
}
