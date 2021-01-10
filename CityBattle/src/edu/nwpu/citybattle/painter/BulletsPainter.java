package edu.nwpu.citybattle.painter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nwpu.citybattle.IngameElements.Bullet;

/**
 * ���������ӵ��Ļ���
 * 
 * @author ΢Цδʧ
 * @see drawBullets
 * @see loadImg
 * @see initialPainter
 */
public class BulletsPainter {
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	private static int ELEMENT_SIZE;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	JPanel contentPane;

	JLabel bullet_up;
	JLabel bullet_down;
	JLabel bullet_left;
	JLabel bullet_right;
	ImageIcon origin_bullet_up;
	ImageIcon origin_bullet_down;
	ImageIcon origin_bullet_left;
	ImageIcon origin_bullet_right;

	public BulletsPainter(JPanel contentPane) {
		this.contentPane = contentPane;
		this.initialPainter();
		this.loadImg();
		this.drawBullets();
	}

	/**
	 * �÷������ڳ�ʼ�����ƴ�С
	 */
	public void initialPainter() {
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);

		ELEMENT_SIZE = size1 < size2 ? size1 : size2;
	}

	/**
	 * �÷�����������ͼƬ
	 */
	public void loadImg() {
		origin_bullet_up = new ImageIcon("img\\bullet_up.png");
		origin_bullet_up.setImage(origin_bullet_up.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE * 2, 0));
		origin_bullet_down = new ImageIcon("img\\bullet_down.png");
		origin_bullet_down.setImage(origin_bullet_down.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE * 2, 0));
		origin_bullet_left = new ImageIcon("img\\bullet_left.png");
		origin_bullet_left.setImage(origin_bullet_left.getImage().getScaledInstance(ELEMENT_SIZE * 2, ELEMENT_SIZE, 0));
		origin_bullet_right = new ImageIcon("img\\bullet_down.png");
		origin_bullet_right
				.setImage(origin_bullet_right.getImage().getScaledInstance(ELEMENT_SIZE * 2, ELEMENT_SIZE, 0));
	}

	/**
	 * �÷������ڸ����ӵ���������ӵ�
	 */
	public void drawBullets() {
		for (Bullet bullet : Bullet.Bullets) {
			switch (bullet.direction) {
			case UP:
				bullet_up = new JLabel(origin_bullet_up);
				bullet_up.setBounds(bullet.pos_x * ELEMENT_SIZE, bullet.pos_y * ELEMENT_SIZE, ELEMENT_SIZE,
						ELEMENT_SIZE * 2);
				contentPane.add(bullet_up);
				break;
			case DOWN:
				bullet_down = new JLabel(origin_bullet_down);
				bullet_down.setBounds(bullet.pos_x * ELEMENT_SIZE, bullet.pos_y * ELEMENT_SIZE, ELEMENT_SIZE,
						ELEMENT_SIZE * 2);
				contentPane.add(bullet_down);
				break;
			case LEFT:
				bullet_left = new JLabel(origin_bullet_left);
				bullet_left.setBounds(bullet.pos_x * ELEMENT_SIZE, bullet.pos_y * ELEMENT_SIZE, ELEMENT_SIZE * 2,
						ELEMENT_SIZE);
				contentPane.add(bullet_left);
				break;
			case RIGHT:
				bullet_right = new JLabel(origin_bullet_right);
				bullet_right.setBounds(bullet.pos_x * ELEMENT_SIZE, bullet.pos_y * ELEMENT_SIZE, ELEMENT_SIZE * 2,
						ELEMENT_SIZE);
				contentPane.add(bullet_right);
				break;
			default:
				return;
			}
		}
	}

}
