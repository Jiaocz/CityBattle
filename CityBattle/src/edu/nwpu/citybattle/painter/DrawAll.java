package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import UI.CustomsPass;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 该类用于集中绘制各种图像，在创建对象时绘制一次，然后每调用一下drawShap方法，就进行一次重绘
 * @author 微笑未失
 * @see drawShape
 */
public class DrawAll {
	//public Painter bulletsPainter;
	public ShapePainter shapePainter;
	public TankPainter tankPainter;
	
	public DrawAll(MyTank myTank,JPanel contentPane) {
		this.shapePainter = new ShapePainter(contentPane);
		//this.tankPainter = new TankPainter(contentPane,myTank);
		//this.bulletsPainter = new Painter(contentPane);
		this.tankPainter = new TankPainter(contentPane,myTank);
		
	}
	/**
	 * 调用该方法可以绘制所有图像
	 */
	public void drawShape() {	
		shapePainter.drawWall();	
		//bulletsPainter.drawBullets();
		//tankPainter.drawAITanks();
		tankPainter.drawMyTank();
	}
}
