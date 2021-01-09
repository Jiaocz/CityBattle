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
	public static final HashSet<Bullet> Bullets = new HashSet<Bullet>();

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
	 * ÿ���ʱ����ƶ��ӵ�
	 */
	@Override
	public void moveNext() {
		// �ñ�X��Y����
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
	 * ��̬������ͨ���ӵ������ھ�̬�ӵ��б���ɾ��ĳ�ӵ���ͬʱɾ����ƻ�����
	 * 
	 * @param bullet ��Ҫɾ�����ӵ�����
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public static boolean remove(Bullet bullet) {
		CustomsPass.contentPane.remove(bullet.j);
		return Bullets.remove(bullet) && ThreadCronJob.removeJob(bullet);
	}

	/**
	 * ͨ���ӵ�����ɾ���ӵ�����ƻ�����
	 * 
	 * @return �Ƿ�ɾ���ɹ�
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
