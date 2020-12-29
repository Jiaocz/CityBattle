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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author ���
 * version V1.0
 */
public class Help extends JFrame {

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
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon_JLabel = new ImageIcon("img\\tankebegin.png");
		//JLabel lblNewLabel  = new JLabel(icon_JLabel);
		lblNewLabel.setBounds(357, -20, 858, 214);
		icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(286, 71, 0));
		lblNewLabel.setIcon(icon_JLabel);
		contentPane.add(lblNewLabel);
		/*
		 * ��ʼ��Ϸ����
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
		btnNewButton_begin.setBounds(453, 400, 94, height2);
		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(94, height2, 0));
		btnNewButton_begin.setIcon(icon_JButton_begin);
		contentPane.add(btnNewButton_begin);
		
		/*
		 * �������˵�����
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
		btnNewButton_help.setBounds(385, 460, 230, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(230, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
		
		/**
		 * �����Ŷӣ���Ⱥ���
		 */
		JLabel lblNewLabel_1 = new JLabel("\u521B\u4F5C\u56E2\u961F\u2014\u6210\u7FA4\u7ED3\u961F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(425, 540, 150, 15);
		contentPane.add(lblNewLabel_1);
	}

}
