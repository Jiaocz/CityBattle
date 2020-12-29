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
 * ��������ڻ��Ƽ����͵з�̹��
 * @author ΢Цδʧ
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

	BufferedImage img_my_tank_up;//����̹������
	BufferedImage img_my_tank_down;//����̹������
	BufferedImage img_my_tank_left;//����̹������
	BufferedImage img_my_tank_right;//����̹������
	
	BufferedImage img_first_tank_up;//��һ��̹������
	BufferedImage img_first_tank_down;//��һ��̹������
	BufferedImage img_first_tank_left;//��һ��̹������
	BufferedImage img_first_tank_right;//��һ��̹������
	
	BufferedImage img_second_tank_up;//�ڶ���̹������
	BufferedImage img_second_tank_down;//�ڶ���̹������
	BufferedImage img_second_tank_left;//�ڶ���̹������
	BufferedImage img_second_tank_right;//�ڶ���̹������
	
	BufferedImage img_third_tank_up;//������̹������
	BufferedImage img_third_tank_down;//������̹������
	BufferedImage img_third_tank_left;//������̹������
	BufferedImage img_third_tank_right;//������̹������
	
	public TankPainter(CustomsPass custompass) {
		this.custompass = custompass;
	}
	/**
	 * ����ȷ��ͼƬ�ߴ磬����λͼ
	 */
	public void initialPainter()
	{
		//��ȷ��������Ҫ�ĸ��ֳߴ�
		int size1 =	WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 

		//�ټ���λͼ�ļ�
		try {
			loadBmp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ���ڼ���λͼ
	 * @throws IOException
	 */
	public void loadBmp() throws IOException
	{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//��/res/imgsĿ¼����������ԭʼ��Ƭ��δ���죩
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
		//�����ڿ��߱��������������ʹ�õĿ�����ű���
		//���㴰�ڱ���ͼ��߱���
		float scaleX = ELEMENT_SIZE / (float)origin_my_tank_up.getWidth();
		float scaleY = ELEMENT_SIZE / (float)origin_my_tank_up.getHeight();
		//���������ı���ͼƬ
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
	 * ���ڷ���ͼƬ
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return ���ط������ͼƬ
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		return newImage;
	}
	/**
	 * ���ڻ��Ƽ���̹��
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
	 * ���ڻ���AI̹��
	 * @param g2d
	 */
	public void drawAITanks(Graphics g2d) {
		for(AiTank ai:AiTankArray.aiTank) {
			switch(ai.direction) {
				case 1://��һ��̹��
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
	 * �˷������ڻ�������̹��
	 * @param g2d
	 */
	public void drawTanks(Graphics g2d) {
		drawAITanks(g2d);
		drawMyTank(g2d,myTank);
	}
}
