package itheima.java2.doudizhu.game;


import itheima.java2.doudizhu.app.CodeUtil;
import itheima.java2.doudizhu.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("zhangsan","123"));
        allUsers.add(new User("lishi","1234"));
    }


    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    //JTextField password = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    //��ȷ����֤��
    JLabel rightCode = new JLabel();


    public LoginJFrame() {
        //��ʼ������
        initJFrame();
        //������������������
        initView();
        //�õ�ǰ������ʾ����
        this.setVisible(true);
    }

    public void initView() {
        //1. ����û�������
        Font usernameFont = new Font(null,1,16);
        JLabel usernameText = new JLabel("�û���");
        usernameText.setForeground(Color.white);
        usernameText.setFont(usernameFont);
        usernameText.setBounds(140, 55, 55, 22);
        this.getContentPane().add(usernameText);

        //2.����û��������
        username.setBounds(223, 46, 200, 30);
        this.getContentPane().add(username);

        //3.�����������
        JLabel passwordText = new JLabel("����");
        Font passwordFont = new Font(null,1,16);
        passwordText.setForeground(Color.white);
        passwordText.setFont(passwordFont);
        passwordText.setBounds(197, 95, 40, 22);
        this.getContentPane().add(passwordText);

        //4.���������
        password.setBounds(263, 87, 160, 30);
        this.getContentPane().add(password);

        //��֤����ʾ
        JLabel codeText = new JLabel("��֤��");
        Font codeFont = new Font(null,1,16);
        codeText.setForeground(Color.white);
        codeText.setFont(codeFont);
        codeText.setBounds(215, 142, 55, 22);
        this.getContentPane().add(codeText);

        //��֤��������
        code.setBounds(291, 133, 100, 30);
        this.getContentPane().add(code);

        //��ȡ��ȷ����֤��
        String codeStr = CodeUtil.getCode();
        Font rightCodeFont = new Font(null,1,15);
        //������ɫ
        rightCode.setForeground(Color.RED);
        //��������
        rightCode.setFont(rightCodeFont);
        //��������
        rightCode.setText(codeStr);
        //������¼�
        rightCode.addMouseListener(this);
        //λ�úͿ��
        rightCode.setBounds(400, 133, 100, 30);
        //��ӵ�����
        this.getContentPane().add(rightCode);

        //5.��ӵ�¼��ť
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/��¼��ť.png"));
        //ȥ����ť�ı߿�
        login.setBorderPainted(false);
        //ȥ����ť�ı���
        login.setContentAreaFilled(false);
        //����¼��ť������¼�
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.���ע�ᰴť
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/ע�ᰴť.png"));
        //ȥ����ť�ı߿�
        register.setBorderPainted(false);
        //ȥ����ť�ı���
        register.setContentAreaFilled(false);
        //��ע�ᰴť������¼�
        register.addMouseListener(this);
        this.getContentPane().add(register);


        //7.��ӱ���ͼƬ
        JLabel background = new JLabel(new ImageIcon("src/itheima/java2/doudizhu/image/login/background.png"));
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);

    }


    public void initJFrame() {
        this.setSize(633, 423);//���ÿ��
        this.setTitle("��������Ϸ V1.0��¼");//���ñ���
        this.setDefaultCloseOperation(3);//���ùر�ģʽ
        this.setLocationRelativeTo(null);//����
        this.setAlwaysOnTop(true);//�ö�
        this.setLayout(null);//ȡ���ڲ�Ĭ�ϲ���
    }



    //���
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            System.out.println("����˵�¼��ť");
            //��ȡ�����ı�������е�����
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            //��ȡ�û��������֤��
            String codeInput = code.getText();


            //�ж���֤���Ƿ�Ϊ��
            if (codeInput.length() == 0) {
                showJDialog("��֤�벻��Ϊ��");
                return;
            }

            //�ж��û����������Ƿ�Ϊ��
            if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("�û��������벻��Ϊ��");
                return;
            }

            //�ж���֤���Ƿ���ȷ
            if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("��֤���������");
                return;
            }

            //�жϼ������Ƿ������ǰ�û�����
            //��ʵ������֤�û����������Ƿ���ͬ
            //contains�ײ�������equals�����жϵģ�������Ҫ��дequals����
            User userInfo = new User(usernameInput, passwordInput);
            if (allUsers.contains(userInfo)) {
                //�رյ�ǰ��¼����
                this.setVisible(false);
                //����Ϸ��������
                new GameJFrame();
            } else {
                showJDialog("�û������������");
            }
        } else if (e.getSource() == register) {
            System.out.println("�����ע�ᰴť");
        } else if (e.getSource() == rightCode) {
            System.out.println("������֤��");
            //��ȡһ���µ���֤��
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }


    public void showJDialog(String content) {
        //����һ���������
        JDialog jDialog = new JDialog();
        //���������ô�С
        jDialog.setSize(200, 150);
        //�õ����ö�
        jDialog.setAlwaysOnTop(true);
        //�õ������
        jDialog.setLocationRelativeTo(null);
        //���򲻹ر���Զ�޷���������Ľ���
        jDialog.setModal(true);

        //����Jlabel����������ֲ���ӵ�������
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        //�õ���չʾ����
        jDialog.setVisible(true);
    }

    //���²���
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/��¼����.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/ע�ᰴ��.png"));
        }
    }


    //�ɿ���ť
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/��¼��ť.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/login/ע�ᰴť.png"));
        }
    }

    //��껮��
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //��껮��
    @Override
    public void mouseExited(MouseEvent e) {

    }


}