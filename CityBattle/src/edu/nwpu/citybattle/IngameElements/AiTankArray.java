
package edu.nwpu.citybattle.IngameElements;
import edu.nwpu.citybattle.IngameElements.AiTank;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 本类使用数组维护游戏内的AI坦克
 * @see AiTank
 * @see java.util.ArrayList
 * @version 1.0.0
 */
public class AiTankArray {
	public static final ArrayList<AiTank> aiTank = new ArrayList<AiTank>();
	Iterator aiTanks = aiTank.iterator();
	
	
	/**
	 * 如果检测到有死亡的坦克，则在此基础上在该坦克的起始位置重新生成一个坦克
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
	 * 去除已经死亡的坦克
	 */
	public void deadAiTank() {
		aiTanks.remove();
	}
}
