package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import UI.CustomsPass;
import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.AiTankArray;
import edu.nwpu.citybattle.IngameElements.MyTank;


/**
 * 这个类用于绘制己方和敌方坦克
 * @author 微笑未失
 * @see initialPainter
 * @see loadBmp
 * @see createScaledImg
 */
public class TankPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private int ELEMENT_SIZE;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	MyTank myTank;
	private CustomsPass custompass;

	BufferedImage img_my_tank_up;//己方坦克向上
	BufferedImage img_my_tank_down;//己方坦克向下
	BufferedImage img_my_tank_left;//己方坦克向左
	BufferedImage img_my_tank_right;//己方坦克向右
	
	BufferedImage img_first_tank_up;//第一类坦克向上
	BufferedImage img_first_tank_down;//第一类坦克向下
	BufferedImage img_first_tank_left;//第一类坦克向左
	BufferedImage img_first_tank_right;//第一类坦克向右
	
	BufferedImage img_second_tank_up;//第二类坦克向上
	BufferedImage img_second_tank_down;//第二类坦克向下
	BufferedImage img_second_tank_left;//第二类坦克向左
	BufferedImage img_second_tank_right;//第二类坦克向右
	
	BufferedImage img_third_tank_up;//第三类坦克向上
	BufferedImage img_third_tank_down;//第三类坦克向下
	BufferedImage img_third_tank_left;//第三类坦克向左
	BufferedImage img_third_tank_right;//第三类坦克向右
	
	public TankPainter(CustomsPass custompass) {
		this.custompass = custompass;
	}
	/**
	 * 用于确定图片尺寸，加载位图
	 */
	public void initialPainter()
	{
		//先确定界面需要的各种尺寸
		int size1 =	WINDOW_WIDTH / (TABLE_WIDTH + 1);
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
	 * 用于加载位图
	 * @throws IOException
	 */
	public void loadBmp() throws IOException
	{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//从/res/imgs目录，加载所有原始照片（未拉伸）
		BufferedImage origin_my_tank_up = ImageIO.read(ShapePainter.class.getResource("/imgs/my_tank_up.png"));
		BufferedImage origin_my_tank_down = ImageIO.read(ShapePainter.class.getResource("/imgs/my_tank_down.png"));
		BufferedImage origin_my_tank_left = ImageIO.read(ShapePainter.class.getResource("/imgs/my_tank_left.png"));
		BufferedImage origin_my_tank_right = ImageIO.read(ShapePainter.class.getResource("/imgs/my_tank_right.png"));
		
		BufferedImage origin_first_tank_up = ImageIO.read(ShapePainter.class.getResource("/imgs/first_tank_up.png"));
		BufferedImage origin_first_tank_down = ImageIO.read(ShapePainter.class.getResource("/imgs/first_tank_down.png"));
		BufferedImage origin_first_tank_left = ImageIO.read(ShapePainter.class.getResource("/imgs/first_tank_left.png"));
		BufferedImage origin_first_tank_right = ImageIO.read(ShapePainter.class.getResource("/imgs/first_tank_right.png"));
		
		BufferedImage origin_second_tank_up = ImageIO.read(ShapePainter.class.getResource("/imgs/second_tank_up.png"));
		BufferedImage origin_second_tank_down = ImageIO.read(ShapePainter.class.getResource("/imgs/second_tank_down.png"));
		BufferedImage origin_second_tank_left = ImageIO.read(ShapePainter.class.getResource("/imgs/second_tank_left.png"));
		BufferedImage origin_second_tank_right = ImageIO.read(ShapePainter.class.getResource("/imgs/second_tank_right.png"));
		
		BufferedImage origin_third_tank_up = ImageIO.read(ShapePainter.class.getResource("/imgs/third_tank_up.png"));
		BufferedImage origin_third_tank_down = ImageIO.read(ShapePainter.class.getResource("/imgs/third_tank_down.png"));
		BufferedImage origin_third_tank_left = ImageIO.read(ShapePainter.class.getResource("/imgs/third_tank_left.png"));
		BufferedImage origin_third_tank_right = ImageIO.read(ShapePainter.class.getResource("/imgs/third_tank_right.png"));
		//按窗口宽、高比例，计算出最终使用的宽高缩放比例
		//计算窗口背景图宽高比例
		float scaleX = ELEMENT_SIZE / (float)origin_my_tank_up.getWidth();
		float scaleY = ELEMENT_SIZE / (float)origin_my_tank_up.getHeight();
		//创建拉伸后的背景图片
		img_my_tank_up = createScaledImg(origin_my_tank_up,5 * scaleX,5 * scaleY);
		img_my_tank_down = createScaledImg(origin_my_tank_down,5 * scaleX,5 * scaleY);
		img_my_tank_left = createScaledImg(origin_my_tank_left,5 * scaleX,5 * scaleY);
		img_my_tank_right = createScaledImg(origin_my_tank_right,5 * scaleX,5 * scaleY);
		
		img_first_tank_up = createScaledImg(origin_first_tank_up,5 * scaleX,5 * scaleY);
		img_first_tank_down = createScaledImg(origin_first_tank_down,5 * scaleX,5 * scaleY);
		img_first_tank_left = createScaledImg(origin_first_tank_left,5 * scaleX,5 * scaleY);
		img_first_tank_right = createScaledImg(origin_first_tank_right,5 * scaleX,5 * scaleY);
		
		img_second_tank_up = createScaledImg(origin_second_tank_up,5 * scaleX,5 * scaleY);
		img_second_tank_down = createScaledImg(origin_second_tank_down,5 * scaleX,5 * scaleY);
		img_second_tank_left = createScaledImg(origin_second_tank_left,5 * scaleX,5 * scaleY);
		img_second_tank_right = createScaledImg(origin_second_tank_right,5 * scaleX,5 * scaleY);
		
		img_third_tank_up = createScaledImg(origin_third_tank_up,5 * scaleX,5 * scaleY);
		img_third_tank_down = createScaledImg(origin_third_tank_down,5 * scaleX,5 * scaleY);
		img_third_tank_left = createScaledImg(origin_third_tank_left,5 * scaleX,5 * scaleY);
		img_third_tank_right = createScaledImg(origin_third_tank_right,5 * scaleX,5 * scaleY);
	}
	/**
	 * 用于放缩图片
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return 返回放缩后的图片
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		return newImage;
	}
	/**
	 * 用于绘制己方坦克
	 * @param g2d
	 * @param myTank
	 */
	public void drawMyTank(Graphics g2d,MyTank myTank) {
		switch(myTank.direction) {
			case UP:
				g2d.drawImage(img_my_tank_up, myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, custompass);
				break;
			case DOWN:
				g2d.drawImage(img_my_tank_down, myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, custompass);
				break;
			case LEFT:
				g2d.drawImage(img_my_tank_left, myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, custompass);
				break;
			case RIGHT:
				g2d.drawImage(img_my_tank_right, myTank.tank_x*ELEMENT_SIZE, myTank.tank_y*ELEMENT_SIZE, custompass);
				break;
			default :
				return;
		}
		
	}
	/**
	 * 用于绘制AI坦克
	 * @param g2d
	 */
	public void drawAITanks(Graphics g2d) {
		for(AiTank ai:AiTankArray.aiTank) {
			switch(ai.direction) {
				case 1://第一类坦克
					if(ai.direction == UP) {
						g2d.drawImage(img_first_tank_up, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == DOWN) {
						g2d.drawImage(img_first_tank_down, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == LEFT) {
						g2d.drawImage(img_first_tank_left, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == RIGHT) {
						g2d.drawImage(img_first_tank_right, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}
					break;
				case 2:
					if(ai.direction == UP) {
						g2d.drawImage(img_second_tank_up, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == DOWN) {
						g2d.drawImage(img_second_tank_down, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == LEFT) {
						g2d.drawImage(img_second_tank_left, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == RIGHT) {
						g2d.drawImage(img_second_tank_right, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}
					break;
				case 3:
					if(ai.direction == UP) {
						g2d.drawImage(img_third_tank_up, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == DOWN) {
						g2d.drawImage(img_third_tank_down, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == LEFT) {
						g2d.drawImage(img_third_tank_left, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}else if(ai.direction == RIGHT) {
						g2d.drawImage(img_third_tank_right, ai.getTank_x()*ELEMENT_SIZE, ai.getTank_y()*ELEMENT_SIZE, custompass);
					}
					break;
			}
		}
	}
	
	/**
	 * 此方法用于绘制所有坦克
	 * @param g2d
	 */
	public void drawTanks(Graphics g2d) {
		drawAITanks(g2d);
		drawMyTank(g2d,myTank);
	}
}
