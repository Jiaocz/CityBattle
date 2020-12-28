package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import UI.CustomsPass;
import edu.nwpu.citybattle.IngameElements.Bullet;

/**
 * 鐢ㄤ簬缁樺埗瀛愬脊
 * @author 寰瑧鏈け
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
	private CustomsPass custompass;

	BufferedImage img_bullet_up;//瀛愬脊鍚戜笂
	BufferedImage img_bullet_down;//瀛愬脊鍚戜笅
	BufferedImage img_bullet_left;//瀛愬脊鍚戝乏
	BufferedImage img_bullet_right;//瀛愬脊鍚戝彸
	public BulletsPainter(CustomsPass custompass) {
		this.custompass = custompass;
	}
	/**
	 * 鐢ㄤ簬纭畾鍥剧墖灏哄
	 */
	public void initialPainter()
	{
		//鍏堢‘瀹氱晫闈㈤渶瑕佺殑鍚勭灏哄
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 

		//鍐嶅姞杞戒綅鍥炬枃浠�
		try {
			loadBmp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 鐢ㄤ簬鍔犺浇浣嶅浘
	 * @throws IOException
	 */
	public void loadBmp() throws IOException{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//浠�/res/imgs鐩綍锛屽姞杞芥墍鏈夊師濮嬬収鐗囷紙鏈媺浼革級
		BufferedImage origin_bullet_up = ImageIO.read(ShapePainter.class.getResource("/imgs/bullet_up.png"));
		BufferedImage origin_bullet_down = ImageIO.read(ShapePainter.class.getResource("/imgs/bullet_down.png"));
		BufferedImage origin_bullet_left = ImageIO.read(ShapePainter.class.getResource("/imgs/bullet_left.png"));
		BufferedImage origin_bullet_right = ImageIO.read(ShapePainter.class.getResource("/imgs/bullet_right.png"));		
		//鎸夌獥鍙ｅ銆侀珮姣斾緥锛岃绠楀嚭鏈�缁堜娇鐢ㄧ殑瀹介珮缂╂斁姣斾緥
		//璁＄畻绐楀彛鑳屾櫙鍥惧楂樻瘮渚�
		
		//璁＄畻姣忎竴灏忔牸鍥剧墖鐨勬媺浼告瘮渚嬶紙瑕佹眰姣忎竴涓皬鏍煎瓙鍘熷鍥剧墖灏哄瀹屽叏涓�鏍凤紒锛�
		float scaleX = ELEMENT_SIZE / (float)origin_bullet_up.getWidth();
		float scaleY = ELEMENT_SIZE / (float)origin_bullet_up.getHeight();
		
		//鎷変几鍚勪釜棰滆壊鐨勫皬鏍煎瓙鍥剧墖
		img_bullet_up = createScaledImg(origin_bullet_up, scaleX, scaleY*2);
		img_bullet_down = createScaledImg(origin_bullet_down, scaleX, scaleY*2);
		img_bullet_left = createScaledImg(origin_bullet_left, scaleX*2, scaleY);
		img_bullet_right = createScaledImg(origin_bullet_right, scaleX*2, scaleY);
	}
	/**
	 * 鐢ㄤ簬鍘嬬缉鍥剧墖
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return 杩斿洖涓�涓帇缂╁悗鐨勫浘鐗�
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		return newImage;
	}
	/**
	 * 鐢ㄤ簬缁樺埗瀛愬脊
	 * @param g2d
	 */
	public void drawBullets(Graphics g2d) {
		for(Bullet bullet:Bullet.Bullets) {
			switch(bullet.direction) {
				case UP:
					g2d.drawImage(img_bullet_up, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, custompass);
					break;
				case DOWN:
					g2d.drawImage(img_bullet_down, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, custompass);
					break;
				case LEFT:
					g2d.drawImage(img_bullet_left, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, custompass);
					break;
				case RIGHT:
					g2d.drawImage(img_bullet_right, bullet.pos_x*ELEMENT_SIZE, bullet.pos_y*ELEMENT_SIZE, custompass);
					break;
			}
		}
	}
}
