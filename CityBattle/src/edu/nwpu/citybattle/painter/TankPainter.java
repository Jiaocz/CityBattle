package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.AiTankArray;
import edu.nwpu.citybattle.IngameElements.MyTank;

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
	
	static JLabel my_tank_up;
	static JLabel my_tank_down;
	static JLabel my_tank_left;
	static JLabel my_tank_right;
	static JLabel first_tank_up;
	static JLabel first_tank_down;
	static JLabel first_tank_left;
	static JLabel first_tank_right;
	JLabel second_tank_up;
	JLabel second_tank_down;
	JLabel second_tank_left;
	JLabel second_tank_right;
	JLabel third_tank_up;
	JLabel third_tank_down;
	JLabel third_tank_left;
	JLabel third_tank_right;
	
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
	
	public TankPainter(JPanel contentPane,MyTank mytank) {
		this.myTank = mytank;
		this.contentPane = contentPane;
		this.initialPainter();
		this.loadImg();
		this.drawTanks();
	}
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	public void loadImg() {
		origin_my_tank_up = new ImageIcon("img\\mytank_up.gif");
		origin_my_tank_up.setImage(origin_my_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_my_tank_down = new ImageIcon("img\\mytank_down.gif");
		origin_my_tank_down.setImage(origin_my_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_my_tank_left = new ImageIcon("img\\mytank_left.gif");
		origin_my_tank_left.setImage(origin_my_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_my_tank_right = new ImageIcon("img\\mytank_right.gif");
		origin_my_tank_right.setImage(origin_my_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		
		origin_first_tank_up = new ImageIcon("img\\enemy1_up.png");
		origin_first_tank_up.setImage(origin_first_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_first_tank_down = new ImageIcon("img\\enemy1_down.png");
		origin_first_tank_down.setImage(origin_first_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_first_tank_left = new ImageIcon("img\\enemy1_left.png");
		origin_first_tank_left.setImage(origin_first_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_first_tank_right = new ImageIcon("img\\enemy1_right.png");
		origin_first_tank_right.setImage(origin_first_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		
		origin_second_tank_up = new ImageIcon("img\\enemy2_up.png");
		origin_second_tank_up.setImage(origin_second_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_second_tank_down = new ImageIcon("img\\enemy2_down.png");
		origin_second_tank_down.setImage(origin_second_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_second_tank_left = new ImageIcon("img\\enemy2_left.png");
		origin_second_tank_left.setImage(origin_second_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_second_tank_right = new ImageIcon("img\\enemy2_right.png");
		origin_second_tank_right.setImage(origin_second_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		
		origin_third_tank_up = new ImageIcon("img\\enemy3_up.png");
		origin_third_tank_up.setImage(origin_third_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_third_tank_down = new ImageIcon("img\\enemy3_down.png");
		origin_third_tank_down.setImage(origin_third_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_third_tank_left = new ImageIcon("img\\enemy3_left.png");
		origin_third_tank_left.setImage(origin_third_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_third_tank_right = new ImageIcon("img\\enemy3_right.png");
		origin_third_tank_right.setImage(origin_third_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
	}
	public void drawMyTank() {
		switch(myTank.direction) {
			case UP:
				my_tank_up = new JLabel(origin_my_tank_up);
				my_tank_up.setBounds(myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
				contentPane.add(my_tank_up);
				break;
			case DOWN:
				my_tank_down = new JLabel(origin_my_tank_down);
				my_tank_down.setBounds(myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
				contentPane.add(my_tank_down);
				break;
			case LEFT:
				my_tank_left = new JLabel(origin_my_tank_left);
				my_tank_left.setBounds(myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
				contentPane.add(my_tank_left);
				break;
			case RIGHT:
				my_tank_right = new JLabel(origin_my_tank_right);
				my_tank_right.setBounds(myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
				contentPane.add(my_tank_right);
				break;
			default :
				return;
		}
	}
	public void drawAITanks() {
		for(AiTank ai:AiTankArray.aiTank) {
			switch(ai.direction) {
				case 1://��һ��̹��
					if(ai.direction == UP) {
						first_tank_up = new JLabel(origin_first_tank_up);
						first_tank_up.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_up);
					}else if(ai.direction == DOWN) {
						first_tank_down = new JLabel(origin_first_tank_down);
						first_tank_down.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_down);
					}else if(ai.direction == LEFT) {
						first_tank_left = new JLabel(origin_first_tank_left);
						first_tank_left.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_left);
					}else if(ai.direction == RIGHT) {
						first_tank_right = new JLabel(origin_first_tank_right);
						first_tank_right.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_right);
					}
					break;
				case 2:
					if(ai.direction == UP) {
						second_tank_up = new JLabel(origin_second_tank_up);
						second_tank_up.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_up);
					}else if(ai.direction == DOWN) {
						second_tank_down = new JLabel(origin_second_tank_down);
						second_tank_down.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_down);
					}else if(ai.direction == LEFT) {
						second_tank_left = new JLabel(origin_second_tank_left);
						second_tank_left.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_left);
					}else if(ai.direction == RIGHT) {
						second_tank_right = new JLabel(origin_second_tank_right);
						second_tank_right.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_right);
					}
					break;
				case 3:
					if(ai.direction == UP) {
						third_tank_up = new JLabel(origin_third_tank_up);
						third_tank_up.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_up);
					}else if(ai.direction == DOWN) {
						third_tank_down = new JLabel(origin_third_tank_down);
						third_tank_down.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_down);
					}else if(ai.direction == LEFT) {
						third_tank_left = new JLabel(origin_third_tank_left);
						third_tank_left.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_left);
					}else if(ai.direction == RIGHT) {
						third_tank_right = new JLabel(origin_third_tank_right);
						third_tank_right.setBounds(ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 5, ELEMENT_SIZE * 5);
						contentPane.add(my_tank_right);
					}
					break;
			}
		}
	}
	public void drawTanks() {
		drawAITanks();
		drawMyTank();
	}
}
