package edu.nwpu.citybattle.IngameElements;

import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.CustomsPass;
import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.actions.Movable;
import edu.nwpu.citybattle.alogrism.CronJobSet;
import edu.nwpu.citybattle.alogrism.ThreadCronJob;

/**
 * AI坦克类，即游戏中非玩家操控的敌方坦克类
 * 
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {

	/**
	 * 记录AiTank的初始位置
	 */
	private int initX;
	private int initY;
	private int initHP;//记录初始值
	private int speed = 1;

	public JLabel j;
	ImageIcon origin_bullet_up;
	ImageIcon origin_bullet_down;
	ImageIcon origin_bullet_left;
	ImageIcon origin_bullet_right;
	private static int ELEMENT_SIZE;
	public static final int WINDOW_WIDTH = 600;
	public static final int WINDOW_HEIGHT = 800;
	public static final int TABLE_WIDTH = 40;
	public static final int TABLE_HEIGHT = 56;
	ImageIcon origin_first_tank_up;
	ImageIcon origin_first_tank_down;
	ImageIcon origin_first_tank_left;
	ImageIcon origin_first_tank_right;
	ImageIcon origin_second_tank_up;
	ImageIcon origin_second_tank_down;
	ImageIcon origin_second_tank_left;
	ImageIcon origin_second_tank_right;
	ImageIcon origin_third_tank_up;
	ImageIcon origin_third_tank_down;
	ImageIcon origin_third_tank_left;
	ImageIcon origin_third_tank_right;

	@Override
	public void moveNext() {
		if (judgeLimit()) {
			if (direction == Tank.DOWN) {
				tank_y += speed;
			}
			if (direction == Tank.UP) {
				tank_y -= speed;
			}
			if (direction == Tank.LEFT) {
				tank_x -= speed;
			}
			if (direction == Tank.RIGHT) {
				tank_x += speed;
			}
		}


		switch (this.HP) {
		case 1:
			if (this.direction == Tank.UP) {
				this.j.setIcon(origin_first_tank_up);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.DOWN) {
				this.j.setIcon(origin_first_tank_down);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.LEFT) {
				this.j.setIcon(origin_first_tank_left);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_first_tank_right);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
		case 2:
			if (this.direction == Tank.UP) {
				this.j.setIcon(origin_second_tank_up);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.DOWN) {
				this.j.setIcon(origin_second_tank_down);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.LEFT) {
				this.j.setIcon(origin_second_tank_left);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_second_tank_right);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
		case 3:
			if (this.direction == Tank.UP) {
				this.j.setIcon(origin_third_tank_up);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.DOWN) {
				this.j.setIcon(origin_third_tank_down);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.LEFT) {
				this.j.setIcon(origin_third_tank_left);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			} else if (this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_third_tank_right);
				this.j.setBounds(this.getTank_x() * ELEMENT_SIZE, this.getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3,
						ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
		}
		// Change Direction after Paint the Tank.
		//setRandomDir();
	}

	@Override
	public void onHit() {
		System.out.println("[DEBUG] " + this.toString() +" Get Hitted");
		HP--;
		if (HP == 0) {
			if(initHP == 1) {
				AiTankArray.firstTankNumber++;
			}else if(initHP == 2) {
				AiTankArray.secondTankNumber++;
			}else if(initHP == 3) {
				AiTankArray.thirdTankNumber++;
			}
			super.tank_x = 0;
			super.tank_y = 0;
			CustomsPass.contentPane.remove(j);
			CustomsPass.winFlag++;
		}
		CustomsPass.win();
		if (HP == 0) {
			ThreadCronJob.removeJob(this);
			tank_x = tank_y = -5;
			CronJobSet.addDelayJob(() -> {
					tank_x = initX;
					tank_y = initY;
					HP = initHP;//回到最初的HP的值
					CustomsPass.contentPane.add(j);
					ThreadCronJob.addJob(AiTank.this);
				}, 2000L);
		}

	}

	//判断是否可移动
	private boolean judgeLimit() {
		int a;

		/*
		if (tank_x <= 1 || tank_x >= 53) {
			return false;
		}
		if (tank_y <= 1 || tank_y >= 37) {
			return false;
		}
		*/
		switch(direction){
			case Tank.UP:
				if(tank_y <= 0) return false;
				break;
			case Tank.LEFT:
				if(tank_x <= 0) return false;
				break;
			case Tank.RIGHT:
				if(tank_x + 3 > 56) return false;
				break;
			case Tank.DOWN:
				if(tank_y + 3 > 40) return false;
				break;
		}


		switch (direction) {
		case Tank.UP:

			for (a = 0; a < 3; a++) {
				if (Map.ironwall[tank_x + a][tank_y - 1] != 0 || Map.wall[tank_x + a][tank_y - 1] != 0
						|| Map.water[tank_x + a][tank_y - 1] != 0)
					return false;
			}

			return true;

		case Tank.DOWN:
			for (a = 0; a < 3; a++) {
				if (Map.ironwall[tank_x + a][tank_y + 3] != 0 || Map.wall[tank_x + a][tank_y + 3] != 0
						|| Map.water[tank_x + a][tank_y + 3] != 0 )
					return false;
			}
			return true;

		case Tank.LEFT:

			for (a = 0; a < 3; a++) {
				if (Map.ironwall[tank_x - 1][tank_y + a] != 0 || Map.wall[tank_x - 1][tank_y + a] != 0
						|| Map.water[tank_x - 1][tank_y + a] != 0)
					return false;
			}

			return true;

		case Tank.RIGHT:
			for (a = 0; a < 3; a++) {
				if (Map.ironwall[tank_x + 3][tank_y + a] != 0 || Map.wall[tank_x + 3][tank_y + a] != 0
						|| Map.water[tank_x + 3][tank_y + a] != 0)
					return false;
			}

			return true;

		default:
			return false;

		}

	}

	@Override
	public Bullet shootBullet() {
		/*
		int x = this.tank_x + 2;
		int y = this.tank_y + 2;
		int direction = this.direction;
		return new Bullet(x, y, direction);
		*/
		if(HP <= 0)
			return null;

		switch(direction){
			case Tank.UP:
				return new Bullet(tank_x+1, tank_y,Bullet.UP);
			case Tank.DOWN:
				return new Bullet(tank_x+1, tank_y+1,Bullet.DOWN);
			case Tank.LEFT:
				return new Bullet(tank_x, tank_y+1, Bullet.LEFT);
			case Tank.RIGHT:
				return new Bullet(tank_x+1, tank_y+1, Bullet.RIGHT);
			default:
				return null;
		}
	}

	private void setRandomDir() {
		/*
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

		 */

		Random random = new Random();

		switch(random.nextInt(5)){
			case 0:
			case 1:
			case 2:
				switch(random.nextInt(4)){
					case 1:
						direction = Tank.UP;
						break;
					case 2:
						direction = Tank.DOWN;
						break;
					case 3:
						direction = Tank.LEFT;
						break;
					default:
						direction = Tank.RIGHT;
						break;
				}
				break;
			case 3:
				direction = Tank.STOP;
			case 4:
				if(random.nextInt(5)>=2)
					this.shootBullet();
				break;
			default:
				direction = Tank.STOP;
				break;
		}
	}

	public AiTank(int tank_x, int tank_y, int direction, int HP) {

		this.tank_x = tank_x;
		this.tank_y = tank_y;
		this.direction = direction;
		this.HP = HP;
		this.initHP = HP;//记录初始值

		initX = tank_x;
		initY = tank_y;

		AiTankArray.aiTank.add(this);
		this.initialPainter();
		this.loadImg();
		j = new JLabel(origin_third_tank_up);
		j.setBounds(getTank_x() * ELEMENT_SIZE, getTank_y() * ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
		CustomsPass.contentPane.add(j);

		// Change random direction and randomly shoot bullet
		CronJobSet.addJob(() -> AiTank.this.setRandomDir(), 200L);
		ThreadCronJob.addJob(this);
		System.out.println(this.toString() + " Created");
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
	public int getInitHP() {
		return this.initHP;
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

	/**
	 * 初始化坦克绘画
	 */
	public void initialPainter() {
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);

		ELEMENT_SIZE = size1 < size2 ? size1 : size2;
	}

	/**
	 * 加载坦克图片
	 */
	public void loadImg() {
		origin_first_tank_up = new ImageIcon("img\\enemy1_up.png");
		origin_first_tank_up
				.setImage(origin_first_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_down = new ImageIcon("img\\enemy1_down.png");
		origin_first_tank_down
				.setImage(origin_first_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_left = new ImageIcon("img\\enemy1_left.png");
		origin_first_tank_left
				.setImage(origin_first_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_right = new ImageIcon("img\\enemy1_right.png");
		origin_first_tank_right
				.setImage(origin_first_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		origin_second_tank_up = new ImageIcon("img\\enemy2_up.png");
		origin_second_tank_up
				.setImage(origin_second_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_down = new ImageIcon("img\\enemy2_down.png");
		origin_second_tank_down
				.setImage(origin_second_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_left = new ImageIcon("img\\enemy2_left.png");
		origin_second_tank_left
				.setImage(origin_second_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_right = new ImageIcon("img\\enemy2_right.png");
		origin_second_tank_right
				.setImage(origin_second_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));

		origin_third_tank_up = new ImageIcon("img\\enemy3_up.png");
		origin_third_tank_up
				.setImage(origin_third_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_down = new ImageIcon("img\\enemy3_down.png");
		origin_third_tank_down
				.setImage(origin_third_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_left = new ImageIcon("img\\enemy3_left.png");
		origin_third_tank_left
				.setImage(origin_third_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_right = new ImageIcon("img\\enemy3_right.png");
		origin_third_tank_right
				.setImage(origin_third_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
	}

	/**
	 * 完全删除一个指定的坦克对象在坦克在表中和线程中的引用
	 *
	 * @param tank 需要删除的坦克
	 * @return 是否删除成功
	 */
	public static boolean remove(AiTank tank){
		if(AiTankArray.aiTank.contains(tank)){
			tank.j.setVisible(false);
			return AiTankArray.aiTank.remove(tank) && ThreadCronJob.removeJob(tank);
		}
		else
			return false;
	}

	/**
	 * 完全删除一个制定的坦克对象的线程及其在列表中的引用
	 *
	 * @return 是否成功删除
	 */
	public boolean remove(){
		return AiTank.remove(this);
	}

	/**
	 * 删除所有坦克示例。
	 */
	public static void removeAllTank(){
		Iterator<AiTank> iterator = AiTankArray.aiTank.iterator();
		while(iterator.hasNext()){
			AiTank ai = iterator.next();
			ThreadCronJob.removeJob(ai);
			ai.j.setVisible(false);
		}
		AiTankArray.aiTank.clear();

	}

}
