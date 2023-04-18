package itheima.java2.d03_io.mybytestream2;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
         /*
             字节输入流循环读取
         */

       //1.创建对象
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        //2.循环读取
        int b;
        while ((b = fis.read()) != -1) {
            System.out.println((char) b);
        }
        //3.释放资源
        fis.close();


       /* *//*
        *
        * read :表示读取数据，而且是读取一个数据就移动一次指针
        *
        * *//*
        FileInputStream fis = new FileInputStream("myio\\a.txt");
        //2.循环读取
        while ((fis.read()) != -1) {
            System.out.println(fis.read());//98  100  -1
        }
        //3.释放资源
        fis.close();*/


    }
}
