/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.actions.CanShootBullet;
import edu.nwpu.citybattle.actions.Hitable;
import edu.nwpu.citybattle.actions.Movable;

/**
 * ��̹�˸���
 * @version 1.0.0
 * @see AiTank
 * @see MyTank
 */
public abstract class Tank implements Movable, Hitable, CanShootBullet<Bullet> {
	/**
	 * ̹��Xλ�ã��������Ͻǣ�
	 * @since 1.0.0
	 */
	public int tank_x;
	/**
	 * ̹��Yλ�ã��������Ͻǣ�
	 * @since 1.0.0
	 */
	public int tank_y;
	
	/**
	 * ̹�˳���
	 * @since 1.0.0
	 */
	public int direction;
	public static int UP = 1; // ����
	public static int DOWN = 2; // ����
	public static int LEFT = 3; // ����
	public static int RIGHT = 4; // ����
	
	/**
	 * ̹��Ѫ��
	 * @since 1.0.0
	 */
	public int HP;
	
	
	
}
