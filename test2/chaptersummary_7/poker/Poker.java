package com.lanqiao.javalearn.java2.test2.chaptersummary_7.poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @project: 模拟斗地主
 * @author: mikudd3
 * @version: 1.0
 */
public class Poker {
    public static void main(String[] args) {
        //准备牌操作
        //创建集合
        ArrayList<String> array = new ArrayList<>();
        //定义花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义点数数组
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        // 组装牌
        for (String color : colors) {
            for (String number : numbers) {
                array.add(color + number);
            }
        }
        array.add("大王");
        array.add("小王");

        // 洗牌
        Collections.shuffle(array);

        // 发牌
        ArrayList<String> playerA = new ArrayList<>();
        ArrayList<String> playerB = new ArrayList<>();
        ArrayList<String> playerC = new ArrayList<>();
        ArrayList<String> endCards = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            String poker = array.get(i);

            if (i >= array.size() - 3) {
                endCards.add(poker);
            } else if (i % 3 == 0) {
                playerA.add(poker);
            } else if (i % 3 == 1) {
                playerB.add(poker);
            } else {
                playerC.add(poker);
            }
        }

        // 看牌
        System.out.println("玩家A的牌为：");
        lookPoker(playerA);
        System.out.println("玩家B的牌为：");
        lookPoker(playerB);
        System.out.println("玩家C的牌为：");
        lookPoker(playerC);
        System.out.println("底牌为：");
        lookPoker(endCards);


    }

    public static void lookPoker(ArrayList<String> arr) {
        for (String poker : arr) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
