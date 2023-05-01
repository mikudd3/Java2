package com.lanqiao.javalearn.java2.test2.chaptersummary_7.book;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @project: 模拟图书管理系统
 * @author: mikudd3
 * @version: 1.0
 */
public class Library {
    private static Set<Book> data = new HashSet<>();

    static Scanner input = new Scanner(System.in);

    /**
     * 菜单
     */
    public static void showMenu() {
        System.out.println("------欢迎来到mikudd3图书管理系统------");
        System.out.println("1.添加图书");
        System.out.println("2.查询图书");
        System.out.println("3.删除图书");
        System.out.println("4.退出程序");
    }

    /**
     * 添加图书
     */
    public static void addBook() {
        Book b = new Book();
        System.out.println("请输入图书id");
        b.setId(input.nextInt());
        System.out.println("请输入书名：");
        b.setName(input.next());
        System.out.println("请输入作者名：");
        b.setAuthor(input.next());
        System.out.println("请输入价格：");
        b.setPrice(input.nextDouble());
        data.add(b);
        System.out.println("添加成功！");

    }

    /**
     * 删除图书
     */
    public static void deleteBook() {
        System.out.println("请输入要删除的图书id：");
        int id = input.nextInt();
        data.removeIf(b -> b.getId() == id);
        System.out.println("删除成功！");
    }
    /**
     * 查询图书
     */
    public static void selectBook(){
        System.out.println("以下为所有图书信息：");
        for(Book b : data){
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        while(true){
            showMenu();
            System.out.println("请输入选项：");
            int select = input.nextInt();
            switch (select) {
                case 1 -> addBook();
                case 2 -> selectBook();
                case 3 -> deleteBook();
                case 4 -> {
                    System.out.println("退出成功");
                    System.exit(0);
                }
            }
        }
    }
}
