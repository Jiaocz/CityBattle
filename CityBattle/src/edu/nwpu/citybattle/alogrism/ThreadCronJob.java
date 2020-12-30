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
 * ���߳��࣬��Ϊ�����̣߳��ӵ��̡߳�̹���̺߳͵�ͼˢ���̡߳�<br />
 * 
 * @author Orangii
 * @version 1.0.2
 * @see Runnable
 * @see CronJob
 * @see CronJobSet
 */
public final class ThreadCronJob extends CronJobSet {
	// �ӵ��̴߳洢��
	private static class BulletThread extends Thread {
		// ���ڳ���ִ�жԵĶ�ʱ��
		private class Running extends TimerTask {
			@Override
			public void run() {
				for(int i = 0; i < bullets.size(); i++) {
					bullets.get(i).moveNext();
				}
			}
			
		}
		// ��Ҫִ�еĶ���
		public static ArrayList<Movable> bullets = new ArrayList<Movable>();
		public static Timer timer = new Timer();
		
		@Override
		public void run() {
			timer.schedule(new Running(), 0, FreshRate);
		}
	}
	// ̹���̴߳洢��
	private static class TankThread extends Thread {
		// ��Ҫִ�еĶ���
		public static ArrayList<Movable> tanks = new ArrayList<Movable>();
		public static ArrayList<Long> tanks_last = new ArrayList<Long>();
		public static Timer timer = new Timer();
		// ��ʱ�õ���
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
		// ��ʱִ��
		@Override
		public void run() {
			timer.schedule(new Running(), 0, FreshRate);
		}
	}
	// ��ͼˢ���߳�
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
	 * ���̹�˻��ӵ����̣߳��Ŷ�ֱ����ӾͿ���
	 * 
	 * @param cronJob	̹�˻��ӵ�����
	 * @return	�Ƿ���ӳɹ�
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
	 * ��ӵ�ͼˢ���̣߳�����{@code Runnable}�ӿ������ڲ������ʵ��{@code Runnable}��{@code CronJob}�ӿ�
	 * 
	 * @param cronJob	��ͼִ�з���
	 * @return	����Ƿ�ɹ���ʵ���ϲ�����ʧ�ܣ�
	 * @since 1.0.0
	 */
	public static boolean addJob(Runnable cronJob) {
		MapThread.map = cronJob;
		MapThread.lastTime = System.currentTimeMillis();
		return true;
	}
	
	/**
	 * ͨ��{@code Movable}�ӿ�ɾ����ʱ����
	 * 
	 * @param cronJob	��Ҫɾ��������
	 * @return	ɾ���Ƿ�ɹ�
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
	
	// �����߳�
	private static Thread bullet = new BulletThread();
	private static Thread tank = new TankThread();
	private static Thread map = new MapThread();
	
	/**
	 * ���������̣߳��Ѿ������Ĳ�����������
	 * 
	 * @since 1.0.0
	 */
	public static void start() {
		if(bullet.getState() == Thread.State.NEW) bullet.start();
		if(tank.getState() == Thread.State.NEW) tank.start();
		if(map.getState() == Thread.State.NEW) map.start();
	}
	
	/**
	 * ǿ��ֹͣ�����̣߳�������ɰ�ȫ���⡣
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
