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
public abstract class Tank implements Hitable, CanShootBullet<Bullet> {
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
	 * ̹��ǰ������
	 * @since 1.0.0
	 */
	public int direction;
	/**
	 * ��ʾ���Ϸ���
	 * @since 1.0.0
	 */
	public static final int UP = 1;
	/**
	 * ��ʾ���·���
	 * @since 1.0.0
	 */
	public static final int DOWN = 2;
	/**
	 * ��ʾ������
	 * @since 1.0.0
	 */
	public static final int LEFT = 3;
	/**
	 * ��ʾ���ҷ���
	 * @since 1.0.0
	 */
	public static final int RIGHT = 4;
	
	/**
	 * ̹��Ѫ��
	 * @since 1.0.0
	 */
	public int HP;
	
	
	
}
