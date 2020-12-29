package edu.nwpu.citybattle.painter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import UI.CustomsPass;
import edu.nwpu.citybattle.TankMap.Map;

/**
 * 璇ョ被鐢ㄤ簬缁樺埗澧欑被
 * @author 寰瑧鏈け
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
public class ShapePainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private int ELEMENT_SIZE;
	public static final int WALL = 0;
	public static final int IRON_WALL = 1;
	public static final int GRASS = 2;
	public static final int WATER = 3;
	
	private CustomsPass custompass;
	
	BufferedImage img_background;//鑳屾櫙鍥�
	BufferedImage img_wall;//鏅�氬
	BufferedImage img_iron_wall;//閾佸
	BufferedImage img_grass;//鑽夊潽
	BufferedImage img_water;//姘�
	public ShapePainter(CustomsPass custompass) {
		this.custompass = custompass;
	}
	/**
	 * 杩欐槸鏋勯�狅紝鍒涘缓璇ョ被瀵硅薄鏃讹紝浣犻渶瑕佸mainPanel鍜宮ap杩涜鍒濆鍖�
	 * @param mainPanel
	 * @param map
	 */
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬鍒濆鍖栧悇绉嶅ぇ灏�
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
	 * 杩欎釜鏂规硶鐢ㄤ簬鍔犺浇鍥剧墖骞惰繘琛屾斁缂�
	 * @throws IOException
	 */
	public void loadBmp() throws IOException
	{
		if(ELEMENT_SIZE <= 0)
			return;
		
		//浠�/res/imgs鐩綍锛屽姞杞芥墍鏈夊師濮嬬収鐗囷紙鏈媺浼革級
		BufferedImage origin_background = ImageIO.read(ShapePainter.class.getResource("/imgs/background.png"));
		BufferedImage origin_wall = ImageIO.read(ShapePainter.class.getResource("/imgs/wall.png"));
		BufferedImage origin_iron_wall = ImageIO.read(ShapePainter.class.getResource("/imgs/iron.png"));
		BufferedImage origin_grass = ImageIO.read(ShapePainter.class.getResource("/imgs/grass.png"));
		BufferedImage origin_water = ImageIO.read(ShapePainter.class.getResource("/imgs/water.png"));		
		//鎸夌獥鍙ｅ銆侀珮姣斾緥锛岃绠楀嚭鏈�缁堜娇鐢ㄧ殑瀹介珮缂╂斁姣斾緥
		//璁＄畻绐楀彛鑳屾櫙鍥惧楂樻瘮渚�
		float scaleX = WINDOW_WIDTH / (float)origin_background.getWidth();
		float scaleY = WINDOW_HEIGHT / (float)origin_background.getHeight();
		//鍒涘缓鎷変几鍚庣殑鑳屾櫙鍥剧墖
		img_background = createScaledImg(origin_background, scaleX, scaleY);
		
		//璁＄畻姣忎竴灏忔牸鍥剧墖鐨勬媺浼告瘮渚嬶紙瑕佹眰姣忎竴涓皬鏍煎瓙鍘熷鍥剧墖灏哄瀹屽叏涓�鏍凤紒锛�
		scaleX = ELEMENT_SIZE / (float)origin_wall.getWidth();
		scaleY = ELEMENT_SIZE / (float)origin_wall.getHeight();
		
		//鎷変几鍚勪釜棰滆壊鐨勫皬鏍煎瓙鍥剧墖
		img_grass = createScaledImg(origin_grass, scaleX, scaleY);
        img_wall = createScaledImg(origin_wall, scaleX, scaleY);
        img_iron_wall = createScaledImg(origin_iron_wall, scaleX, scaleY);
        img_water = createScaledImg(origin_water, scaleX, scaleY);
	}
	/**
	 * 鍐呴儴鏂规硶锛岀敤浜庢斁缂╁浘鐗�
	 * @param originImg
	 * @param scaleX
	 * @param scaleY
	 * @return 杩斿洖鏀剧缉鍚庣殑鍥剧墖
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		return newImage;
	}
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬鐢昏儗鏅浘
	 * @param g2d
	 */
	public void drawBackground(Graphics g2d){
		g2d.drawImage(img_background, 0, 0, custompass);//璐磋儗鏅浘
	}
	public void drawWall(Graphics g2d) {//缁樺埗澧欏浘
		for(int x = 0;x < Map.wall.length;x++) {
			for(int y = 0;y < Map.wall[x].length;y++) {
				if(Map.wall[x][y] == 1)
				drawShape(g2d,x,y,WALL);
			}
		}
	}
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬鐢婚搧澧�
	 * @param g2d
	 */
	public void drawIronWall(Graphics g2d) {//缁樺埗閾佸
		for(int x = 0;x < Map.ironwall.length;x++) {
			for(int y = 0;y < Map.ironwall[x].length;y++) {
				if(Map.ironwall[x][y] == 1)
				drawShape(g2d,x,y,IRON_WALL);
			}
		}
	}
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬缁樺埗鑽夊湴
	 * @param g2d
	 */
	public void drawGrass(Graphics g2d) {//缁樺埗鑽夊湴
		for(int x = 0;x < Map.grass.length;x++) {
			for(int y = 0;y < Map.grass[x].length;y++) {
				if(Map.grass[x][y] == 1)
				drawShape(g2d,x,y,GRASS);
			}
		}
	}
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬缁樺埗澧�
	 * @param g2d
	 */
	public void drawWater(Graphics g2d) {//缁樺埗澧欏浘
		for(int x = 0;x < Map.water.length;x++) {
			for(int y = 0;y < Map.water[x].length;y++) {
				if(Map.water[x][y] == 1)
				drawShape(g2d,x,y,WATER);
			}
		}
	}
	/**
	 * 杩欎釜鏂规硶鐢ㄤ簬鍒よ闇�瑕佺粯鍒剁殑鍥惧舰绫诲瀷锛屽苟灏嗗叾缁樺埗鍑烘潵
	 * @param g2d
	 * @param x
	 * @param y
	 * @param blockType
	 */
	public void drawShape(Graphics g2d, int x, int y, int blockType)
	{
		switch(blockType)
		{
		case WALL:
			g2d.drawImage(img_wall, x*ELEMENT_SIZE, y*ELEMENT_SIZE, custompass);
			break;
		case IRON_WALL:
			g2d.drawImage(img_iron_wall, x*ELEMENT_SIZE, y*ELEMENT_SIZE, custompass);
			break;
		case GRASS:
			g2d.drawImage(img_grass, x*ELEMENT_SIZE, y*ELEMENT_SIZE, custompass);
			break;
		case WATER:
			g2d.drawImage(img_water, x*ELEMENT_SIZE, y*ELEMENT_SIZE, custompass);
			break;
		default:
			break;
		}
	}
	/**
	 * 姝ゆ柟娉曠敤浜庣敾鍑烘墍鏈夌殑褰㈢姸
	 * @param g2d
	 */
	public void drawAllShap(Graphics g2d) {
		drawBackground(g2d);
		drawWall(g2d);
		drawIronWall(g2d);
		drawWater(g2d);
		drawGrass(g2d);
	}
}