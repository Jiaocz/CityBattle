/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import java.util.LinkedHashSet;
import edu.nwpu.citybattle.actions.Movable;
import edu.nwpu.citybattle.alogrism.BulletAlogrism;
import edu.nwpu.citybattle.alogrism.CronJobSet;

/**
 * 本类为坦克子弹类，子弹对象实例化后会自动挂载到静态子弹列表中及计划任务中。
 * 
 * @author Orangii
 * @version 1.0.2
 * @see edu.nwpu.citybattle.alogrism.BulletAlogrism
 */
public class Bullet implements Movable {
	/**
	 * 此{@code LinkedHashSet}维护所有场上的子弹
	 * 
	 * @since 1.0.0
	 * @see LinkedHashSet
	 */
	public static final LinkedHashSet<Bullet> Bullets = new LinkedHashSet<Bullet>();

	/**
	 * 子弹的X坐标
	 * 
	 * @since 1.0.0
	 */
	public int pos_x;
	/**
	 * 子弹的X坐标
	 * 
	 * @since 1.0.0
	 */
	public int pos_y;
	/**
	 * 子弹的飞行方向，使用构造函数设定
	 * 
	 * @since 1.0.0
	 */
	public final int direction;

	// 子弹速度
	private static int speed = 1;

	/**
	 * 构造一个子弹，由其X、Y坐标及其方向
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
	 * 每间隔时间后移动子弹
	 */
	@Override
	public void moveNext() {
		// 该变X、Y坐标
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
	 * 静态方法，通过子弹对象在静态子弹列表中删除某子弹，同时删除其计划任务。
	 * 
	 * @param bullet 需要删除的子弹对象
	 * @return 是否删除成功
	 */
	public static boolean remove(Bullet bullet) {
		return Bullets.remove(bullet) && CronJobSet.removeJob(bullet);
	}

	/**
	 * 通过子弹本身删除子弹及其计划任务
	 * 
	 * @return 是否删除成功
	 */
	public boolean remove() {
		return Bullet.Bullets.remove(this) && CronJobSet.removeJob(this);
	}
}
