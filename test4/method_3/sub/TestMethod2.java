package com.lanqiao.javalearn.java2.test4.method_3.sub;

import java.lang.reflect.Method;

/**
 * @project: getDeclaredMethods 和 getMethods 方法的区别
 * @author: mikudd3
 * @version: 1.0
 */
public class TestMethod2 {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("com.lanqiao.javalearn.java2.test4.method_3.sub.Sub");
            //返回Method的对象数组，存放该类或接口的所有方法（不含继承的）

            Method[] mlist = c.getDeclaredMethods();
            System.out.println("Sub 类 getDeclaredMethods()得到的方法如下：");
            //遍历所有方法
            for (int i = 0; i < mlist.length; i++) {
                System.out.println("****************************************");
                Method m = mlist[i];
                System.out.println("方法" + (i + 1) + "名称为：" + m.getName());//得到方法名
                System.out.println("该方法所在的类或接口为：" + m.getDeclaringClass());
                //返回Class对象数组，表示Method对象所表示的方法的形参类型
                Class<?>[]  ptl= m.getParameterTypes();
                for (int j = 0; j < ptl.length; j++)
                    System.out.println("形参" + (j + 1) + " 类型为：" + ptl[j]);
                //返回Class对象数组，表示Method对象所表示的方法的异常列表
                Class<?>[] etl = m.getExceptionTypes();
                for (int j = 0; j < etl.length; j++)
                    System.out.println("异常" + (j + 1) + " 类型为：" + etl[j]);
                System.out.println("返回值类型为：" + m.getReturnType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
