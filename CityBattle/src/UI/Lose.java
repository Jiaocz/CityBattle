/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author 琚翔
 * version V1.0
 */
public class Lose extends JFrame {

	private JPanel contentPane;
	public static int mapNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lose frame = new Lose();
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
	public Lose() {
		super("坦克大战");
		setResizable(false);
		
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
		
		JLabel lblNewLabel = new JLabel("\u522B\u7070\u5FC3");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("方正显仁简体", Font.PLAIN, 80));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(369, 42, 262, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u518D\u6765\u4E00\u6B21\uFF01");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("方正显仁简体", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(375, 142, 302, 112);
		contentPane.add(lblNewLabel_1);
		
		/*
		 * 再玩一次按键
		 */
		JButton btnNewButton_begin = new JButton("");
		btnNewButton_begin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ImageIcon icon_JButton_begin = new ImageIcon("img\\TryAgain.png");
		int height2 = 48;
		btnNewButton_begin.setBounds(405, 300, 190, height2);
		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(190, height2, 0));
		btnNewButton_begin.setIcon(icon_JButton_begin);
		contentPane.add(btnNewButton_begin);
		/*
		 * 返回主菜单按键
		 */
		JButton btnNewButton_help = new JButton("");
		btnNewButton_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartInterface startinterface = new StartInterface();			
				startinterface.setVisible(true);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ImageIcon icon_JButton_help = new ImageIcon("img\\ReturnMain.png");
		btnNewButton_help.setBounds(385, 370, 230, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(230, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
		/*
		 * 直接跳过按键
		 */
		JButton btnNewButton_skip = new JButton("");
		btnNewButton_skip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mapNumber = mapNumber+2;
				CustomsPass customspass = new CustomsPass();			
				customspass.setVisible(true);
				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ImageIcon icon_JButton_skip = new ImageIcon("img\\JustSkip.png");
		btnNewButton_skip.setBounds(405, 440, 190, height2);
		icon_JButton_skip.setImage(icon_JButton_skip.getImage().getScaledInstance(190, height2, 0));
		btnNewButton_skip.setIcon(icon_JButton_skip);
		contentPane.add(btnNewButton_skip);


		ImageIcon icon_JLabel_B = new ImageIcon("img\\finalbackground.png");
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(-60, 0, 1060, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1060, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
	}

}
