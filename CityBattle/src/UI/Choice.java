/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Currency;

/**
 * @author 琚翔
 * version V1.0
 */
public class Choice extends JFrame {
	public static int mapNumber;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choice choice = new Choice();
					choice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Choice() {
		super("坦克大战choice");
		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//获得屏幕尺寸
		int width = 1000;
		int height = 600;//设置窗口宽度和高度
		setBounds((d.width-width)/2, (d.height-height)/2, width, height);//窗口的坐标和尺寸，以此种方式居中
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_0 = new JLabel("关卡选择");
		lblNewLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_0.setForeground(Color.WHITE);
		lblNewLabel_0.setFont(new Font("方正显仁简体", Font.PLAIN, 60));
		lblNewLabel_0.setBounds(320, 0, 360, 120);
		contentPane.add(lblNewLabel_0);
		
		JLabel lblNewLabel_1 = new JLabel("第一关");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(190, 90, 120, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("第二关");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(690, 90, 120, 36);;
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("第三关");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(190, 320, 120, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("第四关");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(690, 320, 120, 36);
		contentPane.add(lblNewLabel_1_2);

		//JLabel lblNewLabel_2_2 = new JLabel("");//第一关图片
		ImageIcon icon_JLabel_1 = new ImageIcon("img\\map1.jpg");
		JLabel lblNewLabel_2_1 = new JLabel(icon_JLabel_1);
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mapNumber = 1;
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(130, 125, 240, 180);
		lblNewLabel_2_1.setBorder(BorderFactory.createLineBorder(Color.white));
		contentPane.add(lblNewLabel_2_1);
		
		//JLabel lblNewLabel_2 = new JLabel("");//第二关图片
		ImageIcon icon_JLabel_2 = new ImageIcon("img\\map2.jpg");
		JLabel lblNewLabel_2_2 = new JLabel(icon_JLabel_2);
		lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mapNumber = 2;
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(630, 125, 240, 180);
		lblNewLabel_2_2.setBorder(BorderFactory.createLineBorder(Color.white));
		contentPane.add(lblNewLabel_2_2);

		//JLabel lblNewLabel_2_1 = new JLabel("");//第三关图片
		ImageIcon icon_JLabel_3 = new ImageIcon("img\\map3.jpg");
		JLabel lblNewLabel_2_3 = new JLabel(icon_JLabel_3);
		lblNewLabel_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mapNumber = 3;
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setBounds(130, 355, 240, 180);
		lblNewLabel_2_3.setBorder(BorderFactory.createLineBorder(Color.white));
		contentPane.add(lblNewLabel_2_3);

		
		//JLabel lblNewLabel_2_1_1 = new JLabel("");//第四关图片
		ImageIcon icon_JLabel_4 = new ImageIcon("img\\map4.jpg");
		JLabel lblNewLabel_2_4 = new JLabel(icon_JLabel_4);
		lblNewLabel_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mapNumber = 4;
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}
		});
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setBounds(630, 355, 240, 180);
		lblNewLabel_2_4.setBorder(BorderFactory.createLineBorder(Color.white));
		contentPane.add(lblNewLabel_2_4);

	}
}
