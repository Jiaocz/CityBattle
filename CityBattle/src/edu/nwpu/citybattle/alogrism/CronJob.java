/**
 * 
 */
package edu.nwpu.citybattle.alogrism;

/**
 * �������Ҫ�ڶ�ʱ��{@code CronJobSet}���������������ô��Ӧ��ʵ�ֱ��ӿ�<br />
 * ����������ʹ�������ڲ�����д�����ʱ����<br />
 * �������Ҫ���������ڲ��࣬��ô�Ǹ���Ҳ֧�ֺܶ����<br />
 * ��ʱ�����Զ�����{@code run()}����<br />
 * ����ʹ�������Կ�{@code CronJobSet}������ļ�����Ӷ�ʱ���ķ���
 * 
 * @author Orangii
 * @version 1.0.0
 * @see CronJobSet
 */
public interface CronJob extends Runnable {
	/**
	 * �ڱ������и�д��Ҫ��ʱ���е�����<br />
	 * ��������������Ļˢ�¡��з�̹���˶����ӵ�ײ���ж��ȡ�<br />
	 * ����ʹ�������Կ�{@code CronJobSet}������ļ�����Ӷ�ʱ���ķ���
	 * 
	 * @since 1.0.0
	 */
	void run();
}
