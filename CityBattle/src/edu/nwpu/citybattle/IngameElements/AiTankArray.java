package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.IngameElements.AiTank;

import java.util.ArrayList;
import java.util.Iterator;

import UI.Choice;

/**
 * ����ʹ������ά����Ϸ�ڵ�AI̹��
 * 
 * @see AiTank
 * @see java.util.ArrayList
 * @version 1.0.0
 */
public class AiTankArray {

	public static final ArrayList<AiTank> aiTank = new ArrayList<AiTank>();

	/**
	 * �����⵽��������̹�ˣ����ڴ˻������ڸ�̹�˵���ʼλ����������һ��̹��
	 */
	public void choice() {
		if(Choice.mapNumber == 1) {
			new AiTank(1,30,Tank.RIGHT,3);
		}
	}
}
