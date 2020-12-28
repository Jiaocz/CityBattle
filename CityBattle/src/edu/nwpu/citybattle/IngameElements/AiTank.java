
package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.actions.Movable;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.awt.Component;
import javax.swing.JComponent;


import javax.imageio.ImageIO;



/**
 * �з�AI̹����
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {
	
	private int tank_x;
	private int tank_y;
	private int direction;
	private int initX;
	private int initY;
	private int HP;

	

	@Override
	public void moveNext() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub

	}

	@Override
	public Bullet shootBullet(float x, float y, int direction) {
		// TODO Auto-generated method stub
		return null;
	}


<<<<<<< HEAD
	public static final int UP = 1; // ����
	public static final int DOWN = 2; // ����
	public static final int LEFT = 3; // ����
	public static final int RIGHT = 4; // ����
	
=======
		

	public int direction;
	public static final int UP = 1; // ����
	public static final int DOWN = 2; // ����
	public static final int LEFT = 3; // ����
	public static final int RIGHT = 4; // ����
>>>>>>> branch 'master' of https://codehub.devcloud.cn-north-4.huaweicloud.com/hwxz-rjkfjcnlxl-QV_Orangii00001/CityBattle.git
		
		
		
	    public  AiTank(int tank_x,int tank_y , int direction , int HP) {
	    	
		     this.tank_x = tank_x;
		     this.tank_y = tank_y;
		     this.direction = direction;
		     
		     initX = tank_x;
		     initY = tank_y;
		     
	              }
	    
	    /**
	     * ����̹��x����
	     * @return
	     */
	    public int getTank_x() {
	    	return tank_x;
	    }

	    /**
	     * ����̹��y����
	     * @return
	     */
	    public int getTank_y() {
	    	return tank_y;
	    }
	    
		/**
		 * ����hpֵ
		 * @return
		 */
	    public int getHP() {
	    	return HP;
	    }
	    
	    /**
	     * ���ظ�̹�˳�ʼx����
	     */
	    public int getInitX() {
	    	return this.initX;
	    }
	    
	    
	    /**
	     * ���ظ�̹�˵ĳ�ʼy����
	     */
	    public int getInitY() {
	    	return this.initY;
	    }
	   
	    
	    /**
	     * ��������Ѫ��ֵ
	     */
	    public void setHP() {
	    	this.HP = 2;
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
		 * ̹�˵ĵ�ǰ����
		 */
		private int curDir = 2;
		
		
		public void setCurDir(int dir){
			this.curDir = dir;
		}
		
		public int getCurDir() {
			return curDir;
		}
		
		
		/**
		 * ̹�˵��ٶ�e
		 */
		private int speed = 10;
		
		
		/**
		 * ̹���ƶ���Ƶ��
		 */
		private int f_sleep = 500;
				
		boolean flag = true;
			
		
		/**
		 * �ƶ�
		 * @param speed
		 */
		public void move(int speed){
				switch(curDir) {
					case AiTank.DOWN:
							setBounds(tank_x, tank_y+speed,getWidth(), getHeight());
						break;
					case AiTank.LEFT:
							setBounds(tank_x-speed, tank_y, getWidth(), getHeight());
						break;
					case AiTank.RIGHT:
							setBounds(tank_x+speed, tank_y, getWidth(), getHeight());
						break;
					case AiTank.UP:
							setBounds(tank_x, tank_y-speed, getWidth(), getHeight());
						break;
				}
		}
		
		/**
		 * �����ڵ�
		 */
		public void shell(){
					String direction = null;
					switch(curDir){
						case AiTank.DOWN:
							direction = "DOWN";
							break;
						case AiTank.LEFT:
							direction = "LEFT";
							break;
						case AiTank.RIGHT:
							direction = "RIGHT";
							break;
						case AiTank.UP:
							direction = "UP";
							break;
							}
					}
					
					
		/**
		 * 
		 */
		public void run(){
			Random rd = new Random();
			while(flag){
				int key = Math.abs(rd.nextInt())%6;
					switch(key){
						case 0:
						case 1:
						case 2:
							if(getCurDir()==AiTank.DOWN) move(speed);
							break;
						case 3://��ǰ�����ƶ�
							move(speed);
							break;
						case 4://ת��
							int dir = Math.abs(rd.nextInt())%4 + 1;
							if(dir == getCurDir()){
								move(speed);
								break;
							}
							String dirStr = null;
							switch(dir){
								case 1:
									dirStr = "UP";
									break;
								case 2:
									dirStr = "DOWN";
									break;
								case 3:
									dirStr = "LEFT";
									break;
								case 4:
									dirStr = "RIGHT";
									break;
							}
							break;
						default://���ֲ���
							key = Math.abs(rd.nextInt())%100;
							if(key % 5 ==0)
								shell();//�����ڵ�
							break;
					}
					try {
						Thread.sleep(f_sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}



	}

