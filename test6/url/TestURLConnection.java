package com.lanqiao.javalearn.java2.test6.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @project: URLConnection 类的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestURLConnection {
    public static void main(String[] args) {

        try {
            // （1）通过在URL上调用openConnection()方法创建连接对象
            URL url = new URL("https://www.lanqiao.cn/");
            // 根据URL获取URLConnection对象
            URLConnection urlc = url.openConnection();
            // 请求协议是HTTP协议，故可转换为HttpURLConnection对象
            HttpURLConnection hUrlC = (HttpURLConnection) urlc;
            // （2）设置参数和一般请求属性
            // 请求方法如果是POST，参数要放在请求体里，所以要向hUrlC输出参数
            hUrlC.setDoInput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true
            hUrlC.setDoInput(true);
            // 请求方法如果是POST，不能使用缓存
            hUrlC.setUseCaches(false);
            // 设置Content-Type属性
            hUrlC.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            // 设定请求的方法为POST，默认是GET
            hUrlC.setRequestMethod("POST");
            // （3）使用connect方法建立到远程对象的实际连接
            hUrlC.connect();
            // （4）远程对象变为可用
            // 通过HttpURLConnection获取输出输入流，可根据需求进一步操作
            InputStream inStrm = hUrlC.getInputStream();
            // 判断请求是否成功
            if (hUrlC.getResponseCode() == 200) {
                System.out.println(inStrm);
            } else {
                System.out.println("POST请求失败");
            }
            // 关闭连接
            hUrlC.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
