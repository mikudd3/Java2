package com.lanqiao.javalearn.java2.test9.methodref;/**
 * @project:
 * @author:     mikudd3
 * @version:    1.0
 */
interface M{
    int op(int a,int b);
}
public class Test {
    public static int make(M m,int a,int b) {
        return m.op(a, b);
    }

    public int add(int a,int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Test a = new Test();
        int r = make(a::add,3,2);
        System.out.println(r);
    }
}
