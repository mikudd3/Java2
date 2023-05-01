package com.lanqiao.javalearn.java2.test1.myecception_3;

/**
 * @project: 自定义异常类的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class TestException6 {
    /**
     * 获取数组元素数据
     *
     * @param arrays int类型数组
     * @param index  数组下标
     * @throws ArrayIsNullException 数组为空的异常
     */
    public void method1(int[] arrays, int index) throws ArrayIsNullException {

        //如果数组长度为0，则为空数组
        if (0 == arrays.length) {
            //throw new ArrayIsNullException();
            throw new ArrayIsNullException("数组为空，提取不到下标"
                    + index + "的数组元素.");

        }
        System.out.println(arrays[index]);
    }

    public static void main(String[] args) {
        TestException6 te = new TestException6();
        try {
            te.method1(new int[]{}, 2);
        } catch (ArrayIsNullException e) {
            System.out.println(e.getMessage());
        }
    }
}

