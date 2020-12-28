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
	@Override
	public Bullet shootBullet(float tank_x, float tank_y, int direction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  int cloudMove(int direction) {
		switch(direction) {
		case UP:
			if(Map.water[tank_x][--tank_y]==0||Map.wall[tank_x][--tank_y]==0||Map.ironwall[tank_x][--tank_y]==0)
				return direction;
			else 
				return direction=0;
		case LEFT:
			if(Map.water[--tank_x][tank_y]==0||Map.wall[--tank_x][tank_y]==0||Map.ironwall[--tank_x][tank_y]==0)
				return direction;
			else 
				return direction=0;
		case RIGHT:
			if(Map.water[++tank_x][tank_y]==0||Map.wall[++tank_x][tank_y]==0||Map.ironwall[++tank_x][tank_y]==0)
				return direction;
			else 
				return direction=0;
		case DOWN:
			if(Map.water[tank_x][++tank_y]==0||Map.wall[tank_x][++tank_y]==0||Map.ironwall[tank_x][++tank_y]==0)
				return direction;
			else 
				return direction=0;
		}
		return 0;
	}

	public void moveNext(int direction) {
		int a=cloudMove(direction);
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

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}

}
