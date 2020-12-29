
package edu.nwpu.citybattle.IngameElements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.awt.Component;
import javax.swing.JComponent;

import edu.nwpu.citybattle.TankMap.map1;
import edu.nwpu.citybattle.TankMap.map2;
import tankWar.Tank;
import tankWar.TankClient;

import javax.imageio.ImageIO;



/**
 * 
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {
	
	private int initX;
	private int initY;
	//移动的步数
	private int step;
	
	private int speed = 5;
	
	// 坦克的宽
	private int width = 40;
	// 坦克的高
	private int height = 40;

	

	@Override
	public void moveNext() {
		// TODO Auto-generated method stub
		
			if (curDir == Direction.DOWN) {
				tank_y += speed;
			}
			if (curDir == Direction.UP) {
				tank_y -= speed;
			}
			if (curDir == Direction.LEFT) {
				tank_x -= speed;
			}
			if (curDir == Direction.RIGHT) {
				tank_x += speed;
			}

				//移动的步数为0时  重新赋值
				if(step==0||judgeLimit()){
					step=r.nextInt(20);
					setRandomDir();
				}
				//步数减一
				else{
					step--;
				}
				if(r.nextInt(100)>97){
					shootBullet(tank_x,tank_y,direction);
				}

	}
	

	@Override
	public void onHit() {
		HP--;
	}
	
	//判断边界
	private boolean judgeLimit(){
		if(tank_x<0){
			tank_x=0;
			return true;
		}
		if(tank_y<0){
			tank_y=0;
			return true;
		}

		if((Map.grass[tank_x][tank_y]!=0) && (Map.ironwall[tank_x][tank_y]!=0)&&(Map.wall[tank_x][tank_y]!=0)&&(Map.water[tank_x][tank_y]!=0)) {
			tank_x = tank_x -1;
			return true;
		}


	}
	
	
	
	
	

	@Override
	public Bullet shootBullet(float x, float y, int direction) {
		// TODO Auto-generated method stub
		x = this.tank_x+2;
		y = this.tank_y+2;
		direction = this.direction;
		
		Bullet.Bullets.add(shootBullet(x,y,direction) );
		
		return null;
	}

	private Direction curDir = Direction.DOWN;
	
	
	Random r = new Random();
	
	//为敌方坦克设置移动的方向
	private void setRandomDir() {
		Direction[] ranDir = { Direction.UP, Direction.DOWN, Direction.LEFT,
				Direction.RIGHT };
		curDir = ranDir[r.nextInt(ranDir.length)];
	}

	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT, STOP
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
	    
		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	    

	}

