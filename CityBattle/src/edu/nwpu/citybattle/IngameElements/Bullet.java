/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import java.util.LinkedHashSet;
import edu.nwpu.citybattle.actions.Movable;
import edu.nwpu.citybattle.alogrism.BulletAlogrism;
import edu.nwpu.citybattle.alogrism.CronJobSet;

/**
 * ����Ϊ̹���ӵ��࣬�ӵ�����ʵ��������Զ����ص���̬�ӵ��б��м��ƻ������С�
 * 
 * @author Orangii
 * @version 1.0.2
 * @see edu.nwpu.citybattle.alogrism.BulletAlogrism
 */
public class Bullet implements Movable {
	/**
	 * ��{@code LinkedHashSet}ά�����г��ϵ��ӵ�
	 * 
	 * @since 1.0.0
	 * @see LinkedHashSet
	 */
	public static final LinkedHashSet<Bullet> Bullets = new LinkedHashSet<Bullet>();

	/**
	 * �ӵ���X����
	 * 
	 * @since 1.0.0
	 */
	public int pos_x;
	/**
	 * �ӵ���X����
	 * 
	 * @since 1.0.0
	 */
	public int pos_y;
	/**
	 * �ӵ��ķ��з���ʹ�ù��캯���趨
	 * 
	 * @since 1.0.0
	 */
	public final int direction;

	// �ӵ��ٶ�
	private static int speed = 1;

	/**
	 * ����һ���ӵ�������X��Y���꼰�䷽��
	 * 
	 * @param pos_x
	 * @param pos_y
	 * @param direction
	 */
	public Bullet(int pos_x, int pos_y, int direction) {
		// Set Attributes
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.direction = direction;
		// Add bullet to LinkedHashSet
		Bullets.add(this);
		CronJobSet.addJob(this);
	}

	/**
	 * ÿ���ʱ����ƶ��ӵ�
	 */
	@Override
	public void moveNext() {
		// �ñ�X��Y����
		switch (this.direction) {
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
		
		BulletAlogrism.<Bullet>getSingletonInstance().isHitting(this);
	}

	/**
	 * ��̬������ͨ���ӵ������ھ�̬�ӵ��б���ɾ��ĳ�ӵ���ͬʱɾ����ƻ�����
	 * 
	 * @param bullet ��Ҫɾ�����ӵ�����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public static boolean remove(Bullet bullet) {
		return Bullets.remove(bullet) && CronJobSet.removeJob(bullet);
	}

	/**
	 * ͨ���ӵ�����ɾ���ӵ�����ƻ�����
	 * 
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean remove() {
		return Bullet.Bullets.remove(this) && CronJobSet.removeJob(this);
	}
}
