package edu.nwpu.citybattle.IngameElements;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import UI.Choice;
import UI.CustomsPass;
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
	 * 记录AiTank的初始位置
	 */
	private int initX;
	private int initY;

	private int speed = 1;

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
	
	switch(this.HP) {
		case 1:
			if(this.direction == Tank.UP) {
				this.j.setIcon(origin_first_tank_up);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.DOWN) {
				this.j.setIcon(origin_first_tank_down);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.LEFT) {
				this.j.setIcon(origin_first_tank_left);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE,ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_first_tank_right);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
		case 2:
			if(this.direction == Tank.UP) {
				this.j.setIcon(origin_second_tank_up);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.DOWN) {
				this.j.setIcon(origin_second_tank_down);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE,ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.LEFT) {
				this.j.setIcon(origin_second_tank_left);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_second_tank_right);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
		case 3:
			if(this.direction == Tank.UP) {
				this.j.setIcon(origin_third_tank_up);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.DOWN) {
				this.j.setIcon(origin_third_tank_down);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.LEFT) {
				this.j.setIcon(origin_third_tank_left);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}else if(this.direction == Tank.RIGHT) {
				this.j.setIcon(origin_third_tank_right);
				this.j.setBounds(this.getTank_x()*ELEMENT_SIZE, this.getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
				CustomsPass.contentPane.updateUI();
			}
			break;
	}
}

	@Override
	public void onHit() {
		HP--;
		if(HP == 0) {
			CustomsPass.contentPane.remove(j);
			CustomsPass.winFlag++;
		}
		CustomsPass.next();
		if (HP == 0) {
			
			CronJobSet.addDelayJob(new CronJob() {
				@Override
				public void run() {
					tank_x = initX;
					tank_y = initY;
					HP = 3;
					CustomsPass.contentPane.add(j);
				}
			}, 2000L);
		}

	}

	private boolean judgeLimit() {
		int a;

		if (tank_x <= 1 || tank_x >= 53) {
			return false;
		}
		if (tank_y <= 1 || tank_y >= 37) {
			return false;
		}
		switch (direction) {
		case Tank.UP:
			for (int i = 0; i < 3; i++) {
				a = tank_y - 1;
				if (Map.ironwall[tank_x + i][a] != 0 || Map.wall[tank_x + i][a] != 0 || Map.water[tank_x + i][a] != 0)
					return false;
			}

			return true;

		case Tank.DOWN:
			for (int i = 0; i < 3; i++) {
				a = tank_y + 1;
				if (Map.ironwall[tank_x + i][a] != 0 || Map.wall[tank_x + i][a] != 0 || Map.water[tank_x + i][a] != 0)
					return false;
			}

			return true;

		case Tank.LEFT:
			for (int i = 0; i < 3; i++) {
				a = tank_x - 1;
				if (Map.ironwall[a][tank_y + i] != 0 || Map.wall[a][tank_y + i] != 0 || Map.water[a][tank_y + i] != 0)
					return false;
			}

			return true;

		case Tank.RIGHT:
			for (int i = 0; i < 3; i++) {
				a = tank_x + 1;
				if (Map.ironwall[a][tank_y + i] != 0 || Map.wall[a][tank_y + i] != 0 || Map.water[a][tank_y + i] != 0)
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
		this.HP = HP;

		initX = tank_x;
		initY = tank_y;

		AiTankArray.aiTank.add(this);
		this.initialPainter();
		this.loadImg();
		j = new JLabel(origin_third_tank_up);
		j.setBounds(getTank_x()*ELEMENT_SIZE, getTank_y()*ELEMENT_SIZE, ELEMENT_SIZE * 3, ELEMENT_SIZE * 3);
		CustomsPass.contentPane.add(j);
		
		//ThreadCronJob.addJob(this);
		CronJobSet.addJob(new CronJob() {

			@Override
			public void run() {
				moveNext();
			}
			
		}, 1000L);
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
	
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	public void loadImg() {
		origin_first_tank_up = new ImageIcon("img\\enemy1_up.png");
		origin_first_tank_up.setImage(origin_first_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_down = new ImageIcon("img\\enemy1_down.png");
		origin_first_tank_down.setImage(origin_first_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_left = new ImageIcon("img\\enemy1_left.png");
		origin_first_tank_left.setImage(origin_first_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_first_tank_right = new ImageIcon("img\\enemy1_right.png");
		origin_first_tank_right.setImage(origin_first_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
		origin_second_tank_up = new ImageIcon("img\\enemy2_up.png");
		origin_second_tank_up.setImage(origin_second_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_down = new ImageIcon("img\\enemy2_down.png");
		origin_second_tank_down.setImage(origin_second_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_left = new ImageIcon("img\\enemy2_left.png");
		origin_second_tank_left.setImage(origin_second_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_second_tank_right = new ImageIcon("img\\enemy2_right.png");
		origin_second_tank_right.setImage(origin_second_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		
		origin_third_tank_up = new ImageIcon("img\\enemy3_up.png");
		origin_third_tank_up.setImage(origin_third_tank_up.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_down = new ImageIcon("img\\enemy3_down.png");
		origin_third_tank_down.setImage(origin_third_tank_down.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_left = new ImageIcon("img\\enemy3_left.png");
		origin_third_tank_left.setImage(origin_third_tank_left.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
		origin_third_tank_right = new ImageIcon("img\\enemy3_right.png");
		origin_third_tank_right.setImage(origin_third_tank_right.getImage().getScaledInstance(ELEMENT_SIZE * 3, ELEMENT_SIZE * 3, 0));
	}

}
