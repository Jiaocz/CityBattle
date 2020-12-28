package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

/**
 * 该类用于将游戏画面绘制出来
 * @author 微笑未失
 * @see draw
 */
public class DrawAll {
	BulletsPainter bulletsPainter;
	ShapePainter shapPainter;
	TankPainter tankPainter;
	public DrawAll() {
		this.bulletsPainter = new BulletsPainter();
		this.shapPainter = new ShapePainter();
		this.tankPainter = new TankPainter();
	}
	/**
	 * 该方法用于绘制所需要用到的画面
	 * @param g2d
	 */
	public void draw(Graphics g2d) {
		bulletsPainter.drawBullets(g2d);
		tankPainter.drawTanks(g2d);
		shapPainter.drawAllShap(g2d);
	}
}
