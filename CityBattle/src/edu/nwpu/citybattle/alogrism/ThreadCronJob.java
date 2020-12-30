/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;

import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.Tank;
import edu.nwpu.citybattle.actions.Movable;

/**
 * ���߳��࣬��Ϊ�����̣߳��ӵ��̡߳�̹���̺߳͵�ͼˢ���̡߳�<br />
 * 
 * @author Orangii
 * @version 1.0.0
 * @see Runnable
 * @see CronJob
 * @see CronJobSet
 */
public final class ThreadCronJob extends CronJobSet {
	// �ӵ��̴߳洢��
	private static class BulletThread implements Runnable {
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
	// ̹���̴߳洢��
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
	// ��ͼˢ���߳�
	private static class MapThread implements Runnable {
		public static Runnable map;
		public static Long lastTime;
		@Override
		public void run() {
			if(System.currentTimeMillis() - lastTime >= FreshRate) {
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
	 * ���̹�˻��ӵ����̣߳��Ŷ�ֱ����ӾͿ���
	 * 
	 * @param cronJob	̹�˻��ӵ�����
	 * @return	�Ƿ���ӳɹ�
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
	 */
	public static boolean addJob(Runnable cronJob) {
		MapThread.map = cronJob;
		MapThread.lastTime = System.currentTimeMillis();
		return true;
	}
	
	// �����߳�
	private static Thread bullet = new Thread(new BulletThread(),"Bullet");
	private static Thread tank = new Thread(new TankThread(),"Bullet");
	private static Thread map = new Thread(new MapThread(),"Map");
	// �߳��Ƿ��Ѿ�����
	private static boolean bullet_started = false;
	private static boolean tank_started = false;
	private static boolean map_started = false;
	
	/**
	 * ���������̣߳��Ѿ������Ĳ�����������
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
	 * ǿ��ֹͣ�����̣߳�������ɰ�ȫ���⡣
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
