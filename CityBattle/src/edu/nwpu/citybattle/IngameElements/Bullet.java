/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.CustomsPass;
import edu.nwpu.citybattle.actions.Movable;
import edu.nwpu.citybattle.alogrism.BulletAlogrism;
import edu.nwpu.citybattle.alogrism.CronJobSet;
import edu.nwpu.citybattle.alogrism.ThreadCronJob;

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
	public static final HashSet<Bullet> Bullets = new HashSet<Bullet>();

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
	
	public JLabel j;
	ImageIcon origin_bullet_up;
	ImageIcon origin_bullet_down;
	ImageIcon origin_bullet_left;
	ImageIcon origin_bullet_right;	
	private static int  ELEMENT_SIZE;
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
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
		
		this.initialPainter();
		this.loadImg();
		switch(this.direction) {
			case UP:
				j = new JLabel(origin_bullet_up);
				j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE * 2);
				break;
			case DOWN:
				j = new JLabel(origin_bullet_down);
				j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE * 2);
				break;
			case RIGHT:
				j = new JLabel(origin_bullet_right);
				j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE * 2, ELEMENT_SIZE);
				break;
			case LEFT:
				j = new JLabel(origin_bullet_left);
				
				j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE * 2, ELEMENT_SIZE );
				break;
			default:
				break;	
		}
		CustomsPass.contentPane.add(j);
		ThreadCronJob.addJob(this);
		
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
			j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE * 2);
			break;
		case DOWN:
			this.pos_y += Bullet.speed;
			j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE * 2);
			break;
		case LEFT:
			this.pos_x -= Bullet.speed;
			
			j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE * 2, ELEMENT_SIZE );
			break;
		case RIGHT:
			this.pos_x += Bullet.speed;
			j.setBounds(this.pos_x*ELEMENT_SIZE, this.pos_y*ELEMENT_SIZE, ELEMENT_SIZE * 2, ELEMENT_SIZE );
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
		CustomsPass.contentPane.remove(bullet.j);
		return Bullets.remove(bullet) && ThreadCronJob.removeJob(bullet);
	}

	/**
	 * 通过子弹本身删除子弹及其计划任务
	 * 
	 * @return 是否删除成功
	 */
	public boolean remove() {
		CustomsPass.contentPane.remove(this.j);
		return Bullet.Bullets.remove(this) && ThreadCronJob.removeJob(this);
	}

	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	public void loadImg() {
		origin_bullet_up = new ImageIcon("img\\bullet_up.png");
		origin_bullet_up.setImage(origin_bullet_up.getImage().getScaledInstance(ELEMENT_SIZE , ELEMENT_SIZE * 2, 0));
		origin_bullet_down = new ImageIcon("img\\bullet_down.png");
		origin_bullet_down.setImage(origin_bullet_down.getImage().getScaledInstance(ELEMENT_SIZE , ELEMENT_SIZE * 2, 0));
		origin_bullet_left = new ImageIcon("img\\bullet_left.png");
		origin_bullet_left.setImage(origin_bullet_left.getImage().getScaledInstance(ELEMENT_SIZE * 2, ELEMENT_SIZE, 0));
		origin_bullet_right = new ImageIcon("img\\bullet_down.png");
		origin_bullet_right.setImage(origin_bullet_right.getImage().getScaledInstance(ELEMENT_SIZE * 2, ELEMENT_SIZE , 0));
	}
}
