package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import UI.CustomsPass;

/**
 * �������ڽ���Ϸ������Ƴ���
 * @author ΢Цδʧ
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
	 * �÷������ڻ�������Ҫ�õ��Ļ���
	 * @param g2d
	 */
}
