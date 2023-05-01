package com.lanqiao.javalearn.java2.jdbc.blob;

import java.io.*;
import java.sql.*;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class ReadImg{
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库的实例名是
    final static String URL = "jdbc:mysql://localhost:3306/myjava?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
    final static String USERNAME = "root";
    final static String PASSWORD = "123456";
    static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    // 从数据库读取图片
    public static void readImgToBlob(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM myPicture WHERE id = ?" ;
            ps = connection.prepareStatement(sql) ;
            ps.setInt(1, 1); // id=1
            rs = ps.executeQuery() ;
            if(rs.next()){
                // 将图片从数据库中读取出，类型为 InputStream
                InputStream imgIn = rs.getBinaryStream("img") ;
                // 通过 IO 流，将图片写到项目中（硬盘）
                InputStream in = new BufferedInputStream(imgIn) ;
                // 将图片的输出路径设置为 src（相对路径），图片名为 myPic.png
                OutputStream imgOut =new FileOutputStream("src/com/lanqiao/javalearn/java2/jdbc/blob/new_myPic.png");
                OutputStream out = new BufferedOutputStream(imgOut) ;
                int len = -1;
                while( (len=in.read() )!=-1) {
                    out.write(len);
                }
                out.close();
                imgOut.close();
                in.close();
                imgIn.close();
                System.out.println("图片读取成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                // 注意 rs、stmt、connection 三个对象的关闭顺序
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        readImgToBlob();
    }
}
