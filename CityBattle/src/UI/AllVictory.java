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

/**
 * @author 琚翔
 * version V1.0
 */
public class AllVictory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllVictory frame = new AllVictory();
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
	public AllVictory() {
		super("坦克大战");
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage(getClass().getResource("img/LittleIcon.png")); 
		this.setIconImage(image);//设置图标
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
		
		JLabel lblNewLabel = new JLabel("\u606D\u559C\u4F60");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("方正显仁简体", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(369, 42, 262, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F60\u901A\u5173\u4E86\uFF01");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("方正显仁简体", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(348, 140, 350, 112);
		contentPane.add(lblNewLabel_1);
		
		/*
		 * 再玩一次按键
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
		ImageIcon icon_JButton_begin = new ImageIcon(getClass().getResource("img/TryAgain.png"));
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
				class t extends TimerTask{
					@Override
					public void run() {
					}
                }
                (new Timer()).schedule(new t(), 500L);//设置延时防止生成两个界面
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
		ImageIcon icon_JButton_help = new ImageIcon(getClass().getResource("img/ReturnMain.png"));
		btnNewButton_help.setBounds(385, 370, 230, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(230, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
		/*
		 * 鼓励作者按键
		 */
		JButton btnNewButton_skip = new JButton("");
		btnNewButton_skip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				class t extends TimerTask{
					@Override
					public void run() {
					}
                }
                (new Timer()).schedule(new t(), 500L);//设置延时防止生成两个界面
                Goutou goutou  = new Goutou();
                goutou.setVisible(true);
                class t1 extends TimerTask{
					@Override
					public void run() {
						goutou.setVisible(false);
					}
                }
                (new Timer()).schedule(new t1(), 3000L);
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
		ImageIcon icon_JButton_skip = new ImageIcon(getClass().getResource("img/Guli.png"));
		btnNewButton_skip.setBounds(405, 440, 190, height2);
		icon_JButton_skip.setImage(icon_JButton_skip.getImage().getScaledInstance(190, height2, 0));
		btnNewButton_skip.setIcon(icon_JButton_skip);
		contentPane.add(btnNewButton_skip);
		/**
		 * 创作团队：成群结队
		 */
		JLabel lblNewLabel_11 = new JLabel("\u521B\u4F5C\u56E2\u961F\u2014\u6210\u7FA4\u7ED3\u961F");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setEnabled(false);
		lblNewLabel_11.setBounds(425, 540, 150, 15);
		contentPane.add(lblNewLabel_11);

		
		ImageIcon icon_JLabel_B = new ImageIcon(getClass().getResource("img/finalbackground.png"));
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(-180, 0, 1180, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1180, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
	}

}
