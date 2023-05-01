package com.lanqiao.javalearn.java2.test6.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: 输入域名获取对应的 IP 地址
 * @author: mikudd3
 * @version: 1.0
 */
public class TestGetIP2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查询IP地址的域名：");
        String dName = input.next();

        try {
            // 通过InetAddress类的静态方法，返回指定域名的IP地址对象
            InetAddress assignIP = InetAddress.getByName(dName);
            // 输出域名和对应的 IP 地址
            System.out.println("域名：" + dName + " 对应的IP地址为：" + assignIP.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
