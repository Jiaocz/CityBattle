package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import edu.nwpu.citybattle.IngameElements.Bullet;

/**
 * 用于绘制子弹
 * @author 微笑未失
 *
 */
public class BulletsPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private int ELEMENT_SIZE;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	BufferedImage img_bullet_up;//子弹向上
	BufferedImage img_bullet_down;//子弹向下
	BufferedImage img_bullet_left;//子弹向左
	BufferedImage img_bullet_right;//子弹向右
	
	/**
	 * 用于确定图片尺寸
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
	 * 用于加载位图
	 * @throws IOException
	 */
	public void loadBmp() throws IOException{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//从/res/imgs目录，加载所有原始照片（未拉伸）
		BufferedImage origin_bullet_up = ImageIO.read(ShapPainter.class.getResource("/imgs/bullet_up.png"));
		BufferedImage origin_bullet_down = ImageIO.read(ShapPainter.class.getResource("/imgs/bullet_down.png"));
		BufferedImage origin_bullet_left = ImageIO.read(ShapPainter.class.getResource("/imgs/bullet_left.png"));
		BufferedImage origin_bullet_right = ImageIO.read(ShapPainter.class.getResource("/imgs/bullet_right.png"));		
		//按窗口宽、高比例，计算出最终使用的宽高缩放比例
		//计算窗口背景图宽高比例
		
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = ELEMENT_SIZE / (float)origin_bullet_up.getWidth();
		float scaleY = ELEMENT_SIZE / (float)origin_bullet_up.getHeight();
		
		//拉伸各个颜色的小格子图片
		img_bullet_up = createScaledImg(origin_bullet_up, scaleX, scaleY*2);
		img_bullet_down = createScaledImg(origin_bullet_down, scaleX, scaleY*2);
		img_bullet_left = createScaledImg(origin_bullet_left, scaleX*2, scaleY);
		img_bullet_right = createScaledImg(origin_bullet_right, scaleX*2, scaleY);
	}
	/**
	 * 用于压缩图片
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return 返回一个压缩后的图片
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
	 * 用于绘制子弹
	 * @param g2d
	 */
	public void drawBullets(Graphics2D g2d) {
		for(Bullet bullet:Bullet.Bullets) {
			switch(bullet.direction) {
				case UP:
					g2d.drawImage(img_bullet_up, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, null);
					break;
				case DOWN:
					g2d.drawImage(img_bullet_down, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, null);
					break;
				case LEFT:
					g2d.drawImage(img_bullet_left, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, null);
					break;
				case RIGHT:
					g2d.drawImage(img_bullet_right, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, null);
					break;
			}
		}
	}
}
