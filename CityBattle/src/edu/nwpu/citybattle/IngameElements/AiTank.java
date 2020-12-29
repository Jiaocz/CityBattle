
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
	//�ƶ��Ĳ���
	private int step;
	
	private int speed = 5;
	
	// ̹�˵Ŀ�
	private int width = 40;
	// ̹�˵ĸ�
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

				//�ƶ��Ĳ���Ϊ0ʱ  ���¸�ֵ
				if(step==0||judgeLimit()){
					step=r.nextInt(20);
					setRandomDir();
				}
				//������һ
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
	
	//�жϱ߽�
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
	
	//Ϊ�з�̹�������ƶ��ķ���
	private void setRandomDir() {
		Direction[] ranDir = { Direction.UP, Direction.DOWN, Direction.LEFT,
				Direction.RIGHT };
		curDir = ranDir[r.nextInt(ranDir.length)];
	}

	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT, STOP
	}

	public static final int UP = 1; // ����
	public static final int DOWN = 2; // ����
	public static final int LEFT = 3; // ����
	public static final int RIGHT = 4; // ����

		
		
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

