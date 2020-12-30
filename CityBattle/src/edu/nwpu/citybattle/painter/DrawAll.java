package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import UI.CustomsPass;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 璇ョ被鐢ㄤ簬灏嗘父鎴忕敾闈㈢粯鍒跺嚭鏉�
 * @author 寰瑧鏈け
 * @see draw
 */
public class DrawAll {
	private BulletsPainter bulletsPainter;
	private ShapePainter shapePainter;
	private TankPainter tankPainter;
	public DrawAll(MyTank myTank,JPanel contentPane) {
		this.shapePainter = new ShapePainter(contentPane);
		this.tankPainter = new TankPainter(contentPane,myTank);
		this.bulletsPainter = new BulletsPainter(contentPane);
	}
	public void drawShape() {	
		shapePainter.drawAllShape();	
		bulletsPainter.drawBullets();
		tankPainter.drawAITanks();
		tankPainter.drawMyTank();
		
	}
	/**
	 * 璇ユ柟娉曠敤浜庣粯鍒舵墍闇�瑕佺敤鍒扮殑鐢婚潰
	 * @param g2d
	 */
}
