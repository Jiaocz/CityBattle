package edu.nwpu.citybattle.IngameElements;

import java.util.Random;

import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.actions.Movable;

/**
 * 
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {
	/**
	 * ��ʼ����̹�˵����꣬������̹�����������ɵ��µ�AiTank
	 */
	private int initX;
	private int initY;

	/**
	 * ̹�˵��ٶ�
	 */
	private int speed = 5;

	/**
	 * ̹�˵Ŀ���
	 */
	private int width = 40;
	private int height = 40;

	/**
	 * AiTanks�ƶ�
	 */
	@Override
	public void moveNext() {
		// FIXME moveNext()方法是定时器调用，这里不要写while，会冲突
		while (judgeLimit()) {

			if (direction == 2) {
				tank_y += speed;
				setRandomDir();
			}
			if (direction == 1) {
				tank_y -= speed;
				setRandomDir();
			}
			if (direction == 3) {
				tank_x -= speed;
				setRandomDir();
			}
			if (direction == 4) {
				tank_x += speed;
				setRandomDir();
			}
		}
	}

	@Override
	public void onHit() {
		HP--;
	}

	/**
	 * �ж��Ƿ�������
	 * 
	 * @return
	 */
	private boolean judgeLimit() {
		
		// FIXME 算法有问题，下课来我办公室
		if (tank_x < 0) {
			tank_x = 0;
			return true;
		}
		if (tank_y < 0) {
			tank_y = 0;
			return true;
		}
		switch (direction) {
		case UP:
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++) {
					if(Map.ironwall[tank_x+i][tank_y+j] != 0 && Map.wall[tank_x+i][tank_y+j] != 0 && Map.water[tank_x+i][tank_y+j] != 0)
						return false;
				}
			}
			return true;

		case DOWN:
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++) {
					if(Map.ironwall[tank_x+i][tank_y+j] != 0 && Map.wall[tank_x+i][tank_y+j] != 0 && Map.water[tank_x+i][tank_y+j] != 0)
						return false;
				}
			}
			return true;
			
		case LEFT:
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++) {
					if(Map.ironwall[tank_x+i][tank_y+j] != 0 && Map.wall[tank_x+i][tank_y+j] != 0 && Map.water[tank_x+i][tank_y+j] != 0)
						return false;
				}
			}
			return true;
			
		case RIGHT:
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++) {
					if(Map.ironwall[tank_x+i][tank_y+j] != 0 && Map.wall[tank_x+i][tank_y+j] != 0 && Map.water[tank_x+i][tank_y+j] != 0)
						return false;
				}
			}
			return true;
			
		default:
			return false;

		}

	}

	/**
	 * ���
	 */
	@Override
	public Bullet shootBullet() {
		int x = this.tank_x + 2;
		int y = this.tank_y + 2;
		int direction = this.direction;

		return new Bullet(x, y, direction);
	}

	// FIXME 你介个应该放下面方法体里面吧
	private boolean f = false;

	/**
	 * Ϊ�з�̹�������ƶ��ķ���
	 */
	private void setRandomDir() {
		while (f = false) {
			int r = new Random().nextInt(5);
			switch (r) {
			case 1: {
				direction = 1;
				f = true;
				break;
			}
			case 2: {
				direction = 2;
				f = true;
				break;
			}
			case 3: {
				direction = 3;
				f = true;
				break;
			}
			case 4: {
				direction = 4;
				f = true;
				break;
			}
			default:
				f = false;
				break;

			}

		}
	}

	public static final int UP = 1; // ����
	public static final int DOWN = 2; // ����
	public static final int LEFT = 3; // ����
	public static final int RIGHT = 4; // ����

	public AiTank(int tank_x, int tank_y, int direction, int HP) {

		this.tank_x = tank_x;
		this.tank_y = tank_y;
		this.direction = direction;

		initX = tank_x;
		initY = tank_y;

	}

	/**
	 * ����̹��x����
	 * 
	 * @return
	 */
	public int getTank_x() {
		return tank_x;
	}

	/**
	 * ����̹��y����
	 * 
	 * @return
	 */
	public int getTank_y() {
		return tank_y;
	}

	/**
	 * ����hpֵ
	 * 
	 * @return
	 */
	public int getHP() {
		return HP;
	}

	/**
	 * ���ظ�̹�˳�ʼx����
	 */
	public int getInitX() {
		return this.initX;
	}

	/**
	 * ���ظ�̹�˵ĳ�ʼy����
	 */
	public int getInitY() {
		return this.initY;
	}

	/**
	 * ��������Ѫ��ֵ
	 */
	public void setHP() {
		this.HP = 3;
	}

	public void setTank_x(int x) {
		this.tank_x = x;
	}

	public void setTank_y(int y) {
		this.tank_y = y;
	}

	public void setInitX(int x) {
		this.initX = x;
	}

	public void setInitY(int y) {
		this.initY = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
