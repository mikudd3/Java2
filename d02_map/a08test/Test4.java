package itheima.java2.d02_map.a08test;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
       /* ����
        ����һ��Map���ϣ����ñ�ʾʡ������province��ֵ��ʾ��city�������л��ж����
        �����Ϻ󣬱��������ʽ���£�
                ����ʡ = �Ͼ��У������У������У������У�������
                ����ʡ = �人�У�Т���У�ʮ���У��˲��У�������
                �ӱ�ʡ = ʯ��ׯ�У���ɽ�У���̨�У������У��żҿ���*/


        //1.����Map����
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //2.�������м��ϴ洢��
        ArrayList<String> city1 = new ArrayList<>();
        city1.add("�Ͼ���");
        city1.add("������");
        city1.add("������");
        city1.add("������");
        city1.add("������");

        ArrayList<String> city2 = new ArrayList<>();
        city2.add("�人��");
        city2.add("Т����");
        city2.add("ʮ����");
        city2.add("�˲���");
        city2.add("������");

        ArrayList<String> city3 = new ArrayList<>();
        city3.add("ʯ��ׯ��");
        city3.add("��ɽ��");
        city3.add("��̨��");
        city3.add("������");
        city3.add("�żҿ���");

        //3.��ʡ�ݺͶ������ӵ�map����
        hm.put("����ʡ",city1);
        hm.put("����ʡ",city2);
        hm.put("�ӱ�ʡ",city3);

        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            //entry���α�ʾÿһ����ֵ�Զ���
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(", ","","");
            for (String city : value) {
                sj.add(city);
            }

            System.out.println(key + " = " + sj);

        }

    }
}
