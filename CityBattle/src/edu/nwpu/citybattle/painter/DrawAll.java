package edu.nwpu.citybattle.painter;

import java.awt.Graphics;

import javax.swing.JPanel;

import UI.CustomsPass;
import edu.nwpu.citybattle.IngameElements.MyTank;

/**
 * 鐠囥儳琚悽銊ょ艾鐏忓棙鐖堕幋蹇曟暰闂堛垻绮崚璺哄毉閺夛拷
 * @author 瀵邦喚鐟ч張顏勩亼
 * @see draw
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
	public void drawShape() {	
		shapePainter.drawWall();	
		//bulletsPainter.drawBullets();
		//tankPainter.drawAITanks();
		tankPainter.drawMyTank();
	}
	/**
	 * 鐠囥儲鏌熷▔鏇犳暏娴滃海绮崚鑸靛闂囷拷鐟曚胶鏁ら崚鎵畱閻㈠娼�
	 * @param g2d
	 */
}
