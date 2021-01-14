/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 用于代替开发中的页面向玩家告知功能开发中
 * 
 * @author 琚翔
 * @version V1.0
 */
public class Goutou extends JFrame {

	/**
	 * Random Serial Version UID
	 */
	private static final long serialVersionUID = 2822583091147079972L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Goutou frame = new Goutou();
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
	public Goutou() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 1000;
		int height = 600;// 设置窗口宽度和高度
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，以此种方式居中
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setVisible(true);
<<<<<<< HEAD
		
		
		ImageIcon icon_JLabel_B = new ImageIcon(getClass().getResource("img\\goutou.png"));
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(0, 0, 600, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(600, 600, 0));
=======

		ImageIcon icon_JLabel_B = new ImageIcon("img\\goutou.png");
		JLabel lblNewLabel_B = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(0, 0, 500, 500);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(500, 500, 0));
>>>>>>> branch 'master' of https://codehub.devcloud.cn-north-4.huaweicloud.com/hwxz-rjkfjcnlxl-QV_Orangii00001/CityBattle.git
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
	}

}
