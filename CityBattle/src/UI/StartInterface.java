package UI;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nwpu.citybattle.TankMap.Map;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class StartInterface extends JFrame {

	private JPanel contentPane;
	CardLayout c = new CardLayout();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartInterface startinterface = new StartInterface();
					startinterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void ini_background() {
    // 背景图片
     ImageIcon background = new ImageIcon(
     this.getClass().getResource("img\\finalbackground.png"));
     // 把背景图片显示在一个标签里面
     JLabel label = new JLabel(background);
     // 设置标签大小
     label.setBounds(0, 0, 440, 335);
     // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
     JPanel imagePanel = (JPanel) this.getContentPane();
     imagePanel.setOpaque(false);
     this.getLayeredPane().setLayout(null);
     // 把背景图片添加到分层窗格的最底层作为背景
     this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
 }

	/**
	 * Create the frame.
	 */
	public StartInterface() {
		super("坦克大战");
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		
   
//        //导入图片
//        ImageIcon img = new ImageIcon("img\\\\finalbackground.png");
//        // 图片缩放为适合Frame大小
//        Image image = img.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_FAST); 
//        //将缩放好的图片实例化
//        ImageIcon newimg = new ImageIcon(image);
//        //在标签中添加图片
//        label.setIcon(newimg);
//        //设置标签大小为全屏
//        label.setBounds(0, 0, frame.getWidth(), frame.getHeight());        
//        //LayeredPane也是分层的，这里将JLabel放置在了LayeredPane最底层
//        frame.getLayeredPane().add( label, new Integer(Integer.MIN_VALUE));
//        //将ContentPane透明化
//         JPanel cp= (JPanel)  frame.getContentPane();            
//         cp.setOpaque(false);
         
         
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
//				dispose();
				Choice choice = new Choice();			
				choice.setVisible(true);
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
		btnNewButton_diy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Choice.mapNumber = 5;
				Map.selectMap();
                SelfConfigFrame selfConfigFrame = new SelfConfigFrame();
                selfConfigFrame.setVisible(true);
                dispose();	
//                class t extends TimerTask{
//					@Override
//					public void run() {
//						recent.setVisible(false);
//					}
//                }
//                (new Timer()).schedule(new t(), 3000L);
                
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
		ImageIcon icon_JButton_diy = new ImageIcon("img\\ButtonDiy.png");
		btnNewButton_diy.setBounds(432, 370, 136, height2);
		icon_JButton_diy.setImage(icon_JButton_diy.getImage().getScaledInstance(136, height2, 0));
		btnNewButton_diy.setIcon(icon_JButton_diy);
		contentPane.add(btnNewButton_diy);
		/*
		 * 帮助文档按键
		 */
		JButton btnNewButton_help = new JButton("");
		btnNewButton_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help help = new Help();			
				help.setVisible(true);
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
		ImageIcon icon_JButton_help = new ImageIcon("img\\ButtonHelp.png");
		btnNewButton_help.setBounds(405, 440, 190, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(190, height2, 0));
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
		
//		ImageIcon shanshuo1 = new ImageIcon("img\\坦克出现.gif");
//		JLabel shanshuo_1  = new JLabel(shanshuo1);
//		shanshuo_1.setBounds(71, 40, 858, 214);
//		contentPane.add(shanshuo_1);
		
//		ImageIcon icon_JLabel_A = new ImageIcon("img\\xuehua.gif");
//		JLabel lblNewLabel_A  = new JLabel(icon_JLabel_A);
//		lblNewLabel_A.setBounds(-60, 0, 1060, 600);
//		icon_JLabel_A.setImage(icon_JLabel_A.getImage().getScaledInstance(1060, 600, 0));
//		contentPane.add(lblNewLabel_A);
//		lblNewLabel_A.setIcon(icon_JLabel_A);
		
		ImageIcon icon_JLabel_B = new ImageIcon("img\\finalbackground.png");
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(-60, 0, 1060, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1060, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
	}
}
