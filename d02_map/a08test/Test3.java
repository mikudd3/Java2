package itheima.java2.d02_map.a08test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
       /* �༶����5��ѧ��
        Ҫ��
        ���㵽��ѧ�������ٱ��㵽��
        ��������༶�����е�ѧ���������ˣ���Ҫ���¿����ڶ��ֵ�����*/
        //1.���弯��
        ArrayList<String> list1 = new ArrayList<>();
        //2.�������
        Collections.addAll(list1, "����", "����", "��ͳ", "������", "������", "�κϷ�", "������", "����Ⱥ", "���������", "Ԭ����");
        //����һ����ʱ�ļ��ϣ��������Ѿ����㵽ѧ��������
        ArrayList<String> list2 = new ArrayList<>();
        //��ѭ������ʾ����
        for (int i = 1; i <= 10; i++) {
            System.out.println("=========��" + i + "�ֵ�����ʼ��======================");
            //3.��ȡ���ϵĳ���
            int count = list1.size();
            //4.�������
            Random r = new Random();
            //��ѭ����ÿһ�������ѭ����ȡ�Ĺ���
            for (int j = 0; j < count; j++) {
                int index = r.nextInt(list1.size());
                String name = list1.remove(index);
                list2.add(name);
                System.out.println(name);
            }
            //��ʱ��ʾһ�ֵ�������
            //list1 ���� list2 10��ѧ��������
            list1.addAll(list2);
            list2.clear();

        }


    }
}
