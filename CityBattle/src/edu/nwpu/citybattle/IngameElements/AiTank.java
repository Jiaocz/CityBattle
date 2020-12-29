
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
 * 锟叫凤拷AI坦锟斤拷锟斤拷
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {
	
	private int initX;
	private int initY;

	

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



	public static final int UP = 1; // 向上
	public static final int DOWN = 2; // 向下
	public static final int LEFT = 3; // 向左
	public static final int RIGHT = 4; // 向右

		
		
	    public  AiTank(int tank_x,int tank_y , int direction , int HP) {
	    	
		     this.tank_x = tank_x;
		     this.tank_y = tank_y;
		     this.direction = direction;
		     
		     initX = tank_x;
		     initY = tank_y;
		     
	              }
	    
	    /**
	     * 返回坦克x坐标
	     * @return
	     */
	    public int getTank_x() {
	    	return tank_x;
	    }

	    /**
	     * 返回坦克y坐标
	     * @return
	     */
	    public int getTank_y() {
	    	return tank_y;
	    }
	    
		/**
		 * 返回hp值
		 * @return
		 */
	    public int getHP() {
	    	return HP;
	    }
	    
	    /**
	     * 返回该坦克初始x坐标
	     */
	    public int getInitX() {
	    	return this.initX;
	    }
	    
	    
	    /**
	     * 返回该坦克的初始y坐标
	     */
	    public int getInitY() {
	    	return this.initY;
	    }
	   
	    
	    /**
	     * 重新设置血量值
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
		 * 
		 */
		private int curDir = 2;
		
		
		public void setCurDir(int dir){
			this.curDir = dir;
		}
		
		public int getCurDir() {
			return curDir;
		}
		
		
		/**
		 * 
		 */
		private int speed = 10;
		
		
		/**
		 * 
		 */
		private int f_sleep = 500;
				
		boolean flag = true;
			
		
		/**
		 * 
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
						case 3:
							move(speed);
							break;
						case 4:
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
						default:
							key = Math.abs(rd.nextInt())%100;
							if(key % 5 ==0)
								shell();
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

