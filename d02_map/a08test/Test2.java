package itheima.java2.d02_map.a08test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
       /* �༶����N��ѧ��
        Ҫ��
        70%�ĸ������������
        30%�ĸ��������Ů��

        "����","����","��ͳ","������","�κϷ�","������","����Ⱥ","���������",
        "������","Ԭ����","���","������",
        */


        //1.��������
        ArrayList<Integer> list = new ArrayList<>();
        //2.�������
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1);
        Collections.addAll(list, 0, 0, 0);
        //3.���Ҽ����е�����
        Collections.shuffle(list);
        //4.��list�����������ȡ0����1
        int number = list.get(0);
        //5.�����������Ϸֱ�洢������Ů��������
        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();

        Collections.addAll(boyList, "����", "����", "��ͳ", "������", "�κϷ�", "������", "����Ⱥ", "���������");
        Collections.addAll(girlList, "������", "Ԭ����", "���", "������");

        //6.�жϴ�ʱ�Ǵ�boyList�����ȡ���Ǵ�girlList�����ȡ
        if (number == 1) {
            //boyList
            Collections.shuffle(boyList);
            String name = boyList.get(0);
            System.out.println(name);
        } else {
            //girlList
            Collections.shuffle(girlList);
            String name = girlList.get(0);
            System.out.println(name);
        }


    }
}
