/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

/**
 * 当没有游戏数据供子弹算法类{@code BulletAlogrism}进行计算时，其将抛出本异常
 * 
 * @author Orangii
 * @version 1.0.0
 */
public class NoGameDataException extends Exception {

	/**
	 * {@code Exception}类需要有serial，所以在此生成了一个。
	 */
	private static final long serialVersionUID = -56365826005599183L;

	/**
	 * Construct a Exception instance
	 * 
	 * @param Message
	 */
	public NoGameDataException(String Message) {
		super(Message);
	}
}
