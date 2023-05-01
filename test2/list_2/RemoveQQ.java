package com.lanqiao.javalearn.java2.test2.list_2;

import java.util.*;

/**
 * @project: 去掉重复的号码
 * @author: mikudd3
 * @version: 1.0
 */
public class RemoveQQ {
    public static void main(String[] args) {

        //存储QQ数组
        String[] qqArr = {"1231561", "89571806", "151235", "76824338", "89571806", "121311", "89571806", "13211", "76824338", "123456", "76824338", "123456", "89571806", "12344", "76824338", "12344", "76824338", "112345", "123456", "1123344", "7677471", "89571806", "1475639", "76824338", "89571806", "1805385443", "18117197", "774768204", "76824338", "89571806", "76824338", "10172214", "1345759", "75776909", "757747069"};

        //创建list集合
        List<String> arr = new ArrayList<>();

        //将数据加入集合
        Collections.addAll(arr, qqArr);

        arr = repeat(arr);

        System.out.println(arr);
//        System.out.println(arr.size());

    }

    public static List<String> repeat(List<String> arr) {
//        //辅助集合
//        List<String> newArr = new ArrayList<>();
//
//        for (String s : arr) {
//            if (!newArr.contains(s)) {
//                newArr.add(s);
//            }
//        }
////        System.out.println(newArr.size());
//        return newArr;
        Set<String> set = new HashSet<>(arr);
        return new ArrayList<>(set);
//        for(int i = 0;i < arr.size();i ++){
//            for(int j = i + 1;j < arr.size();j ++){
//                if(arr.get(i).equals(arr.get(j))){
//                    arr.remove(j);
//                    i --;
//                    break;
//                }
//            }
//        }
//        System.out.println(arr.size());
//
//        return null;
    }
}
