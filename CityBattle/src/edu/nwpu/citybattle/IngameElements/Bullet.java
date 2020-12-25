/**
 * 
 */
package edu.nwpu.citybattle.IngameElements;

import java.util.ArrayList;
import edu.nwpu.citybattle.actions.Movable;

/**
 * 本类为坦克子弹类
 * @author Orangii
 * @version 1.0.0
 * @see edu.nwpu.citybattle.alogrism.BulletAlogrism
 */
public class Bullet implements Movable{
	/**
	 * 此{@code ArrayList}维护所有场上的子弹
	 * @since 1.0.0
	 */
	public static ArrayList<Bullet> Bullets = new ArrayList<Bullet>();

	@Override
	public void moveNext() {
		// TODO Auto-generated method stub
		
	}
	
}
