package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartInterface frame = new StartInterface();
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
	public StartInterface() {
		super("坦克大战");
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
		
		//JLabel lblNewLabel = new JLabel("");
		ImageIcon icon_JLabel = new ImageIcon("img\\tankebegin.png");
		JLabel lblNewLabel  = new JLabel(icon_JLabel);
		lblNewLabel.setBounds(71, 40, 858, 214);
		contentPane.add(lblNewLabel);
		/*
		 * 开始游戏按键
		 */
		JButton btnNewButton_begin = new JButton("");
		btnNewButton_begin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		ImageIcon icon_JButton_begin = new ImageIcon("img\\ButtonBegin.png");
		int height2 = 48;
		btnNewButton_begin.setBounds(453, 300, 94, height2);
		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(94, height2, 0));
		btnNewButton_begin.setIcon(icon_JButton_begin);
		contentPane.add(btnNewButton_begin);
		/*
		 * 自定义地图按键
		 */
		JButton btnNewButton_diy = new JButton("");
		ImageIcon icon_JButton_diy = new ImageIcon("img\\ButtonDiy.png");
		btnNewButton_diy.setBounds(432, 370, 136, height2);
		icon_JButton_diy.setImage(icon_JButton_diy.getImage().getScaledInstance(136, height2, 0));
		btnNewButton_diy.setIcon(icon_JButton_diy);
		contentPane.add(btnNewButton_diy);
		/*
		 * 帮助文档按键
		 */
		JButton btnNewButton_help = new JButton("");
		ImageIcon icon_JButton_help = new ImageIcon("img\\ButtonHelp.png");
		btnNewButton_help.setBounds(405, 440, 190, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(190, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
		
		JLabel lblNewLabel_1 = new JLabel("\u521B\u4F5C\u56E2\u961F\u2014\u6210\u7FA4\u7ED3\u961F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(425, 560, 150, 15);
		contentPane.add(lblNewLabel_1);
	}
}
