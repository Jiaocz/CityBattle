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
	
	/**
	 * �����⵽��������̹�ˣ����ڴ˻������ڸ�̹�˵���ʼλ����������һ��̹��
	 */
	public void addAiTank() {	 
		Iterator aiTanks = aiTank.iterator();
		 while(aiTanks.hasNext()) {
			 AiTank a = (AiTank)aiTanks.next();
			 AiTank coppya = null;
			 if(a.getHP() == 0) {	
		
				coppya.setHP();				
				coppya.setTank_x(a.getInitX());
				coppya.setTank_y(a.getInitY());	
				coppya.setInitX(a.getInitX());
				coppya.setInitY(a.getInitY());
				
				aiTank.add(coppya);
				aiTank.remove(a);
				
			}
		 }	
		
	}

	
}
