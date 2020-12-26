/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;
import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 本类用于维护对子弹的算法<br />
 * 如子弹的撞击事件的维护等<br />
 * 子弹飞行暂不在此类中。<br />
 * 最初若要获得本类实例对象，请参考以下范例：<br />
 * 	{@code BulletAlogrism<Bullet> bulletAlogrism = BulletAlogrism.<Bullet>getSingletonInstance();}<br />
 * 其中泛型Bullet为需要维护的子弹的类型，之后调用时可以在函数前去掉泛型{@code <Bullet>}，如本类测试用Main函数中示例。
 * 
 * @author Orangii
 * @version 1.0.0
 */
public class BulletAlogrism<BulletClass extends Bullet> {
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
	
	// 地图数组宽高
	private static int WIDTH = 56;
	private static int HEIGHT = 40;
	// 坦克宽高
	private static int TANK_WIDTH = 5;
	private static int TANK_HEIGHT = 5;
	

	/**
	 * 当需要本类进行判断时，需要对地图数据的初始化。<br />
	 * 当地图切换或第一次使用本类进行计算的时候需要使用本方法进行传入游戏参数，否则将会产生错误。
	 * 
	 * @since 1.0.0
	 * @param initWall 普通墙数组
	 * @param initIronWall 铁墙数组
	 * @param initAiTank AI敌方坦克列表
	 * @param initMyTank 玩家控制坦克对象
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
	 * @see BulletAlogrism
	 */
	@SuppressWarnings("unchecked")
	public static <BulletClass extends Bullet> BulletAlogrism<BulletClass> getSingletonInstance() {
		if (singletonInstance == null)
			singletonInstance = new BulletAlogrism<BulletClass>();
		return singletonInstance;
	}

	/**
	 * 禁止其他类创建对象
	 */
	private BulletAlogrism() {}
	
	/**
	 * 用于触发被子弹击中的物体的被击中事件。<br />
	 * 使用前请先使用{@code initAlogrism}方法设定算法数据 <br />
	 * 使用前也应调用子弹的{@code moveNext()}方法对子弹坐标进行更新。
	 * @param BulletList
	 * @throws NoGameDataException
	 */
	public void isHitting(ArrayList<BulletClass> BulletList) throws NoGameDataException {
		//没有游戏数据时抛出异常
		if(!hasData) throw new NoGameDataException("游戏数据未传入");
		
		BulletList:
		for(BulletClass b : BulletList) {
			// 触碰边界
			switch(b.direction) {
				case Bullet.UP:
					if(b.pos_y < 0) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.LEFT:
					if(b.pos_x < 0) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.DOWN:
					if(b.pos_y >= HEIGHT) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.RIGHT:
					if(b.pos_x >= WIDTH) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;	
			}
			
			// 碰撞己方坦克
			switch(b.direction) {
				case Bullet.UP:
				case Bullet.LEFT:
					if(b.pos_x >= myTank.tank_x && b.pos_x <= myTank.tank_x + TANK_WIDTH -1 
						&& b.pos_y >= myTank.tank_y && b.pos_y <= myTank.tank_y + TANK_HEIGHT - 1) {
						myTank.onHit();
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.RIGHT:
					if(b.pos_x + 1 >= myTank.tank_x && b.pos_x + 1 <= myTank.tank_x + TANK_WIDTH -1 
						&& b.pos_y >= myTank.tank_y && b.pos_y <= myTank.tank_y + TANK_HEIGHT - 1) {
						myTank.onHit();
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.DOWN:
					if(b.pos_x >= myTank.tank_x && b.pos_x <= myTank.tank_x + TANK_WIDTH -1 
						&& b.pos_y + 1 >= myTank.tank_y && b.pos_y + 1 <= myTank.tank_y + TANK_HEIGHT - 1) {
						myTank.onHit();
						BulletList.remove(b);
						continue BulletList;
					}
					break;
			}
			
			// 碰撞敌方坦克
			for(AiTank t : ai_tank) {
				switch(b.direction) {
					case Bullet.UP:
					case Bullet.LEFT:
						if(b.pos_x >= t.tank_x && b.pos_x <= t.tank_x + TANK_WIDTH -1 
							&& b.pos_y >= t.tank_y && b.pos_y <= t.tank_y + TANK_HEIGHT - 1) {
							myTank.onHit();
							BulletList.remove(b);
							continue BulletList;
						}
						break;
					case Bullet.RIGHT:
						if(b.pos_x + 1 >= t.tank_x && b.pos_x + 1 <= t.tank_x + TANK_WIDTH -1 
							&& b.pos_y >= t.tank_y && b.pos_y <= t.tank_y + TANK_HEIGHT - 1) {
							myTank.onHit();
							BulletList.remove(b);
							continue BulletList;
						}
						break;
					case Bullet.DOWN:
						if(b.pos_x >= t.tank_x && b.pos_x <= t.tank_x + TANK_WIDTH -1 
							&& b.pos_y + 1 >= t.tank_y && b.pos_y + 1 <= t.tank_y + TANK_HEIGHT - 1) {
							myTank.onHit();
							BulletList.remove(b);
							continue BulletList;
						}
						break;
				}
			}
			
			// 碰撞普通墙
			switch(b.direction) {
				case Bullet.UP:
					if(wall[b.pos_x][b.pos_y] == 1) {
						for(int i = 0; i < wall.length; i += 2) {
							if(i == b.pos_x || i == b.pos_x - 1) {
								wall[i][b.pos_y] = wall[i][b.pos_y - 1] = wall[i + 1][b.pos_y] = wall[i + 1][b.pos_y - 1] = 0;
							}
						}
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.DOWN:
					if(wall[b.pos_x][b.pos_y + 1] == 1) {
						for(int i = 0; i < wall.length; i += 2) {
							if(i == b.pos_x || i == b.pos_x - 1) {
								wall[i][b.pos_y + 1] = wall[i][b.pos_y + 2] = wall[i + 1][b.pos_y + 1] = wall[i + 1][b.pos_y + 2] = 0;
								break;
							}
						}
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.LEFT:
					if(wall[b.pos_x][b.pos_y] == 1) {
						for(int i = 0; i < wall[0].length; i += 2) {
							if(i == b.pos_y || i == b.pos_y - 1) {
								wall[b.pos_x][i] = wall[b.pos_x - 1][i] = wall[b.pos_x][i + 1] = wall[b.pos_x - 1][i + 1] = 0;
								break;
							}
						}
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.RIGHT:
					if(wall[b.pos_x + 1][b.pos_y] == 1) {
						for(int i = 0; i < wall[0].length; i += 2) {
							if(i == b.pos_y || i == b.pos_y - 1) {
								wall[b.pos_x + 1][i] = wall[b.pos_x + 2][i] = wall[b.pos_x + 1][i + 1] = wall[b.pos_x + 2][i + 1] = 0;
								break;
							}
						}
						BulletList.remove(b);
						continue BulletList;
					}
					break;
			}
			
			// 碰撞铁墙
			switch(b.direction) {
				case Bullet.UP:
				case Bullet.LEFT:
					if(iron_wall[b.pos_x][b.pos_y] == 1) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.RIGHT:
					if(iron_wall[b.pos_x + 1][b.pos_y] == 1) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
				case Bullet.DOWN:
					if(iron_wall[b.pos_x][b.pos_y + 1] == 1) {
						BulletList.remove(b);
						continue BulletList;
					}
					break;
			}
		}
	}
	
	/**
	 * 测试用主函数，使用本类时请忽略。
	 * @deprecated 1.0.0
	 * @param args
	 * @throws NoGameDataException
	 */
	public static void main(String[] args) throws NoGameDataException {
		BulletAlogrism<Bullet> a = BulletAlogrism.<Bullet>getSingletonInstance();
		BulletAlogrism<Bullet> b = BulletAlogrism.getSingletonInstance();
		System.out.print(a.equals(b));
	}
}
