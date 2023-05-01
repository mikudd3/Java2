package com.lanqiao.javalearn.java2.test6.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @project: 获取百度首页信息
 * @author: mikudd3
 * @version: 1.0
 */
public class BaiduURL {
    //资源获取
    public void infos() {

        // 程序代码
        String url = "https://www.baidu.com/index.html";
        //字符流
        BufferedReader in = null;

        try {
            //通过url字符串创建URL对象
            URL tURL = new URL(url);
            //通过IO流读取信息
            in = new BufferedReader(new InputStreamReader(tURL.openStream()));

            //循环读取
            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        new BaiduURL().infos();
    }
}
