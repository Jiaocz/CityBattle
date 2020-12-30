/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;

import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.Tank;
import edu.nwpu.citybattle.actions.Movable;

/**
 * @author Orangii
 *
 */
public class ThreadCronJob extends CronJobSet {
	
	static class BulletThread implements Runnable {
		public static ArrayList<Movable> bullets = new ArrayList<Movable>();
		@Override
		public void run() {
			for(int i = 0; i < bullets.size(); i++) {
				bullets.get(i).moveNext();
			}
			try {
				Thread.sleep(FreshRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class TankThread implements Runnable {
		public static ArrayList<Movable> tanks = new ArrayList<Movable>();
		public static ArrayList<Long> tanks_last = new ArrayList<Long>();
		@Override
		public void run() {
			for(int i = 0; i < tanks.size(); i++) {
				if(System.currentTimeMillis() - tanks_last.get(i) >= 2 * FreshRate) {
					tanks_last.set(i, System.currentTimeMillis());
					tanks.get(i).moveNext();
				}
			}
			try {
				Thread.sleep(FreshRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean addJob(Movable cronJob) {
		if(cronJob instanceof Bullet) {
			return BulletThread.bullets.add(cronJob);
		}
		else if(cronJob instanceof Tank) {
			if(TankThread.tanks.add(cronJob)) {
				TankThread.tanks_last.add(TankThread.tanks.indexOf(cronJob), System.currentTimeMillis());
				return true;
			}
			else return false;
		}
		else {
			return false;
		}
	}
	
	static BulletThread bulletT = new BulletThread();
	static TankThread tankT = new TankThread();
	static Thread bullet = new Thread(bulletT,"Bullet");
	static Thread tank = new Thread(tankT,"Bullet");
	static boolean bullet_started = false;
	static boolean tank_started = false;
	
	public static void start() {
		if(!bullet_started) {
			bullet.start();
			bullet_started = true;
		}
		
		if(!tank_started) {
			tank.start();
			tank_started = true;
		}
		
	}
	
	
}
