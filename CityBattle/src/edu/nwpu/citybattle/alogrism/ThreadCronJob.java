/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
	private static class BulletThread extends Thread {
		// 用于持续执行对的定时类
		private class Running extends TimerTask {
			@Override
			public void run() {
				for(int i = 0; i < bullets.size(); i++) {
					bullets.get(i).moveNext();
				}
			}
			
		}
		// 需要执行的对象
		public static ArrayList<Movable> bullets = new ArrayList<Movable>();
		public static Timer timer = new Timer();
		
		@Override
		public void run() {
			timer.schedule(new Running(), 0, FreshRate);
		}
	}
	// 坦克线程存储类
	private static class TankThread extends Thread {
		// 需要执行的对象
		public static ArrayList<Movable> tanks = new ArrayList<Movable>();
		public static ArrayList<Long> tanks_last = new ArrayList<Long>();
		public static Timer timer = new Timer();
		// 定时用的类
		private class Running extends TimerTask {
			@Override
			public void run() {
				for(int i = 0; i < tanks.size(); i++) {
					if(System.currentTimeMillis() - tanks_last.get(i) >= 2 * FreshRate) {
						tanks_last.set(i, System.currentTimeMillis());
						tanks.get(i).moveNext();
					}
				}
			}
		}
		// 定时执行
		@Override
		public void run() {
			timer.schedule(new Running(), 0, FreshRate);
		}
	}
	// 地图刷新线程
	private static class MapThread extends Thread {
		
		public static Runnable map;
		public static Long lastTime;
		public static Timer timer = new Timer();
		
		private class Running extends TimerTask {
			@Override
			public void run() {
				if(map != null && System.currentTimeMillis() - lastTime >= FreshRate) {
					lastTime = System.currentTimeMillis();
					map.run();
				}
			}
		}
		
		@Override
		public void run() {
			timer.schedule(new Running(), 0, FreshRate);
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
	private static Thread bullet = new BulletThread();
	private static Thread tank = new TankThread();
	private static Thread map = new MapThread();
	
	/**
	 * 启动三个线程，已经启动的并不会启动。
	 * 
	 * @since 1.0.0
	 */
	public static void start() {
		if(bullet.getState() == Thread.State.NEW) bullet.start();
		if(tank.getState() == Thread.State.NEW) tank.start();
		if(map.getState() == Thread.State.NEW) map.start();
	}
	
	/**
	 * 强制停止三个线程，可能造成安全问题。
	 * 
	 * @since 1.0.0
	 * @deprecated
	 */
	public static void stop() {
		BulletThread.timer.cancel();
		BulletThread.timer.purge();
		bullet.stop();
		
		TankThread.timer.cancel();
		TankThread.timer.purge();
		tank.stop();
		
		MapThread.timer.cancel();
		MapThread.timer.purge();
		map.stop();
	}
	
	public static void main(String[] args) {
		ThreadCronJob.start();
	}
	
}
