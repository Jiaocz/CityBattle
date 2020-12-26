/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * 这个接口用于定时器刷新时对可移动目标进行位置属性更新<br />
 * 每次定时任务定时器执行时会调用目标对象的{@code moveNext()}方法<br />
 * 实现该接口的类应该完善此方法，使其能更新对象的位置属性，让其能在绘制时更改位置。<br />
 * 具体原理可查看{@code CronJobSet}类
 * 
 * @author Orangii
 * @version 1.0.1
 * @see edu.nwpu.citybattle.alogrism.CronJobSet
 */
public interface Movable {
	/**
	 * 用于表示向上产生子弹
	 * @since 1.0.0
	 */
	static final int UP = 1;
	/**
	 * 用于表示向下产生子弹
	 * @since 1.0.0
	 */
	static final int DOWN = 2;
	/**
	 * 用于表示向左产生子弹
	 * @since 1.0.0
	 */
	static final int LEFT = 3;
	/**
	 * 用于表示向右产生子弹
	 * @since 1.0.0
	 */
	static final int RIGHT = 4;
	
	/**
	 * 本方法将在定时任务中调用，实现方法时应当完成对对象位置属性进行更新<br />
	 * 位置属性应在对象内完成，以实现渲染时对象位置的更新。
	 * @since 1.0.0
	 */
	void moveNext();
}
