
package edu.nwpu.citybattle.IngameElements;
import edu.nwpu.citybattle.IngameElements.AiTank;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * ����ʹ������ά����Ϸ�ڵ�AI̹��
 * @see AiTank
 * @see java.util.ArrayList
 * @version 1.0.0
 */
public class AiTankArray {
	public static final ArrayList<AiTank> aiTank = new ArrayList<AiTank>();
	Iterator aiTanks = aiTank.iterator();
	
	
	/**
	 * �����⵽��������̹�ˣ����ڴ˻������ڸ�̹�˵���ʼλ����������һ��̹��
	 */
	public void addAiTank() {	 
		 while(aiTanks.hasNext()) {
			if(aiTanks.getHP() == 0) {
				aiTank.add((AiTank) aiTanks.next());
				deadAiTank();
			}
		 
		 }	
		
	}
	
	/**
	 * ȥ���Ѿ�������̹��
	 */
	public void deadAiTank() {
		aiTanks.remove();
	}
}
