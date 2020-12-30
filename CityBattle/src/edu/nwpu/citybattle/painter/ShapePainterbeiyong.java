package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.TankMap.Map;

public class ShapePainterbeiyong {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private static int ELEMENT_SIZE;

	JPanel contentPane;
	
	JLabel background;
	JLabel wall;
	JLabel water;
	JLabel ironWall;
	JLabel grass;
	ImageIcon origin_background;
	ImageIcon origin_wall;
	ImageIcon origin_iron_wall;
	ImageIcon origin_water;
	ImageIcon origin_grass;
	
	public ShapePainterbeiyong(JPanel contentPane) {
		this.contentPane = contentPane;
		initialPainter();
		loadImg();
		drawAllShape();
	}
	
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
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
	}
	public void drawWall() {//缁樺埗澧欏浘
		for(int x = 0;x < Map.wall.length;x++) {
			for(int y = 0;y < Map.wall[x].length;y++) {
				if(Map.wall[x][y] == 1) {
					wall = new JLabel(origin_wall);
					wall.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(wall);
				}
			}
		}
	}
	public void drawBackground() {
		background = new JLabel(origin_background);
		background.setBounds(0, 0, 800, 600);
		contentPane.add(background);
	}
	public void drawGrass() {//缁樺埗鑽夊湴
		for(int x = 0;x < Map.grass.length;x++) {
			for(int y = 0;y < Map.grass[x].length;y++) {
				if(Map.grass[x][y] == 1) {
					grass = new JLabel(origin_grass);
					grass.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(grass);
				}
			}
		}
	}
	public void drawWater() {//缁樺埗澧欏浘
		for(int x = 0;x < Map.water.length;x++) {
			for(int y = 0;y < Map.water[x].length;y++) {
				if(Map.water[x][y] == 1) {
					water = new JLabel(origin_water);
					water.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(water);
				}
			}
		}
	}
	public void drawIronWall() {//缁樺埗閾佸
		for(int x = 0;x < Map.ironwall.length;x++) {
			for(int y = 0;y < Map.ironwall[x].length;y++) {
				if(Map.ironwall[x][y] == 1) {
					ironWall = new JLabel(origin_iron_wall);
					ironWall.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(ironWall);
				}
			}
		}
	}
	public void drawAllShape() {
		drawWall();
		drawIronWall();
		drawWater();
		drawGrass();
		//drawBackground();
	
	}
}
