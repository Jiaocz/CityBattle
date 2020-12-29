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
 * 定时器类，通过将任务挂载到本计时器，实现任务的定时执行。<br />
 * {@code Movable}及{@code CronJob}接口均可以挂在到本计时器下，实现任务的自动执行。<br />
 * 计时器的最小执行时间是游戏设定的刷新率，因为这个值没有静态类保存，在这里我定义为30FPS，<br />
 * 最小执行间隔时间为 1/30s ，小于改值的任务也会使用此时间间隔作为任务间的间隔。<br />
 * <hr />
 * 最简单的，您可以直接将您的{@code Movable}接口使用{@code addJob(Movable)}方法添加进本定时器，本定时器将在每帧执行这些任务，<br
 * />
 * 如果您有一个{@code List}容器存储这些{@code Movable}接口，您还可以通过{@code addJobs(List<Movable>)}方法批量添加这些任务。<br
 * />
 * <hr />
 * 如果您还有其他希望定时执行的任务，您可以在任务类中实现{@code CronJob}或者{@code Runnable接口}，并且通过{@code addJob(Runnable, Interval)}方法添加一个自定义时间间隔的定时任务。<br
 * />
 * 如果您仅仅是想要添加一个简单的计划执行任务，您可以使用匿名内部类来完成这个任务，如以下示例<br />
 * <code><pre>
 * CronJobSet.addJob(new CronJob() {
 * 		public void run() {
 * 			System.out.println("Now Time: " + System.currentTimeMillis());
 * 		}
 * }, 1000);
 * CronJobSet.startCronJob();
 * </pre></code><br />
 * 以上示例展示了一个简单的添加匿名内部类的方法，并开始执行计时器。<br />
 * <b>注意：匿名内部类不被推荐，因为他们无法通过{@code removeJob()}方法删除</b>示例运行效果可以直接运行此类来观看。
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
	// 定时任务列表
	private static ArrayList<Runnable> CronJobs = new ArrayList<Runnable>();
	private static ArrayList<Movable> Moves = new ArrayList<Movable>();

	// 任务时间设定
	private static ArrayList<Long> CronJobsInterval = new ArrayList<Long>();
	private static int FPS = 30;
	private static int FreshRate = 1000 / FPS;

	// 上次执行时间
	private static ArrayList<Long> CronJobsLast = new ArrayList<Long>();
	private static ArrayList<Long> MovesLast = new ArrayList<Long>();

	// 定时器本体
	private static Timer timer = new Timer();
	private static TimerTask crons = new CronJobSet();

	/**
	 * 开始定时器，启动定时任务，每半帧游戏进行一次运行（每frame）
	 * 
	 * @since 1.0.0
	 */
	public static void startCronJob() {
		timer.schedule(crons, 0, FreshRate);
	}

	/**
	 * 结束定时器<br />
	 * 其实在内部就是吧定时器取消掉并清除所有任务，但是现实中任务是不会被清掉的我自己有保存。
	 * 
	 * @since 1.0.0
	 */
	public static void stopCronJob() {
		timer.cancel();
		timer.purge();
	}

	/**
	 * 手动执行一次计划任务<br />
	 * 注意：手动执行也受任务间隔限制，如果有任务未到执行时间仍然不会被执行。
	 * 
	 * @since 1.0.0
	 */
	public static void manualRun() {
		crons.run();
	}

	/**
	 * 增加一个{@code CronJob}接口类型的定时任务，增加对{@code Runnable}接口的支持
	 * 
	 * @since 1.0.0
	 * @param cronJobs 需要添加的任务
	 * @param interval 任务执行间隔
	 * @return 添加成功与否
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
	 * 增加一个Movable接口类型的定时任务
	 * 
	 * @since 1.0.0
	 * @param cronJobs 需要添加的任务
	 * @return 添加成功与否
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
	 * 通过{@code List}表添加一系列{@code Movable}接口类型的定时事件
	 * 
	 * @since 1.0.0
	 * @param CronJobList {@code Movable}接口事件集
	 * @return 是否添加成功
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
	 * 通过{@code Set}表添加一系列{@code Movable}接口类型的定时事件
	 * 
	 * @since 1.1.2
	 * @param CronJobList {@code Movable}接口Set集
	 * @return 是否添加成功
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
	 * 通过指定任务删除一个定时任务。
	 * 
	 * @since 1.0.0
	 * @param cronJob 需要删除的任务
	 * @return 删除是否成功
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
	 * 通过指定任务删除一个定时任务。
	 * 
	 * @since 1.0.0
	 * @param cronJob 需要删除的任务
	 * @return 删除是否成功
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
	 * 每一帧进行一次操作，决定运行哪些函数。
	 */
	@Override
	public void run() {
		runCronJobs();
		runMovables();
	}

	// CronJob接口下的任务
	private static void runCronJobs() {
		for (int i = 0; i < CronJobs.size(); i++) {
			if (System.currentTimeMillis() - CronJobsLast.get(i) >= CronJobsInterval.get(i)) {
				CronJobsLast.set(i, System.currentTimeMillis());
				CronJobs.get(i).run();
			}
		}
	}

	// Movable接口下的任务，至少每Frame执行一次
	private static void runMovables() {
		for (int i = 0; i < Moves.size(); i++) {
			if (System.currentTimeMillis() - MovesLast.get(i) >= FreshRate) {
				MovesLast.set(i, System.currentTimeMillis());
				Moves.get(i).moveNext();
			}
		}
	}

	// 阻止自行创建对象
	private CronJobSet() {}

	/**
	 * 测试用main方法，请勿使用<br />
	 * 当然如果你想的话你可以照着学习一下
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
