package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import edu.nwpu.map.Map;

/**
 * 该类用于绘制墙类
 * @author 微笑未失
 * @see initialPainter
 * @see loadBmp
 * @see createScaledImg
 * @see drawBackground
 * @see drawWall
 * @see drawIronWall
 * @see drawGrass
 * @see drawWater
 * @see drawShape
 */
public class ShapPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private int ELEMENT_SIZE;
	public static final int WALL = 0;
	public static final int IRON_WALL = 1;
	public static final int GRASS = 2;
	public static final int WATER = 3;
	
	BufferedImage img_background;//背景图
	BufferedImage img_wall;//普通墙
	BufferedImage img_iron_wall;//铁墙
	BufferedImage img_grass;//草坪
	BufferedImage img_water;//水
	
	/**
	 * 这是构造，创建该类对象时，你需要对mainPanel和map进行初始化
	 * @param mainPanel
	 * @param map
	 */
	/**
	 * 这个方法用于初始化各种大小
	 */
	public void initialPainter()
	{
		//先确定界面需要的各种尺寸
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 

		//再加载位图文件
		try {
			loadBmp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 这个方法用于加载图片并进行放缩
	 * @throws IOException
	 */
	public void loadBmp() throws IOException
	{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//从/res/imgs目录，加载所有原始照片（未拉伸）
		BufferedImage origin_background = ImageIO.read(ShapPainter.class.getResource("/imgs/background.png"));
		BufferedImage origin_wall = ImageIO.read(ShapPainter.class.getResource("/imgs/wall.png"));
		BufferedImage origin_iron_wall = ImageIO.read(ShapPainter.class.getResource("/imgs/iron.png"));
		BufferedImage origin_grass = ImageIO.read(ShapPainter.class.getResource("/imgs/grass.png"));
		BufferedImage origin_water = ImageIO.read(ShapPainter.class.getResource("/imgs/water.png"));		
		//按窗口宽、高比例，计算出最终使用的宽高缩放比例
		//计算窗口背景图宽高比例
		float scaleX = WINDOW_WIDTH / (float)origin_background.getWidth();
		float scaleY = WINDOW_HEIGHT / (float)origin_background.getHeight();
		//创建拉伸后的背景图片
		img_background = createScaledImg(origin_background, scaleX, scaleY);
		
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		scaleX = ELEMENT_SIZE / (float)origin_wall.getWidth();
		scaleY = ELEMENT_SIZE / (float)origin_wall.getHeight();
		
		//拉伸各个颜色的小格子图片
		img_grass = createScaledImg(origin_grass, scaleX, scaleY);
        img_wall = createScaledImg(origin_wall, scaleX, scaleY);
        img_iron_wall = createScaledImg(origin_iron_wall, scaleX, scaleY);
        img_water = createScaledImg(origin_water, scaleX, scaleY);
	}
	/**
	 * 内部方法，用于放缩图片
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return 返回放缩后的图片
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		Graphics g = newImage.getGraphics();
		g.drawImage(originImg, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return newImage;
	}
	/**
	 * 这个方法用于画背景图
	 * @param g2d
	 */
	public void drawBackground(Graphics2D g2d){
		g2d.drawImage(img_background, 0, 0, null);//贴背景图
	}
	public void drawWall(Graphics2D g2d) {//绘制墙图
		for(int x = 0;x < Map.wall.length;x++) {
			for(int y = 0;y < Map.wall[x].length;y++) {
				if(Map.wall[x][y] == 1)
				drawShape(g2d,x,y,WALL);
			}
		}
	}
	/**
	 * 这个方法用于画铁墙
	 * @param g2d
	 */
	public void drawIronWall(Graphics2D g2d) {//绘制铁墙
		for(int x = 0;x < Map.ironWall.length;x++) {
			for(int y = 0;y < Map.ironWall[x].length;y++) {
				if(Map.ironWall[x][y] == 1)
				drawShape(g2d,x,y,IRON_WALL);
			}
		}
	}
	/**
	 * 这个方法用于绘制草地
	 * @param g2d
	 */
	public void drawGrass(Graphics2D g2d) {//绘制草地
		for(int x = 0;x < Map.grass.length;x++) {
			for(int y = 0;y < Map.grass[x].length;y++) {
				if(Map.grass[x][y] == 1)
				drawShape(g2d,x,y,GRASS);
			}
		}
	}
	/**
	 * 这个方法用于绘制墙
	 * @param g2d
	 */
	public void drawWater(Graphics2D g2d) {//绘制墙图
		for(int x = 0;x < Map.water.length;x++) {
			for(int y = 0;y < Map.water[x].length;y++) {
				if(Map.water[x][y] == 1)
				drawShape(g2d,x,y,WATER);
			}
		}
	}
	/**
	 * 这个方法用于判读需要绘制的图形类型，并将其绘制出来
	 * @param g2d
	 * @param x
	 * @param y
	 * @param blockType
	 */
	public void drawShape(Graphics2D g2d, int x, int y, int blockType)
	{
		switch(blockType)
		{
		case WALL:
			g2d.drawImage(img_wall, x*ELEMENT_SIZE, y*ELEMENT_SIZE, null);
			break;
		case IRON_WALL:
			g2d.drawImage(img_iron_wall, x*ELEMENT_SIZE, y*ELEMENT_SIZE, null);
			break;
		case GRASS:
			g2d.drawImage(img_grass, x*ELEMENT_SIZE, y*ELEMENT_SIZE, null);
			break;
		case WATER:
			g2d.drawImage(img_water, x*ELEMENT_SIZE, y*ELEMENT_SIZE, null);
			break;
		default:
			break;
		}
	}
	public void drawAllShap(Graphics2D g2d) {
		drawBackground(g2d);
		drawWall(g2d);
		drawIronWall(g2d);
		drawWater(g2d);
		drawGrass(g2d);
	}
}