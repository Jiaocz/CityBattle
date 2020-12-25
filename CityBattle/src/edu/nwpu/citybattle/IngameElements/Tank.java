/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.actions.CanShootBullet;
import edu.nwpu.citybattle.actions.Hitable;
import edu.nwpu.citybattle.actions.Movable;

/**
 * 总坦克父类
 * @version 1.0.0
 * @see AiTank
 * @see MyTank
 */
public abstract class Tank implements Movable, Hitable, CanShootBullet<Bullet> {
	/**
	 * 坦克X位置（基于左上角）
	 * @since 1.0.0
	 */
	public int tank_x;
	/**
	 * 坦克Y位置（基于左上角）
	 * @since 1.0.0
	 */
	public int tank_y;
	
	/**
	 * 坦克朝向
	 * @since 1.0.0
	 */
	public int direction;
	public static int UP = 1; // 向上
	public static int DOWN = 2; // 向下
	public static int LEFT = 3; // 向左
	public static int RIGHT = 4; // 向右
	
	/**
	 * 坦克血量
	 * @since 1.0.0
	 */
	public int HP;
	
	
	
}
