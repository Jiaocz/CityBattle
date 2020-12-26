/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;
import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * ��������ά�����ӵ����㷨<br />
 * ���ӵ���ײ���¼���ά����<br />
 * �ӵ������ݲ��ڴ����С�<br />
 * �����Ҫ��ñ���ʵ��������ο����·�����<br />
 * 	{@code BulletAlogrism<Bullet> bulletAlogrism = BulletAlogrism.<Bullet>getSingletonInstance();}<br />
 * ���з���BulletΪ��Ҫά�����ӵ������ͣ�֮�����ʱ�����ں���ǰȥ������{@code <Bullet>}���籾�������Main������ʾ����
 * 
 * @author Orangii
 * @version 1.0.0
 */
public class BulletAlogrism<BulletClass extends Bullet> {
	/**
	 * ��һʵ�������֣�ֻ��ͨ��{@code getSingletonInstance<Bullet>()}������ȡ
	 * 
	 * @since 1.0.0
	 */
	@SuppressWarnings("rawtypes")
	private static BulletAlogrism singletonInstance;

	/**
	 * ǽ�����飬�����жϡ�
	 * 
	 * @since 1.0.0
	 */
	private static int[][] wall;
	/**
	 * ��ǽ�����飬�����жϡ�
	 * 
	 * @since 1.0.0
	 */
	private static int[][] iron_wall;
	/**
	 * �з�AI̹�˵����飬�����жϡ�
	 * 
	 * @since 1.0.0
	 */
	private static ArrayList<AiTank> ai_tank;
	/**
	 * �ҷ�̹�����ݣ������ж�
	 * 
	 * @since 1.0.0
	 */
	private static MyTank myTank;

	/**
	 * �ж��Ƿ�����Ϸ�������Է�ֹ���ִ���
	 * 
	 * @since 1.0.0
	 */
	private static boolean hasData = false;
	
	// ��ͼ������
	private static int WIDTH = 56;
	private static int HEIGHT = 40;
	// ̹�˿��
	private static int TANK_WIDTH = 5;
	private static int TANK_HEIGHT = 5;
	

	/**
	 * ����Ҫ��������ж�ʱ����Ҫ�Ե�ͼ���ݵĳ�ʼ����<br />
	 * ����ͼ�л����һ��ʹ�ñ�����м����ʱ����Ҫʹ�ñ��������д�����Ϸ���������򽫻��������
	 * 
	 * @since 1.0.0
	 * @param initWall ��ͨǽ����
	 * @param initIronWall ��ǽ����
	 * @param initAiTank AI�з�̹���б�
	 * @param initMyTank ��ҿ���̹�˶���
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
	 * �����ж��Ƿ�Ϊ���ഫ������Ϸ����
	 * @return {@code true}��ʾ�����ѽ��ղ�������Ϸ���ݣ� {@code false}��ʾ������ȱ��ĳ��Ϸ���ݣ�ʹ��{@code initAlogrism}���������趨��
	 */
	public static boolean hasData() {
		return hasData;
	}

	/**
	 * ���������ڻ�ȡ����Ψһ��������Ҫ�ڵ�һ��ʹ��ʱȷ���ӵ����Ͳ����뷺���Ի�ȡ��ȷ���ͷ���ֵ<br />
	 * 
	 * @since 1.0.0
	 * @param <Bullet> ��һ�ε���ʱȷ���ӵ�����
	 * @return ��һʵ��
	 * @see BulletAlogrism
	 */
	@SuppressWarnings("unchecked")
	public static <BulletClass extends Bullet> BulletAlogrism<BulletClass> getSingletonInstance() {
		if (singletonInstance == null)
			singletonInstance = new BulletAlogrism<BulletClass>();
		return singletonInstance;
	}

	/**
	 * ��ֹ�����ഴ������
	 */
	private BulletAlogrism() {}
	
	/**
	 * ���ڴ������ӵ����е�����ı������¼���<br />
	 * ʹ��ǰ����ʹ��{@code initAlogrism}�����趨�㷨���� <br />
	 * ʹ��ǰҲӦ�����ӵ���{@code moveNext()}�������ӵ�������и��¡�
	 * @param BulletList
	 * @throws NoGameDataException
	 */
	public void isHitting(ArrayList<BulletClass> BulletList) throws NoGameDataException {
		//û����Ϸ����ʱ�׳��쳣
		if(!hasData) throw new NoGameDataException("��Ϸ����δ����");
		
		BulletList:
		for(BulletClass b : BulletList) {
			// �����߽�
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
			
			// ��ײ����̹��
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
			
			// ��ײ�з�̹��
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
			
			// ��ײ��ͨǽ
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
			
			// ��ײ��ǽ
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
	 * ��������������ʹ�ñ���ʱ����ԡ�
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
