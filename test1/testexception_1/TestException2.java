package com.lanqiao.javalearn.java2.test1.testexception_1;

/**
 * @project: 异常处理捕获方式
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException2 {
    /**
     * 捕获 ArrayIndexOutOfBoundsException 数组下标越界异常处理
     */
    public void method1() {
        String[] names = {"小凳子", "小椅子", "小桌子"};
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println(names[i]);
            }
            //当出现异常，下面代码不会在执行
            System.out.println("over");
        } catch (ArrayIndexOutOfBoundsException e) {
            // 打印异常类对象
            System.out.println(e.getMessage());
        }
        //就算出现异常，这段代码还是会继续执行
        System.out.println("over");

    }

    public void method2(String a, String b) {
        double c = 0.0;
        try {
            c = Integer.parseInt(a) / Integer.parseInt(b);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(c);
    }

    // method3 有错误
//    public void method3(String a, String b) {
//        double c = 0.0;
//        try {
//            c = Integer.parseInt(a) / Integer.parseInt(b);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        System.out.println(c);
//    }

    public static void main(String[] args) {
        TestException2 te = new TestException2();
        te.method1();
    }
}
