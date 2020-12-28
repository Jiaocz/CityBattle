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
 * @author ���
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
		super("̹�˴�սchoice");
		
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
		
		JLabel lblNewLabel_0 = new JLabel("�ؿ�ѡ��");
		lblNewLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_0.setForeground(Color.WHITE);
		lblNewLabel_0.setFont(new Font("�������ʼ���", Font.PLAIN, 60));
		lblNewLabel_0.setBounds(320, 0, 360, 120);
		contentPane.add(lblNewLabel_0);
		
		JLabel lblNewLabel_1 = new JLabel("��һ��");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(190, 90, 120, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("�ڶ���");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(690, 90, 120, 36);;
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("������");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(190, 320, 120, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("���Ĺ�");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(690, 320, 120, 36);
		contentPane.add(lblNewLabel_1_2);

		//JLabel lblNewLabel_2_2 = new JLabel("");//��һ��ͼƬ
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
		
		//JLabel lblNewLabel_2 = new JLabel("");//�ڶ���ͼƬ
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

		//JLabel lblNewLabel_2_1 = new JLabel("");//������ͼƬ
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

		
		//JLabel lblNewLabel_2_1_1 = new JLabel("");//���Ĺ�ͼƬ
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
