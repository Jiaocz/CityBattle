/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * ����ӿ������ж϶����Ƿ��赲������̹���赲̹��<br />
 * ��ĳ������һ�������Աߵ�ʱ�����ͨ����һ�������{@code canBlock()}���жϵ�ǰ�����Ƿ����ͨ��<br />
 * �ýӿ�Ҳ���ᱻ�õ���
 * 
 * @author Orangii
 * @version 1.0.0
 * @deprecated
 */
public interface Blockable {
	/**
	 * ���ڱ�ʾ̹��
	 * 
	 * @since 1.0.0
	 */
	static final int TANK = 1;
	/**
	 * ���ڱ�ʾ��ƺ
	 * 
	 * @since 1.0.0
	 */
	static final int GRASS = 2;
	/**
	 * ���ڱ�ʾ��ͨǽ
	 * 
	 * @since 1.0.0
	 */
	static final int WALL = 3;
	/**
	 * ���ڱ�ʾ��ǽ
	 * 
	 * @since 1.0.0
	 */
	static final int IRON_WALL = 4;
	/**
	 * ���ڱ�ʾˮ
	 * 
	 * @since 1.0.0
	 */
	static final int WATER = 5;
	/**
	 * ���ڱ�ʾ�ӵ�
	 * 
	 * @since 1.0.0
	 */
	static final int BULLET = 6;

	/**
	 * �˷��������ù������������{@code type}���ж϶����Ƿ���Դ�����
	 * 
	 * @param type �����жϵĶ������͡�
	 * @return �Ƿ���Դ����ж϶���
	 * @since 1.0.0
	 */
	boolean canBlock(int type);
}
