package itheima.java2.d02_map.a09rollname;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheatJFrame extends JFrame implements ActionListener {


    JButton submit = new JButton("ȷ��");


    public CheatJFrame() {
        //���ý���
        initJframe();

        //������
        initView();

        //������ʾ����
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == submit){
            this.setVisible(false);
            new GameJFrame();
        }
    }

    //������
    public void initView() {
        JLabel cheat = new JLabel("����ʱ��");
        cheat.setFont(new Font(null,1,30));
        cheat.setBounds(130,10,130,30);
        this.getContentPane().add(cheat);

        JLabel hint1 = new JLabel("���ᱻ�㵽����");
        hint1.setFont(new Font(null,0,20));
        hint1.setBounds(30,100,140,30);
        this.getContentPane().add(hint1);

        JTextField noRollName = new JTextField();
        noRollName.setBounds(180,100,140,30);
        this.getContentPane().add(noRollName);

        JLabel hint2 = new JLabel("��");
        hint2.setFont(new Font(null,0,20));
        hint2.setBounds(30,200,30,30);
        this.getContentPane().add(hint2);

        JTextField count = new JTextField();
        count.setBounds(60,200,30,30);
        this.getContentPane().add(count);

        JLabel hint3 = new JLabel("��,һ���ᱻ�㵽�����ǣ�");
        hint3.setFont(new Font(null,0,20));
        hint3.setBounds(100,200,230,30);
        this.getContentPane().add(hint3);

        JTextField rollName = new JTextField();
        rollName.setBounds(210,240,100,30);
        this.getContentPane().add(rollName);


       submit.setFont(new Font(null,1,20));
       submit.setBounds(110,300,150,50);
       submit.setBackground(Color.WHITE);
       submit.addActionListener(this);
       this.getContentPane().add(submit);

    }


    //���ý���
    public void initJframe() {
        //���ñ���
        this.setTitle("���������");
        //���ô�С
        this.setSize(400, 500);
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
