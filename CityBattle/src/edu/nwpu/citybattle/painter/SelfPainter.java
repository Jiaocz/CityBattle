package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.TankMap.Map;
/**
 * �������ڻ��Ƹ���ǽ��
 * @author ΢Цδʧ
 * @see initialPainter
 * @see loadImg
 * @see drawWall
 * @see drawBackground
 */
public class SelfPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;

	JPanel contentPane;
	
	JLabel background;
	JLabel addJLabel;
	ArrayList<JLabel> wall = new ArrayList<JLabel>();
	ArrayList<JLabel> water = new ArrayList<JLabel>();
	ArrayList<JLabel> ironWall = new ArrayList<JLabel>();
	ArrayList<JLabel> grass = new ArrayList<JLabel>();
	
	ImageIcon origin_background;
	ImageIcon origin_wall;
	ImageIcon origin_iron_wall;
	ImageIcon origin_water;
	ImageIcon origin_grass;
	ImageIcon origin_home;
	
	public SelfPainter(JPanel contentPane) {
		this.contentPane = contentPane;
		loadImg();
	}
	/**
	 * �÷������ڳ�ʼ�����ƴ�С
	 */
	/**
	 * �÷������ڵ���ͼƬ
	 */
	public void loadImg() {
		origin_background = new ImageIcon("img\\background.png");
		origin_background.setImage(origin_background.getImage().getScaledInstance(800, 600, 0));
		origin_wall = new ImageIcon("img\\wall.jpg");
		origin_wall.setImage(origin_wall.getImage().getScaledInstance(15*5 , 15 *5, 0));
		origin_iron_wall = new ImageIcon("img\\ironwall.jpg");
		origin_iron_wall.setImage(origin_iron_wall.getImage().getScaledInstance(15, 15, 0));
		origin_grass = new ImageIcon("img\\grass.png");
		origin_grass.setImage(origin_grass.getImage().getScaledInstance(15, 15, 0));
		origin_water = new ImageIcon("img\\water.jpg");
		origin_water.setImage(origin_water.getImage().getScaledInstance(15, 15, 0));
		origin_home = new ImageIcon("img\\home.png");
		origin_home.setImage(origin_home.getImage().getScaledInstance(15*3, 15*3, 0));
		
		addJLabel = new JLabel(origin_home);
		addJLabel.setBounds(27*15 , 36*15, 15*3, 15*3);
//		addJLabel.setIcon((Icon) ((Image) addJLabel.getIcon()).getScaledInstance(45, 45, 0));
		contentPane.add(addJLabel);
		
		for(int x = 0;x < Map.wall.length;x++) {
			for(int y = 0;y < Map.wall[x].length;y++) {
				if(Map.wall[x][y] == 1) {
					addJLabel = new JLabel(origin_wall);
					addJLabel.setBounds(x*15, y*15, 15, 15);
					wall.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < Map.ironwall.length;x++) {
			for(int y = 0;y < Map.ironwall[x].length;y++) {
				if(Map.ironwall[x][y] == 1) {
					addJLabel = new JLabel(origin_iron_wall);
					addJLabel.setBounds(x*15, y*15, 15, 15);
					ironWall.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < Map.water.length;x++) {
			for(int y = 0;y < Map.water[x].length;y++) {
				if(Map.water[x][y] == 1) {
					addJLabel = new JLabel(origin_water);
					addJLabel.setBounds(x*15, y*15, 15, 15);
					water.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < Map.grass.length;x++) {
			for(int y = 0;y < Map.grass[x].length;y++) {
				if(Map.grass[x][y] == 1) {
					addJLabel = new JLabel(origin_grass);
					addJLabel.setBounds(x*15, y*15, 15, 15);
					grass.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}

	}
	/**
	 * �÷������ڸ��ݿ�����ǽ��λ�øı����»���
	 */
	public void drawWall() {
		Iterator<JLabel> iterator = wall.iterator();
		while(iterator.hasNext()) {
			JLabel j = iterator.next();
			if(Map.wall[j.getX()/15][j.getY()/15] == 0) {
				contentPane.remove(j);
				contentPane.updateUI();
				iterator.remove();
			}
		}
//		for(JLabel j:wall) {
//			if(Map.wall[j.getX()/ELEMENT_SIZE][j.getY()/ELEMENT_SIZE] == 0) {
//				contentPane.remove(j);
//				wall.remove(j);
//			}
//		}
	}
	/**
	 * �÷������ڻ��Ʊ���ͼ
	 */
	public void drawBackground() {
		background = new JLabel(origin_background);
		background.setBounds(0, 0, 800, 600);
		contentPane.add(background);
	}
}
