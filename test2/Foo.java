package com.lanqiao.javalearn.java2.test2;

import java.io.PrintWriter;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Foo {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new java.io.OutputStreamWriter(System.out), true);
        System.out.println("Hello");
    }
}
