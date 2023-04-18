package itheima.java2.d02_map.a09rollname;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton go = new JButton("Go");


    public Login() {
        //����ͼ��
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/itheima/java2/d02_map/a09rollname/logo.jpg"));

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
        if(obj == go){
            this.setVisible(false);
            new CheatJFrame();
        }

    }



    //������
    public void initView() {

        JLabel image = new JLabel(new ImageIcon("src/itheima/java2/d02_map/a09rollname/kit.jpg"));
        image.setBounds(100,50,174,174);
        this.getContentPane().add(image);


        go.setFont(new Font(null,1,20));
        go.setBounds(120,274,150,50);
        go.setBackground(Color.WHITE);
        go.addActionListener(this);

        this.getContentPane().add(go);

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
