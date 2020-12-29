/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import edu.nwpu.citybattle.actions.Movable;
import java.util.Timer;

/**
 * ��ʱ���࣬ͨ����������ص�����ʱ����ʵ������Ķ�ʱִ�С�<br />
 * {@code Movable}��{@code CronJob}�ӿھ����Թ��ڵ�����ʱ���£�ʵ��������Զ�ִ�С�<br />
 * ��ʱ������Сִ��ʱ������Ϸ�趨��ˢ���ʣ���Ϊ���ֵû�о�̬�ౣ�棬�������Ҷ���Ϊ30FPS��<br />
 * ��Сִ�м��ʱ��Ϊ 1/30s ��С�ڸ�ֵ������Ҳ��ʹ�ô�ʱ������Ϊ�����ļ����<br />
 * <hr />
 * ��򵥵ģ�������ֱ�ӽ�����{@code Movable}�ӿ�ʹ��{@code addJob(Movable)}������ӽ�����ʱ��������ʱ������ÿִ֡����Щ����<br
 * />
 * �������һ��{@code List}�����洢��Щ{@code Movable}�ӿڣ���������ͨ��{@code addJobs(List<Movable>)}�������������Щ����<br
 * />
 * <hr />
 * �������������ϣ����ʱִ�е���������������������ʵ��{@code CronJob}����{@code Runnable�ӿ�}������ͨ��{@code addJob(Runnable, Interval)}�������һ���Զ���ʱ�����Ķ�ʱ����<br
 * />
 * �������������Ҫ���һ���򵥵ļƻ�ִ������������ʹ�������ڲ���������������������ʾ��<br />
 * <code><pre>
 * CronJobSet.addJob(new CronJob() {
 * 		public void run() {
 * 			System.out.println("Now Time: " + System.currentTimeMillis());
 * 		}
 * }, 1000);
 * CronJobSet.startCronJob();
 * </pre></code><br />
 * ����ʾ��չʾ��һ���򵥵���������ڲ���ķ���������ʼִ�м�ʱ����<br />
 * <b>ע�⣺�����ڲ��಻���Ƽ�����Ϊ�����޷�ͨ��{@code removeJob()}����ɾ��</b>ʾ������Ч������ֱ�����д������ۿ���
 * <hr />
 * 
 * @author Orangii
 * @version 1.1.2
 * @see Runnable
 * @see CronJob
 * @see edu.nwpu.citybattle.actions.Movable
 * @see java.util.Timer
 * @see java.util.TimerTask
 */
public final class CronJobSet extends TimerTask {
	// ��ʱ�����б�
	private static ArrayList<Runnable> CronJobs = new ArrayList<Runnable>();
	private static ArrayList<Movable> Moves = new ArrayList<Movable>();

	// ����ʱ���趨
	private static ArrayList<Long> CronJobsInterval = new ArrayList<Long>();
	private static int FPS = 30;
	private static int FreshRate = 1000 / FPS;

	// �ϴ�ִ��ʱ��
	private static ArrayList<Long> CronJobsLast = new ArrayList<Long>();
	private static ArrayList<Long> MovesLast = new ArrayList<Long>();

	// ��ʱ������
	private static Timer timer = new Timer();
	private static TimerTask crons = new CronJobSet();

	/**
	 * ��ʼ��ʱ����������ʱ����ÿ��֡��Ϸ����һ�����У�ÿframe��
	 * 
	 * @since 1.0.0
	 */
	public static void startCronJob() {
		timer.schedule(crons, 0, FreshRate);
	}

	/**
	 * ������ʱ��<br />
	 * ��ʵ���ڲ����ǰɶ�ʱ��ȡ����������������񣬵�����ʵ�������ǲ��ᱻ��������Լ��б��档
	 * 
	 * @since 1.0.0
	 */
	public static void stopCronJob() {
		timer.cancel();
		timer.purge();
	}

	/**
	 * �ֶ�ִ��һ�μƻ�����<br />
	 * ע�⣺�ֶ�ִ��Ҳ�����������ƣ����������δ��ִ��ʱ����Ȼ���ᱻִ�С�
	 * 
	 * @since 1.0.0
	 */
	public static void manualRun() {
		crons.run();
	}

	/**
	 * ����һ��{@code CronJob}�ӿ����͵Ķ�ʱ�������Ӷ�{@code Runnable}�ӿڵ�֧��
	 * 
	 * @since 1.0.0
	 * @param cronJobs ��Ҫ��ӵ�����
	 * @param interval ����ִ�м��
	 * @return ��ӳɹ����
	 */
	public static boolean addJob(Runnable cronJobs, long interval) {
		if (CronJobs.add(cronJobs)) {
			CronJobsInterval.add(CronJobs.indexOf(cronJobs), interval);
			CronJobsLast.add(CronJobs.indexOf(cronJobs), System.currentTimeMillis());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ����һ��Movable�ӿ����͵Ķ�ʱ����
	 * 
	 * @since 1.0.0
	 * @param cronJobs ��Ҫ��ӵ�����
	 * @return ��ӳɹ����
	 */
	public static boolean addJob(Movable cronJobs) {
		if (Moves.add(cronJobs)) {
			MovesLast.add(Moves.indexOf(cronJobs), System.currentTimeMillis());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ͨ��{@code List}�����һϵ��{@code Movable}�ӿ����͵Ķ�ʱ�¼�
	 * 
	 * @since 1.0.0
	 * @param CronJobList {@code Movable}�ӿ��¼���
	 * @return �Ƿ���ӳɹ�
	 */
	public static boolean addJobs(List<Movable> CronJobList) {
		boolean status = true;
		for (Movable cronJob : CronJobList) {
			if (!addJob(cronJob)) {
				status = false;
			}
		}
		return status;
	}

	/**
	 * ͨ��{@code Set}�����һϵ��{@code Movable}�ӿ����͵Ķ�ʱ�¼�
	 * 
	 * @since 1.1.2
	 * @param CronJobList {@code Movable}�ӿ�Set��
	 * @return �Ƿ���ӳɹ�
	 */
	public static boolean addJobs(Set<Movable> CronJobList) {
		boolean status = true;
		for (Movable cronJob : CronJobList) {
			if (!addJob(cronJob)) {
				status = false;
			}
		}
		return status;
	}

	/**
	 * ͨ��ָ������ɾ��һ����ʱ����
	 * 
	 * @since 1.0.0
	 * @param cronJob ��Ҫɾ��������
	 * @return ɾ���Ƿ�ɹ�
	 */
	public static boolean removeJob(Runnable cronJob) {
		for (int i = 0; i < CronJobs.size(); i++) {
			if (cronJob.equals(CronJobs.get(i))) {
				CronJobs.remove(i);
				CronJobsInterval.remove(i);
				CronJobsLast.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * ͨ��ָ������ɾ��һ����ʱ����
	 * 
	 * @since 1.0.0
	 * @param cronJob ��Ҫɾ��������
	 * @return ɾ���Ƿ�ɹ�
	 */
	public static boolean removeJob(Movable cronJob) {
		for (int i = 0; i < Moves.size(); i++) {
			if (cronJob.equals(Moves.get(i))) {
				Moves.remove(i);
				MovesLast.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * ÿһ֡����һ�β���������������Щ������
	 */
	@Override
	public void run() {
		runCronJobs();
		runMovables();
	}

	// CronJob�ӿ��µ�����
	private static void runCronJobs() {
		for (int i = 0; i < CronJobs.size(); i++) {
			if (System.currentTimeMillis() - CronJobsLast.get(i) >= CronJobsInterval.get(i)) {
				CronJobsLast.set(i, System.currentTimeMillis());
				CronJobs.get(i).run();
			}
		}
	}

	// Movable�ӿ��µ���������ÿFrameִ��һ��
	private static void runMovables() {
		for (int i = 0; i < Moves.size(); i++) {
			if (System.currentTimeMillis() - MovesLast.get(i) >= FreshRate) {
				MovesLast.set(i, System.currentTimeMillis());
				Moves.get(i).moveNext();
			}
		}
	}

	// ��ֹ���д�������
	private CronJobSet() {}

	/**
	 * ������main����������ʹ��<br />
	 * ��Ȼ�������Ļ����������ѧϰһ��
	 * 
	 * @deprecated
	 * @param args Non-use
	 */
	public static void main(String[] args) {
		CronJobSet.addJob(new CronJob() {
			@Override
			public void run() {
				System.out.println("Now Time: " + System.currentTimeMillis());
			}
		}, 1000);
		CronJobSet.startCronJob();
		while (true);
	}

}
