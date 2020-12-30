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
	 * 调用函数，在坦克朝向的正中间生成子弹
	 */
	public Bullet shootBullet() {
		if(direction == UP)
			Bullet.Bullets.add(new Bullet(tank_x+2,tank_y,direction));
		if(direction==DOWN)
			Bullet.Bullets.add(new Bullet(tank_x+2,tank_y,direction));
		if(direction==LEFT)
			Bullet.Bullets.add(new Bullet(tank_x,tank_y+2,direction));
		if(direction==RIGHT)
			Bullet.Bullets.add(new Bullet(tank_x+2,tank_y+2,direction));
		
		return null;
	}
	
	/**
	 * 遍历朝向的数组,判断是否可以移动
	 * @param direction
	 * @return
	 */
	
	public int readLine(int direction) {
		int i;
		switch(direction) {
	//上的情况
		case UP:
			for(i=0;i<5;i++) {
				tank_x=tank_x+i;
				if(Map.wall[tank_x][tank_y-1]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//左的情况			
		case LEFT:
			for(i=0;i<5;i++) {
				tank_y=tank_y+i;
				if(Map.wall[tank_x-1][tank_y]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//右的情况		
		case RIGHT:
			for(i=0;i<5;i++) {
				tank_y=tank_y+i;
				if(Map.wall[tank_x+5][tank_y]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//下的情况		
		case DOWN:
			for(i=0;i<5;i++) {
				tank_x=tank_x+i;
				if(Map.wall[tank_x][tank_y+5]!=0)
					break;
				}
			if(i!=5)
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
		int a=readLine(direction);
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
	@Override
	public void onHit() {
		HP--;
	}

}
