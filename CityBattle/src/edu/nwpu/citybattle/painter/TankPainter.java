package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.AiTankArray;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 该类用于绘制坦克，包括己方和敌方坦克
 * 
 * @author 微笑未失
 * @see initialPainter
 * @see loadImg
 * @see drawAITanks
 * @see drawMyTank
 * @see drawTanks
 */
@SuppressWarnings("unused")
public class TankPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private static int ELEMENT_SIZE;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	MyTank myTank;
	JPanel contentPane;

	JLabel my_tank;
//	static JLabel my_tank_up;
//	static JLabel my_tank_down;
//	static JLabel my_tank_left;
//	static JLabel my_tank_right;

	ImageIcon origin_my_tank_up;
	ImageIcon origin_my_tank_down;
	ImageIcon origin_my_tank_left;
	ImageIcon origin_my_tank_right;
	ImageIcon origin_first_tank_up;
	ImageIcon origin_first_tank_down;
	ImageIcon origin_first_tank_left;
	ImageIcon origin_first_tank_right;
	ImageIcon origin_second_tank_up;
	ImageIcon origin_second_tank_down;
	ImageIcon origin_second_tank_left;
	ImageIcon origin_second_tank_right;
	ImageIcon origin_third_tank_up;
	ImageIcon origin_third_tank_down;
	ImageIcon origin_third_tank_left;
	ImageIcon origin_third_tank_right;

	public TankPainter(JPanel contentPane, MyTank mytank) {
		this.myTank = mytank;
		this.contentPane = contentPane;
		this.initialPainter();
		this.loadImg();
		this.drawTanks();
	}

	/**
	 * 该方法用于初始化绘制大小
	 */
	public void initialPainter() {
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);

		ELEMENT_SIZE = size1 < size2 ? size1 : size2;
	}

	/**
	 * 该方法用于初始化绘制大小
	 */
	public void loadImg() {
<<<<<<< HEAD
		origin_my_tank_up = new ImageIcon(getClass().getResource("mytank_up.gif"));
		origin_my_tank_up.setImage(origin_my_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_down = new ImageIcon(getClass().getResource("mytank_down.gif"));
		origin_my_tank_down.setImage(origin_my_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_left = new ImageIcon(getClass().getResource("mytank_left.gif"));
		origin_my_tank_left.setImage(origin_my_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_right = new ImageIcon(getClass().getResource("mytank_right.gif"));
		origin_my_tank_right.setImage(origin_my_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
		origin_first_tank_up = new ImageIcon(getClass().getResource("enemy1_up.png"));
		origin_first_tank_up.setImage(origin_first_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_down = new ImageIcon(getClass().getResource("enemy1_down.png"));
		origin_first_tank_down.setImage(origin_first_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_left = new ImageIcon(getClass().getResource("enemy1_left.png"));
		origin_first_tank_left.setImage(origin_first_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_right = new ImageIcon(getClass().getResource("enemy1_right.png"));
		origin_first_tank_right.setImage(origin_first_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
		origin_second_tank_up = new ImageIcon(getClass().getResource("enemy2_up.png"));
		origin_second_tank_up.setImage(origin_second_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_down = new ImageIcon(getClass().getResource("enemy2_down.png"));
		origin_second_tank_down.setImage(origin_second_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_left = new ImageIcon(getClass().getResource("enemy2_left.png"));
		origin_second_tank_left.setImage(origin_second_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_right = new ImageIcon(getClass().getResource("enemy2_right.png"));
		origin_second_tank_right.setImage(origin_second_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
		origin_third_tank_up = new ImageIcon(getClass().getResource("enemy3_up.png"));
		origin_third_tank_up.setImage(origin_third_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_down = new ImageIcon(getClass().getResource("enemy3_down.png"));
		origin_third_tank_down.setImage(origin_third_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_left = new ImageIcon(getClass().getResource("enemy3_left.png"));
		origin_third_tank_left.setImage(origin_third_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_right = new ImageIcon(getClass().getResource("enemy3_right.png"));
		origin_third_tank_right.setImage(origin_third_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
=======
		origin_my_tank_up = new ImageIcon("img\\mytank_up.gif");
		origin_my_tank_up
				.setImage(origin_my_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_down = new ImageIcon("img\\mytank_down.gif");
		origin_my_tank_down
				.setImage(origin_my_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_left = new ImageIcon("img\\mytank_left.gif");
		origin_my_tank_left
				.setImage(origin_my_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_my_tank_right = new ImageIcon("img\\mytank_right.gif");
		origin_my_tank_right
				.setImage(origin_my_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		origin_first_tank_up = new ImageIcon("img\\enemy1_up.png");
		origin_first_tank_up
				.setImage(origin_first_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_down = new ImageIcon("img\\enemy1_down.png");
		origin_first_tank_down
				.setImage(origin_first_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_left = new ImageIcon("img\\enemy1_left.png");
		origin_first_tank_left
				.setImage(origin_first_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_right = new ImageIcon("img\\enemy1_right.png");
		origin_first_tank_right
				.setImage(origin_first_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		origin_second_tank_up = new ImageIcon("img\\enemy2_up.png");
		origin_second_tank_up
				.setImage(origin_second_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_down = new ImageIcon("img\\enemy2_down.png");
		origin_second_tank_down
				.setImage(origin_second_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_left = new ImageIcon("img\\enemy2_left.png");
		origin_second_tank_left
				.setImage(origin_second_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_right = new ImageIcon("img\\enemy2_right.png");
		origin_second_tank_right
				.setImage(origin_second_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		origin_third_tank_up = new ImageIcon("img\\enemy3_up.png");
		origin_third_tank_up
				.setImage(origin_third_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_down = new ImageIcon("img\\enemy3_down.png");
		origin_third_tank_down
				.setImage(origin_third_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_left = new ImageIcon("img\\enemy3_left.png");
		origin_third_tank_left
				.setImage(origin_third_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_right = new ImageIcon("img\\enemy3_right.png");
		origin_third_tank_right
				.setImage(origin_third_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

>>>>>>> branch 'master' of https://codehub.devcloud.cn-north-4.huaweicloud.com/hwxz-rjkfjcnlxl-QV_Orangii00001/CityBattle.git
		my_tank = new JLabel(origin_my_tank_up);
		my_tank.setBounds(myTank.tank_x * ELEMENT_SIZE, myTank.tank_y * ELEMENT_SIZE, ELEMENT_SIZE * 3,
				ELEMENT_SIZE * 3);
		contentPane.add(my_tank);
		contentPane.updateUI();
	}

	/**
	 * 该方法用于绘制己方坦克
	 */
	public void drawMyTank() {
		switch (myTank.direction) {
		case UP:
			my_tank.setIcon(origin_my_tank_up);
			my_tank.setBounds(myTank.tank_x * ELEMENT_SIZE, myTank.tank_y * ELEMENT_SIZE, ELEMENT_SIZE * 3,
					ELEMENT_SIZE * 3);
			contentPane.updateUI();
			break;
		case DOWN:
			my_tank.setIcon(origin_my_tank_down);
			my_tank.setBounds(myTank.tank_x * ELEMENT_SIZE, myTank.tank_y * ELEMENT_SIZE, ELEMENT_SIZE * 3,
					ELEMENT_SIZE * 3);
			contentPane.updateUI();

			break;
		case LEFT:
			my_tank.setIcon(origin_my_tank_left);
			my_tank.setBounds(myTank.tank_x * ELEMENT_SIZE, myTank.tank_y * ELEMENT_SIZE, ELEMENT_SIZE * 3,
					ELEMENT_SIZE * 3);
			contentPane.updateUI();
			break;
		case RIGHT:
			my_tank.setIcon(origin_my_tank_right);
			my_tank.setBounds(myTank.tank_x * ELEMENT_SIZE, myTank.tank_y * ELEMENT_SIZE, ELEMENT_SIZE * 3,
					ELEMENT_SIZE * 3);
			contentPane.updateUI();
			// my_tank_right.setVisible(false);
			break;
		default:
			return;
		}
	}

	/**
	 * 该方法用于绘制AI坦克
	 */
	public void drawAITanks() {
		for (AiTank ai : AiTankArray.aiTank) {
			switch (ai.HP) {
			case 1:
				if (ai.direction == UP) {
					ai.j.setIcon(origin_first_tank_up);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == DOWN) {
					ai.j.setIcon(origin_first_tank_down);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == LEFT) {
					ai.j.setIcon(origin_first_tank_left);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == RIGHT) {
					ai.j.setIcon(origin_first_tank_right);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				}
				break;
			case 2:
				if (ai.direction == UP) {
					ai.j.setIcon(origin_second_tank_up);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == DOWN) {
					ai.j.setIcon(origin_second_tank_down);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == LEFT) {
					ai.j.setIcon(origin_second_tank_left);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == RIGHT) {
					ai.j.setIcon(origin_second_tank_right);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				}
				break;
			case 3:
				if (ai.direction == UP) {
					ai.j.setIcon(origin_third_tank_up);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == DOWN) {
					ai.j.setIcon(origin_third_tank_down);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == LEFT) {
					ai.j.setIcon(origin_third_tank_left);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				} else if (ai.direction == RIGHT) {
					ai.j.setIcon(origin_third_tank_right);
					ai.j.setBounds(ai.getTank_x() * ELEMENT_SIZE, ai.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
							ELEMENT_SIZE * 3);
					contentPane.updateUI();
				}
				break;
			}
		}
	}

	/**
	 * 调用该方法可以绘制所有坦克
	 */
	public void drawTanks() {
		drawAITanks();
		drawMyTank();
	}
}
