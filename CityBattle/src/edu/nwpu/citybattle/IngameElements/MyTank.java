/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.TankMap.*;
/**
 * ����̹���࣬����ҿ���
 * @see Tank
 * @version 1.0.0
 */
public class MyTank extends Tank {
	/**
	 * ���ú�������̹�˳�������м������ӵ�
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
	 * �������������,�ж��Ƿ�����ƶ�
	 * @param direction
	 * @return
	 */
	
	public int readLine(int direction) {
		int i;
		switch(direction) {
	//�ϵ����
		case UP:
			for(i=0;i<5;i++) {
				tank_x=tank_x+i;
				if(Map.wall[tank_x][tank_y-1]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//������			
		case LEFT:
			for(i=0;i<5;i++) {
				tank_y=tank_y+i;
				if(Map.wall[tank_x-1][tank_y]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//�ҵ����		
		case RIGHT:
			for(i=0;i<5;i++) {
				tank_y=tank_y+i;
				if(Map.wall[tank_x+5][tank_y]!=0)
					break;
				}
			if(i!=5)
				direction =0;
			break;
	//�µ����		
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
	 * ̹���ж��Ƿ�����ƶ���������Ӧ��ָ��
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
	 * �����к�̹�˵�Ѫ������
	 */
	@Override
	public void onHit() {
		HP--;
	}

}
