/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * 此接口适用于有被打击事件的类<br />
 * 当对象被子弹击中后会调用类中的{@code onHit()}方法
 * 实现此接口的类应完善对象被击中后应产生的事件，并维护其行为
 * @author Orangii
 * @version 1.0.0
 */
public interface Hitable {
	
	/**
	 * 当子弹击中目标时会调用此事件，实现时应完成被子弹集中时对象的行为。<br />
	 * 如坦克血量减少等。
	 * @since 1.0.0
	 */
	void onHit();
}
