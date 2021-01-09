/**
 * 
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nwpu.citybattle.TankMap.Map;

import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * @author 琚翔
 * version V1.0
 */
public class Victory extends JFrame {

	private JPanel contentPane;
	public static int mapNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Victory frame = new Victory();
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
	public Victory() {
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
		
		JLabel lblNewLabel = new JLabel("\u606D\u559C\u4F60");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("方正显仁简体", Font.PLAIN, 80));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(367, 41, 262, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F60\u8D62\u4E86\uFF01");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("方正显仁简体", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(383, 144, 305, 112);
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
		 * 下一关按键
		 */
		JButton btnNewButton_diy = new JButton("");
		btnNewButton_diy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Choice.mapNumber = Choice.mapNumber+1;
				Map.selectMap();
				System.out.println("第几关："+Choice.mapNumber);
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
		ImageIcon icon_JButton_diy = new ImageIcon("img\\Next.png");
		btnNewButton_diy.setBounds(432, 370, 136, height2);
		icon_JButton_diy.setImage(icon_JButton_diy.getImage().getScaledInstance(136, height2, 0));
		btnNewButton_diy.setIcon(icon_JButton_diy);
		contentPane.add(btnNewButton_diy);
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
		btnNewButton_help.setBounds(385, 440, 230, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(230, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
		
		/**
		 * 创作团队：成群结队
		 */
		JLabel lblNewLabel_11 = new JLabel("\u521B\u4F5C\u56E2\u961F\u2014\u6210\u7FA4\u7ED3\u961F");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setEnabled(false);
		lblNewLabel_11.setBounds(425, 540, 150, 15);
		contentPane.add(lblNewLabel_11);
		
		ImageIcon icon_JLabel_B = new ImageIcon("img\\finalbackground.png");
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(-60, 0, 1060, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1060, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);

	}

}
