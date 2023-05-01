package com.lanqiao.javalearn.java2.test1.testexception_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @project: finally 语句块的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException3 {
    /**
     * 完成字符串转成日期，进行异常处理。
     * 在 finally 语句块中语句无条件执行
     */
    public void method() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            System.out.println(sdf.parse("2021-08-30"));
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("SimpleDateFormat 对象资源释放");
            sdf = null;
        }
    }

    public static void main(String[] args) {
        TestException3 te = new TestException3();
        te.method();
    }
}
