/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

/**
 * ��û����Ϸ���ݹ��ӵ��㷨��{@code BulletAlogrism}���м���ʱ���佫�׳����쳣
 * 
 * @author Orangii
 * @version 1.0.0
 */
public class NoGameDataException extends Exception {

	/**
	 * {@code Exception}����Ҫ��serial�������ڴ�������һ����
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
