/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

/**
 * 己方坦克类，由玩家控制
 * @see Tank
 * @version 1.0.0
 */
public class MyTank extends Tank {

	@Override
	public Bullet shootBullet(float x, float y, int direction) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void moveNext(int direction) {
		switch(direction) {
		case UP:
			if(--tank_y==0)
			tank_y--;
			else
				return;
			break;
		case LEFT:
			if(--tank_x==0)
			tank_x--;
			else
				return;
			break;
		case RIGHT:
			if(++tank_x==0)
			tank_x++;
			else
				return;
			break;
		case DOWN:
			if(++tank_y==0)
			tank_y++;
			else
				return;
			break;
		}
		
}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}

}
