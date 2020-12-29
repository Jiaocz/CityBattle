package edu.nwpu.citybattle.IngameElements;

import java.util.Random;


import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.actions.Movable;



/**
 * 
 * @version 1.0.0
 * @see Tank
 */
public class AiTank extends Tank implements Movable {
	
	private int initX;
	private int initY;
	
	
	private int speed = 5;
	
	// 坦克的宽
	private int width = 40;
	// 坦克的高
	private int height = 40;

	

	@Override
	public void moveNext() {
		while(judgeLimit()) {

			if (direction == 2) {
				tank_y += speed;
				setRandomDir();
			}
			if (direction == 1) {
				tank_y -= speed;
				setRandomDir();
			}
			if (direction == 3) {
				tank_x -= speed;
				setRandomDir();
			}
			if (direction == 4) {
				tank_x += speed;
				setRandomDir();
			}
		}
	}
	

	@Override
	public void onHit() {
		HP--;
	}
	
	//判断是否能行走
	private boolean judgeLimit(){
		if(tank_x<0){
			tank_x=0;
			return true;
		}
		if(tank_y<0){
			tank_y=0;
			return true;
		}
		switch(direction) {
		case UP:
			if((Map.grass[tank_x][tank_y]!=0) && (Map.ironwall[tank_x][tank_y]!=0)&&(Map.wall[tank_x][tank_y]!=0)&&(Map.water[tank_x][tank_y]!=0)) {
				tank_y++;
				return true;
			}
			
		case DOWN:
			if((Map.grass[tank_x][tank_y]!=0) && (Map.ironwall[tank_x][tank_y]!=0)&&(Map.wall[tank_x][tank_y]!=0)&&(Map.water[tank_x][tank_y]!=0)) {
				tank_y--;
			    return true;
		    }
		case LEFT:
			if((Map.grass[tank_x][tank_y]!=0) && (Map.ironwall[tank_x][tank_y]!=0)&&(Map.wall[tank_x][tank_y]!=0)&&(Map.water[tank_x][tank_y]!=0)) {
				tank_x++;
				return true;
			}
		case RIGHT:
			if((Map.grass[tank_x][tank_y]!=0) && (Map.ironwall[tank_x][tank_y]!=0)&&(Map.wall[tank_x][tank_y]!=0)&&(Map.water[tank_x][tank_y]!=0)) {
				tank_x--;
				return true;
			}
		default:
			return false;
		
		}


	}
	
	

	public Bullet shootBullet() {
		int x = this.tank_x+2;
		int y = this.tank_y+2;
		int direction = this.direction;
		
		return new Bullet(x,y,direction);
	}

	boolean f = false;

	
	//为敌方坦克设置移动的方向
	private void setRandomDir() {
		while(f = false) {
		int r = new Random().nextInt(5);
		switch(r) {
		case 1:{
			direction = 1;
			f = true;
			}
		case 2:{
			direction = 2;			
			f = true;
		    }
		case 3:{
			direction = 3;
			f = true;
			}
		case 4:{
			direction = 4;
			f = true;
		}
		default:
			f = false; 
		
		}
		
		}
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

