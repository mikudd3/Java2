package itheima.java2.d02_map.doudizhu2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    //�ƺ� Map
    //��ʱ����ֻҪ���Ƹ���Ų�����Ӧ��ϵ�Ϳ����ˣ�����Ҫ������Ž�����������ֻҪHashMap�Ϳ�����
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();


    static {
        String[] color = {"?", "?", "?", "?" };
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //���
        int serialNumber = 1;
        //ϸ��
        for (String n : number) {
            //���α�ʾÿһ������
            for (String c : color) {
                //���α�ʾÿһ����ɫ
                hm.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }

        hm.put(serialNumber, "С��");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "����");
        list.add(serialNumber);

    }


    public PokerGame() {
        //ϴ��
        Collections.shuffle(list);

        //����
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            //i :���α�ʾ�����е�ÿһ������
            //list.get(i)Ԫ�أ��Ƶ����
            int serialNumber = list.get(i);

            if(i <= 2){
                lord.add(serialNumber);
                continue;
            }

            if(i % 3 == 0){
                player1.add(serialNumber);
            }else if(i % 3 == 1){
                player2.add(serialNumber);
            }else{
                player3.add(serialNumber);
            }
        }


        //����
        lookPoker("����",lord);
        lookPoker("���Կ�",player1);
        lookPoker("��˧��",player2);
        lookPoker("��Ͳ",player3);


    }

    /*
    * ����һ����ҵ�����
    * ���������Ƶ����
    * */
    public void lookPoker(String name, TreeSet<Integer> ts){
        System.out.print(name + ": ");
        //����TreeSet���ϵõ�ÿһ����ţ���������ŵ�Map������ȥ����������
        for (int serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker + " ");
        }
        System.out.println();
    }


}
