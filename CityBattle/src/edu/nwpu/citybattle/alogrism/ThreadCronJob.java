/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;

import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.Tank;
import edu.nwpu.citybattle.actions.Movable;

/**
 * 多线程类，分为三个线程，子弹线程、坦克线程和地图刷新线程。<br />
 * 
 * @author Orangii
 * @version 1.0.2
 * @see Runnable
 * @see CronJob
 * @see CronJobSet
 */
public final class ThreadCronJob extends CronJobSet {
	// 子弹线程存储类
	private static class BulletThread implements Runnable {
		public static ArrayList<Movable> bullets = new ArrayList<Movable>();
		@Override
		public void run() {
			System.out.println(123123);
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
	// 坦克线程存储类
	private static class TankThread implements Runnable {
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
	// 地图刷新线程
	private static class MapThread implements Runnable {
		public static Runnable map;
		public static Long lastTime;
		@Override
		public void run() {
			if(map != null && System.currentTimeMillis() - lastTime >= FreshRate) {
				lastTime = System.currentTimeMillis();
				map.run();
			}
			try {
				Thread.sleep(FreshRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 添加坦克或子弹类线程，嗯对直接添加就可以
	 * 
	 * @param cronJob	坦克或子弹对象
	 * @return	是否添加成功
	 * @since 1.0.0
	 */
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
		else return false;
	}
	/**
	 * 添加地图刷新线程，传入{@code Runnable}接口匿名内部类或者实现{@code Runnable}或{@code CronJob}接口
	 * 
	 * @param cronJob	地图执行方法
	 * @return	添加是否成功（实际上并不会失败）
	 * @since 1.0.0
	 */
	public static boolean addJob(Runnable cronJob) {
		MapThread.map = cronJob;
		MapThread.lastTime = System.currentTimeMillis();
		return true;
	}
	
	/**
	 * 通过{@code Movable}接口删除定时任务
	 * 
	 * @param cronJob	需要删除的任务
	 * @return	删除是否成功
	 * @since 1.0.2
	 */
	public static boolean removeJob(Movable cronJob) {
		if(cronJob instanceof Tank) {
			if(TankThread.tanks.contains(cronJob)) {
				TankThread.tanks_last.remove(TankThread.tanks.indexOf(cronJob));
				TankThread.tanks.remove(cronJob);
				return true;
			}
		} else if(cronJob instanceof Bullet) {
			if(BulletThread.bullets.contains(cronJob)) {
				BulletThread.bullets.remove(cronJob);
				return true;
			}
		}
		return false;
	}
	
	// 三个线程
	private static Thread bullet = new Thread(new BulletThread(),"Bullet");
	private static Thread tank = new Thread(new TankThread(),"Bullet");
	private static Thread map = new Thread(new MapThread(),"Map");
	// 线程是否已经启动
	private static boolean bullet_started = false;
	private static boolean tank_started = false;
	private static boolean map_started = false;
	
	/**
	 * 启动三个线程，已经启动的并不会启动。
	 * 
	 * @since 1.0.0
	 */
	public static void start() {
		if(!bullet_started) {
			bullet.start();
			bullet_started = true;
		}
		
		if(!tank_started) {
			tank.start();
			tank_started = true;
		}
		
		if(!map_started) {
			map.start();
			map_started = true;
		}
		
	}
	
	/**
	 * 强制停止三个线程，可能造成安全问题。
	 * 
	 * @since 1.0.0
	 * @deprecated
	 */
	public static void stop() {
		if(bullet_started) {
			bullet.stop();
			bullet_started = false;
		}
		if(tank_started) {
			tank.stop();
			tank_started = false;
		}
		if(map_started) {
			map.stop();
			map_started = false;
		}
	}
	
}
