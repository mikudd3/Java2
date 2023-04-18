package itheima.java2.doudizhu.game;


import itheima.java2.doudizhu.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GameJFrame extends JFrame implements ActionListener {

    //��ȡ�����е���������
    //����ͳһ��ȡ�ˣ�����ֱ���þͿ�����
    public Container container = null;

    //�����������Ͳ���������ť
    JButton landlord[] = new JButton[2];

    //������ƺͲ�Ҫ������ť
    JButton publishCard[] = new JButton[2];

    int dizhuFlag;
    int turn;

    //��Ϸ�����е�����ͼ��
    JLabel dizhu;


    //����Ƕ�׼���
    //�󼯺���������С����
    //С������װ��ÿһ����ҵ�ǰҪ������
    //0��������ߵĵ������
    //1�������м���Լ�
    //2�������ұߵĵ������
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    //����Ƕ�׼���
    //�󼯺���������С����
    //С������װ��ÿһ����ҵ���
    //0��������ߵĵ������
    //1�������м���Լ�
    //2�������ұߵĵ������
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    //����
    ArrayList<Poker> lordList = new ArrayList<>();

    //�ƺУ�װ���е���
    ArrayList<Poker> pokerList = new ArrayList();

    //�������ǰ�����ı���ʾ
    //0��������ߵĵ������
    //1�������м���Լ�
    //2�������ұߵĵ������
    JTextField time[] = new JTextField[3];

    //�û��������漰���̵߳�֪ʶ
    PlayerOperation po;

    boolean nextPlayer = false;

    public GameJFrame() {
        //����ͼ��
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/itheima/java2/doudizhu/image/dizhu.png"));
        //���ý���
        initJframe();
        //������
        initView();
        //������ʾ����
        //��չʾ�����ٷ��ƣ���Ϊ���������ж��������治չʾ�����������޷�չʾ
        this.setVisible(true);
        //��ʼ����
        //׼���ƣ�ϴ�ƣ�����
        new Thread(this::initCard).start();


        //����֮ǰ��׼������
        //չʾ�������Ͳ�������������ť�����ٴ���������������װ�������׼��Ҫ������
        initGame();

    }


    //��ʼ����
    //׼���ƣ�ϴ�ƣ�����
    public void initCard() {
        //׼����
        //�����е��ƣ�������С������ӵ��ƺ�cardList����
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if ((i == 5) && (j > 2)) {
                    break;
                } else {
                    Poker poker = new Poker(this, i + "-" + j, false);
                    poker.setLocation(350, 150);

                    pokerList.add(poker);
                    container.add(poker);
                }
            }
        }

        //ϴ��
        Collections.shuffle(pokerList);

        //����������������װ������ҵ��ƣ���������С���Ϸŵ��󼯺��з������
        ArrayList<Poker> player0 = new ArrayList<>();
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            //��ȡ��ǰ��������
            Poker poker = pokerList.get(i);

            //�����ŵ���
            if (i <= 2) {
                //�ƶ���
                Common.move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                //�ѵ�����ӵ�������
                lordList.add(poker);
                continue;
            }
            //��������ҷ���
            if (i % 3 == 0) {
                //����ߵĵ��Է���
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
                player0.add(poker);
            } else if (i % 3 == 1) {
                //���м���Լ�����
                Common.move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
                player1.add(poker);
                //���Լ�����չʾ����
                poker.turnFront();

            } else if (i % 3 == 2) {
                //���ұߵĵ��Է���
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
                player2.add(poker);
            }
            //������װ���Ƶ�С���Ϸŵ��󼯺��з������
            playerList.add(player0);
            playerList.add(player1);
            playerList.add(player2);

            //�ѵ�ǰ����������ˣ������ͻ��������δ��ҵ�������Ч��
            container.setComponentZOrder(poker, 0);

        }

        //��������
        for (int i = 0; i < 3; i++) {
            //����
            Common.order(playerList.get(i));
            //���°ڷ�˳��
            Common.rePosition(this, playerList.get(i), i);
        }





    }

    //����֮ǰ��׼������
    private void initGame() {
        //����������������װ�������׼��Ҫ������
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            //��ӵ��󼯺��з������
            currentList.add(list);
        }

        //չʾ�������Ͳ�������������ť
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        //չʾ�Լ�ǰ��ĵ���ʱ�ı�
        time[1].setVisible(true);
        //����ʱ10��
        po = new PlayerOperation(this, 30);
        //��������ʱ
        po.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == landlord[0]) {
            //���������
            time[1].setText("������");
            po.isRun = false;
        } else if (e.getSource() == landlord[1]) {
            //�������
            time[1].setText("����");
            po.isRun = false;
        } else if (e.getSource() == publishCard[1]) {
            //�����Ҫ
            this.nextPlayer = true;
            currentList.get(1).clear();
            time[1].setText("��Ҫ");
        } else if (e.getSource() == publishCard[0]) {
            //�������

            //����һ����ʱ�ļ��ϣ�������ŵ�ǰҪ������
            ArrayList<Poker> c = new ArrayList<>();
            //��ȡ���Լ��������е���
            ArrayList<Poker> player2 = playerList.get(1);

            //�������ϵ��ƣ���Ҫ�����ƶ��ŵ���ʱ������
            for (int i = 0; i < player2.size(); i++) {
                Poker poker = player2.get(i);
                if (poker.isClicked()) {
                    c.add(poker);
                }
            }

            int flag = 0;
            //�жϣ��������������������Ƿ񶼲�Ҫ
            if (time[0].getText().equals("��Ҫ") && time[2].getText().equals("��Ҫ")) {
                if (Common.jugdeType(c) != PokerType.c0){
                    flag = 1;
                }
            } else {
                flag = Common.checkCards(c, currentList, this);
            }

            if (flag == 1) {
                //�ѵ�ǰҪ�����ƣ��ŵ��󼯺���ͳһ����
                currentList.set(1, c);
                //�����ϵ����У�ȥ���Ѿ���������
                player2.removeAll(c);

                //�������겢�ƶ���
                //�ƶ���Ŀ����Ҫ�������ƶ����Ϸ�
                Point point = new Point();
                point.x = (770 / 2) - (c.size() + 1) * 15 / 2;
                point.y = 300;
                for (int i = 0, len = c.size(); i < len; i++) {
                    Poker poker = c.get(i);
                    Common.move(poker, poker.getLocation(), point);
                    point.x += 15;
                }

                //���°ڷ�ʣ�����
                Common.rePosition(this, player2, 1);
                //Ӯ���ı���ʾ
                time[1].setVisible(false);
                //��һ����ҿ���
                this.nextPlayer = true;
            }

        }
    }

    //������
    public void initView() {
        //�����������İ�ť
        JButton robBut = new JButton("������");
        //����λ��
        robBut.setBounds(320, 400, 75, 20);
        //��ӵ���¼�
        robBut.addActionListener(this);
        //��������
        robBut.setVisible(false);
        //��ӵ�������ͳһ����
        landlord[0] = robBut;
        //��ӵ�������
        container.add(robBut);

        //���������İ�ť
        JButton noBut = new JButton("��     ��");
        //����λ��
        noBut.setBounds(420, 400, 75, 20);
        //��ӵ���¼�
        noBut.addActionListener(this);
        //��������
        noBut.setVisible(false);
        //��ӵ�������ͳһ����
        landlord[1] = noBut;
        //��ӵ�������
        container.add(noBut);

        //�������Ƶİ�ť
        JButton outCardBut = new JButton("����");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //������Ҫ�İ�ť
        JButton noCardBut = new JButton("��Ҫ");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //�����������ǰ������ʾ���֣�����ʱ
        //ÿ�����һ��
        //��ߵĵ��������0
        //�м���Լ���1
        //�ұߵĵ��������2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("����ʱ��");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);


        //��������ͼ��
        dizhu = new JLabel(new ImageIcon("src/itheima/java2/doudizhu/image/dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);



    }

    //���ý���
    public void initJframe() {
        //���ñ���
        this.setTitle("������");
        //���ô�С
        this.setSize(830, 620);
        //���ùر�ģʽ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô����޷����е���
        this.setResizable(false);
        //�������
        this.setLocationRelativeTo(null);
        //��ȡ�����е������������Ժ�ֱ���������ٴε��÷�����ȡ��
        container = this.getContentPane();
        //ȡ���ڲ�Ĭ�ϵľ��з���
        container.setLayout(null);
        //���ñ�����ɫ
        container.setBackground(Color.LIGHT_GRAY);
    }

}
