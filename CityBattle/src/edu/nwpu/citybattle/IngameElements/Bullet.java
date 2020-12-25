/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import java.util.ArrayList;
import edu.nwpu.citybattle.actions.Movable;

/**
 * ����Ϊ̹���ӵ���
 * @author Orangii
 * @version 1.0.0
 * @see edu.nwpu.citybattle.alogrism.BulletAlogrism
 */
public class Bullet implements Movable{
	/**
	 * ��{@code ArrayList}ά�����г��ϵ��ӵ�
	 * @since 1.0.0
	 * @see ArrayList
	 */
	public static ArrayList<Bullet> Bullets = new ArrayList<Bullet>();
	
	/**
	 * �ӵ���X����
	 * @since 1.0.0
	 */
	public int pos_x;
	/**
	 * �ӵ���X����
	 * @since 1.0.0
	 */
	public int pos_y;
	/**
	 * �ӵ��ķ��з���ʹ�ù��캯���趨
	 * @since 1.0.0
	 */
	public final int direction;
	
	// �ӵ��ٶ�
	private static int speed = 1;

	/**
	 * ����һ���ӵ�������X��Y���꼰�䷽��
	 * @param pos_x
	 * @param pos_y
	 * @param direction
	 */
	public Bullet(int pos_x, int pos_y, int direction) {
		// Set Attributes
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.direction = direction;
		// Add bullet to ArrayList 
		Bullets.add(this);
	}

	/**
	 * ÿ���ʱ����ƶ��ӵ�
	 */
	@Override
	public void moveNext() {
		// �ñ�X��Y����
		switch(this.direction) {
			case UP:
				this.pos_y -= Bullet.speed;
				break;
			case DOWN:
				this.pos_y += Bullet.speed;
				break;
			case LEFT:
				this.pos_x -= Bullet.speed;
				break;
			case RIGHT:
				this.pos_x += Bullet.speed;
				break;
		}
	}
	
	
	
}
