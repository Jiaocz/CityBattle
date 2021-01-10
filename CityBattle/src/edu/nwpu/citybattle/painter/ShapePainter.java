package edu.nwpu.citybattle.painter;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.TankMap.Map;

/**
 * 该类用于绘制各种墙体
 * 
 * @author 微笑未失
 * @see initialPainter
 * @see loadImg
 * @see drawWall
 * @see drawBackground
 */
public class ShapePainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
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
	ImageIcon origin_home;

	public ShapePainter(JPanel contentPane) {
		this.contentPane = contentPane;
		initialPainter();
		loadImg();
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
		origin_home = new ImageIcon("img\\home.png");
		origin_home.setImage(origin_home.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		addJLabel = new JLabel(origin_home);
		addJLabel.setBounds(27 * ELEMENT_SIZE, 36 * ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
//		addJLabel.setIcon((Icon) ((Image) addJLabel.getIcon()).getScaledInstance(45, 45, 0));
		contentPane.add(addJLabel);

		for (int x = 0; x < Map.wall.length; x++) {
			for (int y = 0; y < Map.wall[x].length; y++) {
				if (Map.wall[x][y] == 1) {
					addJLabel = new JLabel(origin_wall);
					addJLabel.setBounds(x * ELEMENT_SIZE, y * ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					wall.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for (int x = 0; x < Map.ironwall.length; x++) {
			for (int y = 0; y < Map.ironwall[x].length; y++) {
				if (Map.ironwall[x][y] == 1) {
					addJLabel = new JLabel(origin_iron_wall);
					addJLabel.setBounds(x * ELEMENT_SIZE, y * ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					ironWall.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for (int x = 0; x < Map.water.length; x++) {
			for (int y = 0; y < Map.water[x].length; y++) {
				if (Map.water[x][y] == 1) {
					addJLabel = new JLabel(origin_water);
					addJLabel.setBounds(x * ELEMENT_SIZE, y * ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					water.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}
		for (int x = 0; x < Map.grass.length; x++) {
			for (int y = 0; y < Map.grass[x].length; y++) {
				if (Map.grass[x][y] == 1) {
					addJLabel = new JLabel(origin_grass);
					addJLabel.setBounds(x * ELEMENT_SIZE, y * ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					grass.add(addJLabel);
					contentPane.add(addJLabel);
				}
			}
		}

	}

	/**
	 * 该方法用于根据可销毁墙的位置改变重新绘制
	 */
	public void drawWall() {
		Iterator<JLabel> iterator = wall.iterator();
		while (iterator.hasNext()) {
			JLabel j = iterator.next();
			if (Map.wall[j.getX() / ELEMENT_SIZE][j.getY() / ELEMENT_SIZE] == 0) {
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
	 * 该方法用于绘制背景图
	 */
	public void drawBackground() {
		background = new JLabel(origin_background);
		background.setBounds(0, 0, 800, 600);
		contentPane.add(background);
	}
}
