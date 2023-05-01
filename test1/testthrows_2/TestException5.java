package com.lanqiao.javalearn.java2.test1.testthrows_2;

/**
 * @project: TestException5
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException5 {
    /**
     * throw 和 throws 配置使用
     *
     * @throws Exception 异常类
     */
    public void method1() throws Exception {
        String[] names = {"小凳子", "小椅子", "小桌子"};

        for (int i = 0; i < 4; i++) {
            if (i > names.length - 1) {
                throw new ArrayIndexOutOfBoundsException("数组下标越界异常：数组元素提取下标为" + i +
                        ",超出数组取值范围！");

            }
            System.out.println(names[i]);
        }
        System.out.println("over");
    }

    /**
     * throw 和 try-catch 配置使用
     *
     * @param a 命令行参数
     * @param b 命令行参数
     */
    public void method2(String a, String b) {
        double c = 0.0;
        try {
            int a1 = Integer.parseInt(a);
            if (a1 == 0) {
                throw new RuntimeException("第一个参数为0，除法计算结果永远都是零");
            }
            int b1 = Integer.parseInt(b);
            if (b1 == 0) {
                throw new ArithmeticException("除数不能为零");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        TestException4 te = new TestException4();
        // 调用 mehtod1 方法进行异常处理
        try {
            te.method1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 调用 method2 方法
        te.method2(args[0], args[1]);
    }
}
