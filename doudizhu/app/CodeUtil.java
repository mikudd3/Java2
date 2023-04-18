package itheima.java2.doudizhu.app;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    public static String getCode(){
        //1.����һ������
        ArrayList<Character> list = new ArrayList<>();//52  �����ķ�Χ��0 ~ 51
        //2.�����ĸ a - z  A - Z
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));//a - z
            list.add((char)('A' + i));//A - Z
        }
        //3.��ӡ����
        System.out.println(list);
        //4.����4�������ĸ
        String result = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            //��ȡ�������
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            result = result + c;
        }
        //System.out.println(result);//����Ϊ4������ַ���

        //5.�ں���ƴ������ 0~9
        int number = r.nextInt(10);
        //6.���������ƴ�ӵ�result�ĺ���
        result = result + number;
        //System.out.println(result);//ABCD5
        //7.���ַ�������ַ�����
        char[] chars = result.toCharArray();//[A,B,C,D,5]
        //8.���ַ�����������һ���������
        int index = r.nextInt(chars.length);
        //9.����4�����ϵ����֣�����������ϵ����ֽ��н���
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;
        //10.���ַ������ٱ���ַ���
        String code = new String(chars);
        //System.out.println(code);
        return code;
    }
}