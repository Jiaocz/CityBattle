/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nwpu.citybattle.painter.DrawAll;

/**
 * @author ���
 * version V1.0
 */
public class CustomsPass extends JFrame {

	private JPanel contentPane;
	private static DrawAll draw;
	Graphics g2d = this.getGraphics();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomsPass frame = new CustomsPass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomsPass() {
		super("̹�˴�ս");
		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//�����Ļ�ߴ�
		int width = 1000;
		int height = 600;//���ô��ڿ�Ⱥ͸߶�
		setBounds((d.width-width)/2, (d.height-height)/2, width, height);//���ڵ�����ͳߴ磬�Դ��ַ�ʽ����
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		draw = new DrawAll(this,g2d);
	}

}
