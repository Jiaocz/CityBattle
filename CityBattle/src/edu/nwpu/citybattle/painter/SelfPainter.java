package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.SelfConfigFrame;
import edu.nwpu.citybattle.TankMap.MapSelf;
/**
 * 该类用于绘制各种墙体
 * @author 微笑未失
 * @see initialPainter
 * @see loadImg
 * @see drawWall
 * @see drawBackground
 */
public class SelfPainter {
	public static final int WINDOW_WIDTH = 590;
	public static final int WINDOW_HEIGHT = 840;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private static int ELEMENT_SIZE;

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
	
	public SelfPainter() {
		initialPainter();
		loadImg();
	}
	/**
	 * 该方法用于初始化绘制大小
	 */
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	/**
	 * 该方法用于导入图片
	 */
	public void loadImg() {
		origin_background = new ImageIcon("img\\background.png");
		origin_background.setImage(origin_background.getImage().getScaledInstance(800, 600, 0));
		origin_wall = new ImageIcon("img\\wall.jpg");
		origin_wall.setImage(origin_wall.getImage().getScaledInstance(ELEMENT_SIZE * 5, ELEMENT_SIZE * 5, 0));
		origin_iron_wall = new ImageIcon("img\\ironwall.jpg");
		origin_iron_wall.setImage(origin_iron_wall.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE, 0));
		origin_grass = new ImageIcon("img\\grass.png");
		origin_grass.setImage(origin_grass.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE, 0));
		origin_water = new ImageIcon("img\\water.jpg");
		origin_water.setImage(origin_water.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE, 0));
		
		for(int x = 0;x < MapSelf.wall.length;x++) {
			for(int y = 0;y < MapSelf.wall[x].length;y++) {
				if(MapSelf.wall[x][y] == 1) {
					addJLabel = new JLabel(origin_wall);
					addJLabel.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					wall.add(addJLabel);
					SelfConfigFrame.contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < MapSelf.ironwall.length;x++) {
			for(int y = 0;y < MapSelf.ironwall[x].length;y++) {
				if(MapSelf.ironwall[x][y] == 1) {
					addJLabel = new JLabel(origin_iron_wall);
					addJLabel.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					ironWall.add(addJLabel);
					SelfConfigFrame.contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < MapSelf.water.length;x++) {
			for(int y = 0;y < MapSelf.water[x].length;y++) {
				if(MapSelf.water[x][y] == 1) {
					addJLabel = new JLabel(origin_water);
					addJLabel.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					water.add(addJLabel);
					SelfConfigFrame.contentPane.add(addJLabel);
				}
			}
		}
		for(int x = 0;x < MapSelf.grass.length;x++) {
			for(int y = 0;y < MapSelf.grass[x].length;y++) {
				if(MapSelf.grass[x][y] == 1) {
					addJLabel = new JLabel(origin_grass);
					addJLabel.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					grass.add(addJLabel);
					SelfConfigFrame.contentPane.add(addJLabel);
				}
			}
		}
	}
	public void drawWall() {
			for(int i = 0;i < MapSelf.wall.length;i++) {
				for(int j = 0;j < MapSelf.wall[i].length;j++) {
					if(MapSelf.wall[i][j] == 1) {
						addJLabel = new JLabel(origin_wall);
						addJLabel.setBounds(i*ELEMENT_SIZE, j*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
						wall.add(addJLabel);
						SelfConfigFrame.contentPane.add(addJLabel);
					}
				}
			}
	}
	public void drawIronWall() {
		Iterator<JLabel> iterator = ironWall.iterator();
		while(iterator.hasNext()) {
			JLabel j = iterator.next();
				SelfConfigFrame.contentPane.remove(j);
				SelfConfigFrame.contentPane.updateUI();
				iterator.remove();
			}
			for(int i = 0;i < MapSelf.ironwall.length;i++) {
				for(int j1 = 0;j1 < MapSelf.ironwall[i].length;j1++) {
					if(MapSelf.ironwall[i][j1] == 1) {
						addJLabel = new JLabel(origin_iron_wall);
						addJLabel.setBounds(i*ELEMENT_SIZE, j1*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
						ironWall.add(addJLabel);
						SelfConfigFrame.contentPane.add(addJLabel);
					}
				}
			}
	}
//	public void drawWall() {
//		Iterator<JLabel> iterator = wall.iterator();
//		while(iterator.hasNext()) {
//			JLabel j = iterator.next();
//			if(Map.wall[j.getX()/ELEMENT_SIZE][j.getY()/ELEMENT_SIZE] == 0) {
//				contentPane.remove(j);
//				contentPane.updateUI();
//				iterator.remove();
//			}
//		}
//		for(JLabel j:wall) {
//			if(Map.wall[j.getX()/ELEMENT_SIZE][j.getY()/ELEMENT_SIZE] == 0) {
//				contentPane.remove(j);
//				wall.remove(j);
//			}
//		}
	/**
	 * 该方法用于绘制背景图
	 */
//	public void drawBackground() {
//		background = new JLabel(origin_background);
//		background.setBounds(0, 0, 800, 600);
//		contentPane.add(background);
//	}
}
