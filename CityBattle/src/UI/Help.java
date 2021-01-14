/**
 * 
 */
package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DropMode;

/**
 * 帮助文档界面
 * 
 * @author 琚翔
 * @version V1.0
 */
public class Help extends JFrame {

	/**
	 * Random Serial Version UID
	 */
	private static final long serialVersionUID = -599272160987207435L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		super("坦克大战");
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage(getClass().getResource("img/LittleIcon.png")); 
		this.setIconImage(image);//设置图标
		setResizable(false);

		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 1000;
		int height = 600;// 设置窗口宽度和高度
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，以此种方式居中
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
<<<<<<< HEAD
		ImageIcon icon_JLabel = new ImageIcon(getClass().getResource("img/KeyHelp.png"));
		//JLabel lblNewLabel  = new JLabel(icon_JLabel);
=======
		ImageIcon icon_JLabel = new ImageIcon("img\\KeyHelp.png");
		// JLabel lblNewLabel = new JLabel(icon_JLabel);
>>>>>>> branch 'master' of https://codehub.devcloud.cn-north-4.huaweicloud.com/hwxz-rjkfjcnlxl-QV_Orangii00001/CityBattle.git
		lblNewLabel.setBounds(262, 120, 600, 240);
		icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(600, 240, 0));
		lblNewLabel.setIcon(icon_JLabel);
		contentPane.add(lblNewLabel);
		/*
		 * 开始游戏按键
		 */
		JButton btnNewButton_begin = new JButton("");
		btnNewButton_begin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				class t extends TimerTask{
					@Override
					public void run() {
					}
                }
                (new Timer()).schedule(new t(), 500L);//设置延时防止生成两个界面
//				dispose();
				Choice choice = new Choice();
				choice.setVisible(true);
				// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ImageIcon icon_JButton_begin = new ImageIcon(getClass().getResource("img/ButtonBegin.png"));
		int height2 = 48;
		btnNewButton_begin.setBounds(453, 400, 94, height2);
		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(94, height2, 0));
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
				// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		ImageIcon icon_JButton_help = new ImageIcon(getClass().getResource("img/ReturnMain.png"));
		btnNewButton_help.setBounds(385, 460, 230, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(230, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);

		/**
		 * 创作团队：成群结队
		 */
		JLabel lblNewLabel_1 = new JLabel("\u521B\u4F5C\u56E2\u961F\u2014\u6210\u7FA4\u7ED3\u961F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(425, 540, 150, 15);
		contentPane.add(lblNewLabel_1);
<<<<<<< HEAD
		
		ImageIcon icon_JLabel_B = new ImageIcon(getClass().getResource("img/finalbackground.png"));
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
=======

		ImageIcon icon_JLabel_B = new ImageIcon("img\\finalbackground.png");
		JLabel lblNewLabel_B = new JLabel(icon_JLabel_B);
>>>>>>> branch 'master' of https://codehub.devcloud.cn-north-4.huaweicloud.com/hwxz-rjkfjcnlxl-QV_Orangii00001/CityBattle.git
		lblNewLabel_B.setBounds(-60, 0, 1060, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1060, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);

	}
}
