/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import UI.CustomsPass;
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
		this.HP = 3;
	}
	/**
	 * ���ú�������̹�˳�������м������ӵ�
	 */
	public Bullet shootBullet() {
		if(direction == UP)
			return new Bullet(tank_x+1,tank_y,Bullet.UP);
		if(direction==DOWN)
			return new Bullet(tank_x+1,tank_y+1,Bullet.DOWN);
		if(direction==LEFT)
			return new Bullet(tank_x,tank_y+1,Bullet.LEFT);
		if(direction==RIGHT)
			return new Bullet(tank_x+1,tank_y+1,Bullet.RIGHT);
		
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
				if(Map.wall[x+i][y-1]!=0)
					break;
				if(Map.ironwall[x+i][y-1]!=0)
					break;
				if(Map.water[x+i][y-1]!=0)
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
				if(Map.wall[x-1][y+i]!=0)
					break;
				if(Map.ironwall[x-1][y+i]!=0)
					break;
				if(Map.water[x-1][y+i]!=0)
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
				if(Map.wall[x+3][y+i]!=0)
					break;
				if(Map.ironwall[x+3][y+i]!=0)
					break;
				if(Map.water[x+3][y+i]!=0)
					break;
				}
			if(i!=3)
				direction =0;
			break;
	//�µ����		
		case DOWN:
			if(y==38) {
				direction=0;
				break;
			}
			for(i=0;i<3;i++) {
				if(Map.wall[x+i][y+3]!=0)
					break;
				if(Map.ironwall[x+i][y+3]!=0)
					break;
				if(Map.water[x+i][y+3]!=0)
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
		if(this.HP == 0) {
			CustomsPass.isLose();
		}
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