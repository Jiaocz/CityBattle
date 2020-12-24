/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * 任何可以射击子弹的类应实现此接口，并在泛型中指定子弹类型。<br />
 * 如果有多种子弹类型，建议使用父类或再改写此接口。<br />
 * 射击子弹应传入子弹位置和方向.
 * @author Orangii
 * @version 1.0.0
 */
public interface CanShootBullet<Bullet> {
	
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
	 * 产生子弹的函数，完善此方法后，应实现传入坐标x，y和方向后生成一个子弹对象
	 * @param x 子弹初始x坐标
	 * @param y 子弹初始y坐标
	 * @param direction 子弹发射方向，建议使用常量{@code UP DOWN LEFT RIGHT}
	 * @return 子弹对象
	 * @since 1.0.0
	 * @version 1.0.0
	 */
	Bullet shootBullet(float x, float y, int direction);
}
