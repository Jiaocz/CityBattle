/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * �κο�������ӵ�����Ӧʵ�ִ˽ӿڣ����ڷ�����ָ���ӵ����͡�<br />
 * ����ж����ӵ����ͣ�����ʹ�ø�����ٸ�д�˽ӿڡ�<br />
 * ����ӵ�Ӧ�����ӵ�λ�úͷ���.
 * 
 * @author Orangii
 * @version 1.0.0
 */
public interface CanShootBullet<Bullet> {

	/**
	 * ���ڱ�ʾ���ϲ����ӵ�
	 * 
	 * @since 1.0.0
	 */
	static final int UP = 1;
	/**
	 * ���ڱ�ʾ���²����ӵ�
	 * 
	 * @since 1.0.0
	 */
	static final int DOWN = 2;
	/**
	 * ���ڱ�ʾ��������ӵ�
	 * 
	 * @since 1.0.0
	 */
	static final int LEFT = 3;
	/**
	 * ���ڱ�ʾ���Ҳ����ӵ�
	 * 
	 * @since 1.0.0
	 */
	static final int RIGHT = 4;

	/**
	 * �����ӵ��ĺ��������ƴ˷�����Ӧʵ�ִ�������x��y�ͷ��������һ���ӵ�����
	 * 
	 * @return �ӵ�����
	 * @since 1.0.0
	 * @version 1.0.0
	 */
	Bullet shootBullet();
}
