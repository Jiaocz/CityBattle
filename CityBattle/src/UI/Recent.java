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

import edu.nwpu.citybattle.alogrism.CronJob;
import edu.nwpu.citybattle.alogrism.CronJobSet;

/**
 * @author 琚翔
 * version V1.0
 */
public class Recent extends JFrame {

	private JPanel contentPane;
	static boolean flag = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Recent frame = new Recent();
		frame.setVisible(true);
		CronJobSet.addDelayJob(new CronJob() {

			@Override
			public void run() {
				Recent.flag = false;
				frame.setVisible(false);
				frame.dispose();
			}
			
		}, 3000L);
//		while(flag) {
//			CronJobSet.manualRun();
////		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Recent frame = new Recent();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public Recent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//获得屏幕尺寸
		int width = 1000;
		int height = 600;//设置窗口宽度和高度
		setBounds((d.width-width)/2, (d.height-height)/2, width, height);//窗口的坐标和尺寸，以此种方式居中
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
		
		
		ImageIcon icon_JLabel_B = new ImageIcon(getClass().getResource("img\\recent.png"));
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(0, 0, 416, 520);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(416, 520, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
		
//		CronJobSet.addDelayJob(new CronJob() {
//
//			@Override
//			public void run() {
//				Recent.flag = false;
//				Recent.this.setVisible(false);
//				Recent.this.dispose();
//			}
//			
//		}, 3000L);
//		CronJobSet.startCronJob();
	}

}
