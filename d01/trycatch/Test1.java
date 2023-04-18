package itheima.java2.d01.trycatch;

/**
 * @project: try catch 的使用
 * @author: mikudd3
 * @version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    public static void method() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
        }
    }
}
