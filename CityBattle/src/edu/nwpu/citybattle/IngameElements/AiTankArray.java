package edu.nwpu.citybattle.IngameElements;

import edu.nwpu.citybattle.IngameElements.AiTank;

import java.util.ArrayList;
import java.util.Iterator;

import UI.Choice;

/**
 * 本类使用数组维护游戏内的AI坦克
 * 
 * @see AiTank
 * @see java.util.ArrayList
 * @version 1.0.0
 */
public class AiTankArray {

	public static final ArrayList<AiTank> aiTank = new ArrayList<AiTank>();

	/**
	 *按地图绘制AiTank
	 */
	public static void choice() {
		if(Choice.mapNumber == 1) {
			new AiTank(15,20,Tank.DOWN,3);
			new AiTank(35,1,Tank.RIGHT,3);
			new AiTank(4,20,Tank.DOWN,3);
		}
		
		if(Choice.mapNumber == 2) {
			new AiTank(20,1,Tank.RIGHT,3);
			new AiTank(50,1,Tank.DOWN,3);
			new AiTank(50,29,Tank.DOWN,3);
			new AiTank(1,30,Tank.DOWN,3);
		}
		
		if(Choice.mapNumber == 3) {
			new AiTank(1,1,Tank.DOWN,3);
			new AiTank(50,1,Tank.RIGHT,3);
			new AiTank(1,20,Tank.DOWN,3);
			new AiTank(1,27,Tank.DOWN,3);
			new AiTank(50,35,Tank.DOWN,3);
		}
		
		if(Choice.mapNumber == 4) {
			new AiTank(1,1,Tank.RIGHT,3);
			new AiTank(40,1,Tank.RIGHT,3);
			new AiTank(1,27,Tank.DOWN,3);
			new AiTank(52,18,Tank.DOWN,3);
			new AiTank(13,8,Tank.DOWN,3);
		}
	
	}
}
