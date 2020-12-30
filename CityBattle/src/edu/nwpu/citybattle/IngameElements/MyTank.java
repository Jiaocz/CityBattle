/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.TankMap.*;
/**
 * 己方坦克类，由玩家控制
 * @see Tank
 * @version 1.0.0
 */


public class MyTank extends Tank {
	/**
	 * 初始生成坦克的坐标，用来在坦克死亡后生成的新的AiTank
	 */
	private int initX;
	private int initY;
	
	/**
	 * 坦克的速度
	 */
	private int speed = 1;

	/**
	 * 坦克的宽，高
	 */
	private int width = 3;
	private int height = 3;
	public MyTank() {
		this.tank_y = 36;
		this.tank_x = 20;
	}
	/**
	 * 调用函数，在坦克朝向的正中间生成子弹
	 */
	public Bullet shootBullet() {
		if(direction == UP)
			Bullet.Bullets.add(new Bullet(tank_x+1,tank_y,direction));
		if(direction==DOWN)
			Bullet.Bullets.add(new Bullet(tank_x+1,tank_y,direction));
		if(direction==LEFT)
			Bullet.Bullets.add(new Bullet(tank_x,tank_y+1,direction));
		if(direction==RIGHT)
			Bullet.Bullets.add(new Bullet(tank_x+1,tank_y+1,direction));
		
		return null;
	}
	
	/**
	 * 遍历朝向的数组,判断是否可以移动
	 * @param direction
	 * @return
	 */
	
	public int ReadLine(int direction) {
		int i;
		int x=tank_x;
		int y=tank_y;
		switch(direction) {
	//上的情况
		case UP:
			if(y==0) {
				direction=0;
				break;
				}
			for(i=0;i<3;i++) {
				x=x+i;
				if(Map.wall[x][y-1]!=0)
					break;
				if(Map.ironwall[x][y-1]!=0)
					break;
				if(Map.water[x][y-1]!=0)
					break;
				}
			if(i!=3)
				direction =0;
			break;
	//左的情况			
		case LEFT:
			if(x==0) {
				direction =0;
				break;
			}
			for(i=0;i<3;i++) {
				y=y+i;
				if(Map.wall[x-1][y]!=0)
					break;
				if(Map.ironwall[x-1][y]!=0)
					break;
				if(Map.water[x-1][y]!=0)
					break;
				}
			if(i!=3)
				direction =0;
			break;
	//右的情况		
		case RIGHT:
			if(x==53) {
				direction=0;
				break;
			}
			for(i=0;i<3;i++) {
				y=y+i;
				if(Map.wall[x+2][y]!=0)
					break;
				if(Map.ironwall[x+2][y]!=0)
					break;
				if(Map.water[x+2][y]!=0)
					break;
				}
			if(i!=3)
				direction =0;
			break;
	//下的情况		
		case DOWN:
			if(y==35) {
				direction=0;
				break;
			}
			for(i=0;i<3;i++) {
				x=x+i;
				if(Map.wall[x][y+2]!=0)
					break;
				if(Map.ironwall[x][y+2]!=0)
					break;
				if(Map.water[x][y+2]!=0)
					break;
				}
			if(i!=3)
				direction =0;
			break;
		}
			return direction;
	}
	/**
	 * 坦克判断是否可以移动后，做出相应的指令
	 * @param direction
	 */

	public void moveNext(int direction) {
		this.direction = direction;
		int a=ReadLine(direction);
		switch(a) {
		case UP:
			tank_y--;
			break;
		case LEFT:
			tank_x--;
			break;
		case RIGHT:
			tank_x++;
			break;
		case DOWN:
			tank_y++;
			break;
		case 0:
			break;
		}	
	}

	/**
	 * 被击中后，坦克的血量减少
	 */
	public void onHit() {
		HP--;
	}
	
	/**
	 * 获取当前血量
	 */
	public int getHP() {
		return HP;
	}
	
	/**
	 * 获取坦克的位置
	 * @return
	 */
	public int getTank_X() {
		return tank_x;
	}
	public int getTank_Y() {
		return tank_y;
	}
	
	/**
	 * 设置初始血量
	 */
	public void setHP() {
		this.HP = 3;
	}
	
	/**
	 * 返回当前X坐标
	 * @param x
	 */
	public void setTank_x(int x) {
		this.tank_x = x;
	}

	/**
	 * 返回当前的Y坐标
	 * @param y
	 */
	public void setTank_y(int y) {
		this.tank_y = y;
	}
	
	/**
	 * 初始化原X坐标
	 * @param x
	 */
	public void setInitX(int x) {
		this.initX = x;
	}

	/**
	 * 初始化原Y坐标
	 * @param y
	 */
	public void setInitY(int y) {
		this.initY = y;
	}

}