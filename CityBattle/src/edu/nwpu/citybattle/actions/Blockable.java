/**
 * 
 */
package edu.nwpu.citybattle.actions;

/**
 * 这个接口用于判断对象是否被阻挡，例如坦克阻挡坦克<br />
 * 当某对象到另一个对象旁边的时候可以通过另一个对象的{@code canBlock()}来判断当前对象是否可以通过<br />
 * 该接口也许不会被用到。
 * 
 * @author Orangii
 * @version 1.0.0
 * @deprecated
 */
public interface Blockable {
	/**
	 * 用于表示坦克
	 * 
	 * @since 1.0.0
	 */
	static final int TANK = 1;
	/**
	 * 用于表示草坪
	 * 
	 * @since 1.0.0
	 */
	static final int GRASS = 2;
	/**
	 * 用于表示普通墙
	 * 
	 * @since 1.0.0
	 */
	static final int WALL = 3;
	/**
	 * 用于表示铁墙
	 * 
	 * @since 1.0.0
	 */
	static final int IRON_WALL = 4;
	/**
	 * 用于表示水
	 * 
	 * @since 1.0.0
	 */
	static final int WATER = 5;
	/**
	 * 用于表示子弹
	 * 
	 * @since 1.0.0
	 */
	static final int BULLET = 6;

	/**
	 * 此方法可以用过传入对象类型{@code type}来判断对象是否可以穿过。
	 * 
	 * @param type 发起判断的对象类型。
	 * @return 是否可以穿过判断对象。
	 * @since 1.0.0
	 */
	boolean canBlock(int type);
}
