/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * �˽ӿ��������б�����¼�����<br />
 * �������ӵ����к��������е�{@code onHit()}����
 * ʵ�ִ˽ӿڵ���Ӧ���ƶ��󱻻��к�Ӧ�������¼�����ά������Ϊ
 * @author Orangii
 * @version 1.0.0
 */
public interface Hitable {
	
	/**
	 * ���ӵ�����Ŀ��ʱ����ô��¼���ʵ��ʱӦ��ɱ��ӵ�����ʱ�������Ϊ��<br />
	 * ��̹��Ѫ�����ٵȡ�
	 * @since 1.0.0
	 */
	void onHit();
}
