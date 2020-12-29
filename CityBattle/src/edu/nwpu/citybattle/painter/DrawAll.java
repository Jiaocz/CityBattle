package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import UI.CustomsPass;

/**
 * 该类用于将游戏画面绘制出来
 * @author 微笑未失
 * @see draw
 */
public class DrawAll {
	private BulletsPainter bulletsPainter;
	private ShapePainter shapPainter;
	private TankPainter tankPainter;
	public DrawAll(CustomsPass custompass,Graphics g2d) {
		this.bulletsPainter = new BulletsPainter(custompass);
		this.shapPainter = new ShapePainter(custompass);
		this.tankPainter = new TankPainter(custompass);
		bulletsPainter.drawBullets(g2d);
		tankPainter.drawTanks(g2d);
		shapPainter.drawAllShap(g2d);
	}
	/**
	 * 该方法用于绘制所需要用到的画面
	 * @param g2d
	 */
}
