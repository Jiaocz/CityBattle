/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

/**
 * 如果您想要在定时器{@code CronJobSet}中增加你的任务，那么你应该实现本接口<br />
 * 或者您可以使用匿名内部类进行创建定时任务<br />
 * 如果你需要创建匿名内部类，那么那个类也支持很多操作<br />
 * 计时器会自动调用{@code run()}方法<br />
 * 具体使用您可以看{@code CronJobSet}类给出的集中添加定时器的方法
 * 
 * @author Orangii
 * @version 1.0.0
 * @see CronJobSet
 */
public interface CronJob extends Runnable {
	/**
	 * 在本方法中覆写你要定时运行的内容<br />
	 * 包括但不限于屏幕刷新、敌方坦克运动、子弹撞击判定等。<br />
	 * 具体使用您可以看{@code CronJobSet}类给出的集中添加定时器的方法
	 * 
	 * @since 1.0.0
	 */
	void run();
}
