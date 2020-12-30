package edu.nwpu.citybattle.IngameElements;

import java.util.Random;

import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.actions.Movable;
import edu.nwpu.citybattle.alogrism.CronJob;
import edu.nwpu.citybattle.alogrism.CronJobSet;
import edu.nwpu.citybattle.alogrism.ThreadCronJob;

/**
 * 
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {

	/**
	 * 璁板綍AiTank鐨勫垵濮嬩綅缃�
	 */
	private int initX;
	private int initY;

	private int speed = 1;

	@Override
	public void moveNext() {

		if (judgeLimit()) {

			if (direction == Tank.DOWN) {
				tank_y += speed;
				setRandomDir();
			}
			if (direction == Tank.UP) {
				tank_y -= speed;
				setRandomDir();
			}
			if (direction == Tank.LEFT) {
				tank_x -= speed;
				setRandomDir();
			}
			if (direction == Tank.RIGHT) {
				tank_x += speed;
				setRandomDir();
			}
		} else
			setRandomDir();
	}

	@Override
	public void onHit() {
		HP--;

		if (HP == 0) {
			
			CronJobSet.addDelayJob(new CronJob() {
				@Override
				public void run() {
					tank_x = initX;
					tank_y = initY;
					HP = 3;
				}
			}, 2000L);
		}

	}

	private boolean judgeLimit() {
		int a;

		if (tank_x <= 0 || tank_x >= 52) {
			return false;
		}
		if (tank_y <= 0 || tank_y >= 36) {
			return false;
		}
		switch (direction) {
		case Tank.UP:
			for (int i = 0; i < 5; i++) {
				a = tank_y - 1;
				if (Map.ironwall[tank_x + i][a] != 0 && Map.wall[tank_x + i][a] != 0 && Map.water[tank_x + i][a] != 0)
					return false;
			}

			return true;

		case Tank.DOWN:
			for (int i = 0; i < 5; i++) {
				a = tank_y + 1;
				if (Map.ironwall[tank_x + i][a] != 0 && Map.wall[tank_x + i][a] != 0 && Map.water[tank_x + i][a] != 0)
					return false;
			}

			return true;

		case Tank.LEFT:
			for (int i = 0; i < 5; i++) {
				a = tank_x - 1;
				if (Map.ironwall[a][tank_y + i] != 0 && Map.wall[a][tank_y + i] != 0 && Map.water[a][tank_y + i] != 0)
					return false;
			}

			return true;

		case Tank.RIGHT:
			for (int i = 0; i < 5; i++) {
				a = tank_x + 1;
				if (Map.ironwall[a][tank_y + i] != 0 && Map.wall[a][tank_y + i] != 0 && Map.water[a][tank_y + i] != 0)
					return false;
			}

			return true;

		default:
			return false;

		}

	}

	@Override
	public Bullet shootBullet() {
		int x = this.tank_x + 2;
		int y = this.tank_y + 2;
		int direction = this.direction;

		return new Bullet(x, y, direction);
	}

	private void setRandomDir() {

		boolean f = false;

		while (f == false) {
			int r = new Random().nextInt(5);
			switch (r) {
			case 1: {
				direction = Tank.UP;
				f = true;
				break;
			}
			case 2: {
				direction = Tank.DOWN;
				f = true;
				break;
			}
			case 3: {
				direction = Tank.LEFT;
				f = true;
				break;
			}
			case 4: {
				direction = Tank.RIGHT;
				f = true;
				break;
			}
			default:
				direction = Tank.STOP;
				f = true;
				break;

			}

		}
	}

	public AiTank(int tank_x, int tank_y, int direction, int HP) {

		this.tank_x = tank_x;
		this.tank_y = tank_y;
		this.direction = direction;

		initX = tank_x;
		initY = tank_y;

		AiTankArray.aiTank.add(this);
		ThreadCronJob.addJob(this);

	}

	public int getTank_x() {
		return tank_x;
	}

	public int getTank_y() {
		return tank_y;
	}

	public int getHP() {
		return HP;
	}

	public int getInitX() {
		return this.initX;
	}

	public int getInitY() {
		return this.initY;
	}

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

}
