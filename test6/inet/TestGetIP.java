package com.lanqiao.javalearn.java2.test6.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @project: 获取本机 IP 地址
 * @author: mikudd3
 * @version: 1.0
 */
public class TestGetIP {
    public static void main(String[] args) {
        try {
            //通过inetAddress类的静态方法，返回本地主机对象
            InetAddress myIP = InetAddress.getLocalHost();
            //通过inetAddress类getHostAddress()方法获取IP地址字符串
            System.out.println(myIP.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
