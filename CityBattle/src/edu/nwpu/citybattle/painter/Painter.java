package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.IngameElements.Bullet;

public class Painter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private static int  ELEMENT_SIZE;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	JPanel contentPane;
	
	JLabel bullets;
	ArrayList<JLabel> bullet = new ArrayList<JLabel>();
	
	ImageIcon origin_bullet_up;
	ImageIcon origin_bullet_down;
	ImageIcon origin_bullet_left;
	ImageIcon origin_bullet_right;
	
	public Painter(JPanel contentPane) {
		this.contentPane = contentPane;
		this.initialPainter();
		this.drawBullets();
	}
	
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	public void drawBullets() {
		for(Bullet bullet:Bullet.Bullets) {
			switch(bullet.direction) {
			case UP:
				bullet.j.setBounds(bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE * 2);
				break;
			case DOWN:
				bullet.j.setBounds(bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, ELEMENT_SIZE , ELEMENT_SIZE * 2);
				break;
			case LEFT:
				bullet.j.setBounds(bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, ELEMENT_SIZE * 2, ELEMENT_SIZE );
				break;
			case RIGHT:
				bullet.j.setBounds(bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, ELEMENT_SIZE* 2 , ELEMENT_SIZE);
				break;
			default :
				return;
			}
		}
	}
	
}
