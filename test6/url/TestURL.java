package com.lanqiao.javalearn.java2.test6.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * @project: URL 类的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestURL {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要定位的URL地址：");
        String url = input.next();
        System.out.println("请输入要显示的哪个页面标签元素的内容：");
        String iStr = input.next();
        BufferedReader in = null;


        try {
            //通过url字符串创建URL对象
            URL tURL = new URL(url);
            //通过IO流读取信息
            in = new BufferedReader(new InputStreamReader(tURL.openStream()));
            String s;
            while ((s = in.readLine()) != null) {
                //匹配指定的标签内容
                if (s.contains(iStr)) {
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源释放
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            input.close();
        }
    }
}
