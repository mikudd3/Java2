package com.lanqiao.javalearn.java2.test1.testthrows_2;

/**
 * @project: 异常处理抛出方式
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException4 {
    /**
     * 采用异常抛出处理方式进行数组下标越界处理
     *
     * @throws ArrayIndexOutOfBoundsException 数组下标越界异常
     */
    public void method1() throws ArrayIndexOutOfBoundsException {
        String[] names = {"小凳子", "小椅子", "小桌子"};
        for (int i = 0; i < 4; i++) {
            System.out.println(names[i]);
        }
        System.out.println("over");
    }

    /**
     * 采用异常抛出处理方式进行数学计算和数字格式化处理
     *
     * @param a 命令行参数
     * @param b 命令行参数
     * @throws ArithmeticException   数学计算异常
     * @throws NumberFormatException 数字格式化异常
     */
    public void method2(String a, String b) throws ArithmeticException, NumberFormatException {
        double c = Integer.parseInt(a) / Integer.parseInt(b);
        System.out.println(c);
    }

    /**
     * 采用最简化的方法抛出异常处理
     *
     * @param a 命令行参数
     * @param b 命令行参数
     * @throws Exception 包含了所有的异常
     */
    public void method3(String a, String b) throws Exception {
        double c = Integer.parseInt(a) / Integer.parseInt(b);
        System.out.println(c);
    }

    public static void main(String[] args) {

        TestException4 te = new TestException4();

        // 调用 method1 方法进行异常处理
        try {
            te.method1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        // 调用 method2 方法进行异常处理
        try {
            te.method2(args[0], args[1]);
        } catch (ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        }

        // 调用 method3 方法进行异常处理
        try {
            te.method3(args[0], args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
