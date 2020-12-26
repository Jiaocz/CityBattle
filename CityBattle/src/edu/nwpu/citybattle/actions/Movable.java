/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * ����ӿ����ڶ�ʱ��ˢ��ʱ�Կ��ƶ�Ŀ�����λ�����Ը���<br />
 * ÿ�ζ�ʱ����ʱ��ִ��ʱ�����Ŀ������{@code moveNext()}����<br />
 * ʵ�ָýӿڵ���Ӧ�����ƴ˷�����ʹ���ܸ��¶����λ�����ԣ��������ڻ���ʱ����λ�á�<br />
 * ����ԭ��ɲ鿴{@code CronJobSet}��
 * 
 * @author Orangii
 * @version 1.0.1
 * @see edu.nwpu.citybattle.alogrism.CronJobSet
 */
public interface Movable {
	/**
	 * ���ڱ�ʾ���ϲ����ӵ�
	 * @since 1.0.0
	 */
	static final int UP = 1;
	/**
	 * ���ڱ�ʾ���²����ӵ�
	 * @since 1.0.0
	 */
	static final int DOWN = 2;
	/**
	 * ���ڱ�ʾ��������ӵ�
	 * @since 1.0.0
	 */
	static final int LEFT = 3;
	/**
	 * ���ڱ�ʾ���Ҳ����ӵ�
	 * @since 1.0.0
	 */
	static final int RIGHT = 4;
	
	/**
	 * ���������ڶ�ʱ�����е��ã�ʵ�ַ���ʱӦ����ɶԶ���λ�����Խ��и���<br />
	 * λ������Ӧ�ڶ�������ɣ���ʵ����Ⱦʱ����λ�õĸ��¡�
	 * @since 1.0.0
	 */
	void moveNext();
}
