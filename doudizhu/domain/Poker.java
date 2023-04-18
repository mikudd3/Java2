package itheima.java2.doudizhu.domain;

import itheima.java2.doudizhu.game.GameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {

	//��Ϸ��������
	GameJFrame gameJFrame;
	//�Ƶ�����
	String name;
	//����ʾ���滹�Ƿ���
	boolean up;
	//�Ƿ�ɵ��
	boolean canClick = false;
	//��ǰ״̬���Ƿ��Ѿ������
	boolean clicked = false;

	public Poker(GameJFrame m, String name, boolean up) {
		this.gameJFrame = m;
		this.name = name;
		this.up = up;
		//�жϵ�ǰ��������ʾ���滹�Ǳ���
		if (this.up){
			this.turnFront();
		}else {
			this.turnRear();
		}
		//�����ƵĿ�ߴ�С
		this.setSize(71, 96);
		//������ʾ����
		this.setVisible(true);
		//��ÿһ�������������
		this.addMouseListener(this);
	}

	public Poker() {
	}

	public Poker(GameJFrame gameJFrame, String name, boolean up, boolean canClick, boolean clicked) {
		this.gameJFrame = gameJFrame;
		this.name = name;
		this.up = up;
		this.canClick = canClick;
		this.clicked = clicked;
	}

	//��ʾ����
	public void turnFront() {
		this.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/poker" + name + ".png"));
		this.up = true;
	}

	//��ʾ����
	public void turnRear() {
		this.setIcon(new ImageIcon("src/itheima/java2/doudizhu/image/poker/rear.png"));
		this.up = false;
	}


	//����ʱ����Ҫ�����
	//�����֮���������ƶ�20������
	//�ٴα�������ƻ���20������
	@Override
	public void mouseClicked(MouseEvent e) {
		if (canClick) {
			Point from = this.getLocation();
			int step;
			if (clicked){
				step = 20;
			}else {
				step = -20;
			}
			clicked = !clicked;
			Point to = new Point(from.x, from.y + step);
			this.setLocation(to);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}


	/**
	 * ��ȡ
	 * @return gameJFrame
	 */
	public GameJFrame getGameJFrame() {
		return gameJFrame;
	}

	/**
	 * ����
	 * @param gameJFrame
	 */
	public void setGameJFrame(GameJFrame gameJFrame) {
		this.gameJFrame = gameJFrame;
	}

	/**
	 * ��ȡ
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ
	 * @return up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * ����
	 * @param up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * ��ȡ
	 * @return canClick
	 */
	public boolean isCanClick() {
		return canClick;
	}

	/**
	 * ����
	 * @param canClick
	 */
	public void setCanClick(boolean canClick) {
		this.canClick = canClick;
	}

	/**
	 * ��ȡ
	 * @return clicked
	 */
	public boolean isClicked() {
		return clicked;
	}

	/**
	 * ����
	 * @param clicked
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public String toString() {
		return "Poker{gameJFrame = " + gameJFrame + ", name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
	}
}
