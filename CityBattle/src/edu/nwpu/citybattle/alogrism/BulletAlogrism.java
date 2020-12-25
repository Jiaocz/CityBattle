/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;
import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 本类用于维护对子弹的算法<br />
 * 如子弹的撞击事件的维护等<br />
 * 子弹飞行暂不在此类中。
 * 
 * @author Orangii
 * @version 1.0.0
 */
public class BulletAlogrism<Bullet> {
	/**
	 * 单一实例的体现，只能通过{@code getSingletonInstance<Bullet>()}方法获取
	 * 
	 * @since 1.0.0
	 */
	@SuppressWarnings("rawtypes")
	private static BulletAlogrism singletonInstance;

	/**
	 * 墙的数组，用于判断。
	 * 
	 * @since 1.0.0
	 */
	private static int[][] wall;
	/**
	 * 铁墙的数组，用于判断。
	 * 
	 * @since 1.0.0
	 */
	private static int[][] iron_wall;
	/**
	 * 敌方AI坦克的数组，用于判断。
	 * 
	 * @since 1.0.0
	 */
	private static ArrayList<AiTank> ai_tank;
	/**
	 * 我方坦克数据，用于判断
	 * 
	 * @since 1.0.0
	 */
	private static MyTank myTank;

	/**
	 * 判断是否传入游戏参数，以防止出现错误
	 * 
	 * @since 1.0.0
	 */
	private static boolean hasData = false;

	/**
	 * 当需要本类进行判断时，需要对地图数据的初始化。<br />
	 * 当地图切换或第一次使用本类进行计算的时候需要使用本方法进行传入游戏参数，否则将会产生错误。
	 * 
	 * @since 1.0.0
	 * @param initTank
	 * @param initWall
	 * @param initIronWall
	 */
	public static void initAlogrism(int[][] initWall, int[][] initIronWall, ArrayList<AiTank> initAiTank,
			MyTank initMyTank) {
		if (initWall == null || initIronWall == null || initAiTank == null || initMyTank == null) {
			throw new NullPointerException("One of the arguments is NULL");
		} else {
			wall = initWall;
			iron_wall = initIronWall;
			ai_tank = initAiTank;
			myTank = initMyTank;
			hasData = true;
		}
	}
	
	/**
	 * 用于判断是否为本类传入了游戏参数
	 * @return {@code true}表示本类已接收并保存游戏数据； {@code false}表示类中仍缺少某游戏数据，使用{@code initAlogrism}方法进行设定。
	 */
	public static boolean hasData() {
		return hasData;
	}

	/**
	 * 本方法用于获取本类唯一对象，且需要在第一次使用时确定子弹类型并传入泛型以获取正确类型返回值<br />
	 * 
	 * @since 1.0.0
	 * @param <Bullet> 第一次调用时确定子弹类型
	 * @return 单一实例
	 */
	@SuppressWarnings("unchecked")
	public static <Bullet> BulletAlogrism<Bullet> getSingletonInstance() {
		if (singletonInstance == null)
			singletonInstance = new BulletAlogrism<Bullet>();
		return singletonInstance;
	}

	/**
	 * 禁止其他类创建对象
	 */
	private BulletAlogrism() {}
	
	/**
	 * 用于触发被子弹击中的物体的被击中事件。<br />
	 * 使用前请先使用{@code initAlogrism}方法设定算法数据
	 * @param BulletList
	 * @throws NoGameDataException
	 */
	public void isHitting(ArrayList<Bullet> BulletList) throws NoGameDataException {
		//没有游戏数据时抛出异常
		if(!hasData) throw new NoGameDataException("游戏数据未传入");
		
		//TODO 见下方
		
		//碰撞己方坦克
		
		//碰撞地方坦克
		
		//碰撞普通墙
		
		//碰撞铁墙
		
	}
}
