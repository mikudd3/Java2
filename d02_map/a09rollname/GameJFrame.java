package itheima.java2.d02_map.a09rollname;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame{
    public GameJFrame() {
        //���ý���
        initJframe();

        //������
        initView();

        //������ʾ����
        this.setVisible(true);

    }

    //������
    public void initView() {

        JLabel countDown = new JLabel("����ʱ��5��");
        countDown.setFont(new Font(null,1,50));
        countDown.setBounds(50,50,300,60);
        this.getContentPane().add(countDown);


        JLabel namePrompt = new JLabel("�н�ѡ��Ϊ��");
        namePrompt.setFont(new Font(null,1,20));
        namePrompt.setBounds(80,150,125,30);
        this.getContentPane().add(namePrompt);

        JLabel rollName = new JLabel("XXX");
        rollName.setFont(new Font(null,1,20));
        rollName.setBounds(200,150,125,30);
        this.getContentPane().add(rollName);

        JLabel rollImage = new JLabel(new ImageIcon("Ĭ��ͼƬ·��"));
        rollImage.setBounds(87,200,210,210);
        this.getContentPane().add(rollImage);

        JButton start = new JButton("��ʼ");
        start.setFont(new Font(null,1,20));
        start.setBounds(118,430,150,50);
        start.setBackground(Color.WHITE);
        //start.addActionListener(this);
        this.getContentPane().add(start);

    }


    //���ý���
    public void initJframe() {
        //���ñ���
        this.setTitle("���������");
        //���ô�С
        this.setSize(400, 600);
        //���ùر�ģʽ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô����޷����е���
        this.setResizable(false);
        //�������
        this.setLocationRelativeTo(null);
        //ȡ���ڲ�Ĭ�Ͼ��з���
        this.setLayout(null);
        //���ñ�����ɫ
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//�ö�
    }



}
