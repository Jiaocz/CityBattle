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
	 * ��ʼ����̹�˵����꣬������̹�����������ɵ��µ�AiTank
	 */
	private int initX;
	private int initY;
	
	/**
	 * ̹�˵��ٶ�
	 */
	private int speed = 1;

	/**
	 * ̹�˵Ŀ���
	 */
	private int width = 3;
	private int height = 3;
	public MyTank() {
		this.tank_y = 36;
		this.tank_x = 20;
	}
	/**
	 * ���ú�������̹�˳�������м������ӵ�
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
	 * �������������,�ж��Ƿ�����ƶ�
	 * @param direction
	 * @return
	 */
	
	public int ReadLine(int direction) {
		int i;
		int x=tank_x;
		int y=tank_y;
		switch(direction) {
	//�ϵ����
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
	//������			
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
	//�ҵ����		
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
	//�µ����		
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
	 * ̹���ж��Ƿ�����ƶ���������Ӧ��ָ��
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
	 * �����к�̹�˵�Ѫ������
	 */
	public void onHit() {
		HP--;
	}
	
	/**
	 * ��ȡ��ǰѪ��
	 */
	public int getHP() {
		return HP;
	}
	
	/**
	 * ��ȡ̹�˵�λ��
	 * @return
	 */
	public int getTank_X() {
		return tank_x;
	}
	public int getTank_Y() {
		return tank_y;
	}
	
	/**
	 * ���ó�ʼѪ��
	 */
	public void setHP() {
		this.HP = 3;
	}
	
	/**
	 * ���ص�ǰX����
	 * @param x
	 */
	public void setTank_x(int x) {
		this.tank_x = x;
	}

	/**
	 * ���ص�ǰ��Y����
	 * @param y
	 */
	public void setTank_y(int y) {
		this.tank_y = y;
	}
	
	/**
	 * ��ʼ��ԭX����
	 * @param x
	 */
	public void setInitX(int x) {
		this.initX = x;
	}

	/**
	 * ��ʼ��ԭY����
	 * @param y
	 */
	public void setInitY(int y) {
		this.initY = y;
	}

}