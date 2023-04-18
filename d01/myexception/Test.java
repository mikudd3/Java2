package itheima.java2.d01.myexception;

import java.util.Scanner;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入分数：");

        int score = input.nextInt();
        new Teacher().checkScore(score);
    }
}
