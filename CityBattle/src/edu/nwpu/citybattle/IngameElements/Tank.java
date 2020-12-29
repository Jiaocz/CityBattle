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
public abstract class Tank implements Hitable, CanShootBullet<Bullet> {
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
	 * 坦克前进方向
	 * @since 1.0.0
	 */
	public int direction;
	/**
	 * 表示向上方向
	 * @since 1.0.0
	 */
	public static final int UP = 1;
	/**
	 * 表示向下方向
	 * @since 1.0.0
	 */
	public static final int DOWN = 2;
	/**
	 * 表示向左方向
	 * @since 1.0.0
	 */
	public static final int LEFT = 3;
	/**
	 * 表示向右方向
	 * @since 1.0.0
	 */
	public static final int RIGHT = 4;
	
	/**
	 * 坦克血量
	 * @since 1.0.0
	 */
	public int HP;
	
	
	
}
