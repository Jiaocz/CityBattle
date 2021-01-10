package UI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.AiTankArray;
import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.MyTank;
import edu.nwpu.citybattle.IngameElements.Tank;
import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.TankMap.Map1;
import edu.nwpu.citybattle.alogrism.BulletAlogrism;
import edu.nwpu.citybattle.alogrism.CronJob;
import edu.nwpu.citybattle.alogrism.CronJobSet;
import edu.nwpu.citybattle.alogrism.ThreadCronJob;
import edu.nwpu.citybattle.painter.DrawAll;

import java.awt.event.KeyEvent;
/**
 * @author 琚翔
 * @author 微笑未失
 * version V1.0
 */
public class CustomsPass extends JFrame {

	public static JPanel contentPane;
	private static DrawAll draw;
	Graphics g2d = this.getGraphics();
	private static CustomsPass customspass;
	public static int winFlag;
	{
		winFlag = 0;
		
		
	}
	public static MyTank myTank;
	JLabel background;
	JLabel wall;
	JLabel water;
	JLabel ironWall;
	JLabel grass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomsPass frame = new CustomsPass();
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
	public CustomsPass() {
		
		super("坦克大战");
		setResizable(false);
		
		setBackground(new Color(0, 0, 0));
		//bullet = new Bullet(0,20,2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//鑾峰緱灞忓箷灏哄
		int width = 1000;
		int height = 600;
		setBounds((d.width-width)/2, (d.height-height)/2, width, height);//绐楀彛鐨勫潗鏍囧拰灏哄锛屼互姝ょ鏂瑰紡灞呬腑
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*
		 * firstTankNumber
		 */
		JLabel lblNewLabel_f = new JLabel("");
//		lblNewLabel.setText(Int.valueOf(mapNumber));
		lblNewLabel_f.setText(""+AiTankArray.firstTankNumber);
		lblNewLabel_f.setFont(new Font("宋体", Font.BOLD, 45));
		lblNewLabel_f.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_f.setForeground(new Color(0, 255, 255));
		lblNewLabel_f.setBounds(850, 138, 108, 74);
		contentPane.add(lblNewLabel_f);
		/*
		 * secondTankNumber
		 */
		JLabel lblNewLabel_s = new JLabel("");
//		lblNewLabel.setText(Int.valueOf(mapNumber));
		lblNewLabel_s.setText(""+AiTankArray.secondTankNumber);
		lblNewLabel_s.setFont(new Font("宋体", Font.BOLD, 45));
		lblNewLabel_s.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_s.setForeground(new Color(0, 255, 255));
		lblNewLabel_s.setBounds(850, 183, 108, 74);
		contentPane.add(lblNewLabel_s);
		/*
		 * thirdTankNumber
		 */
		JLabel lblNewLabel_t = new JLabel("");
//		lblNewLabel.setText(Int.valueOf(mapNumber));
		lblNewLabel_t.setText(""+AiTankArray.thirdTankNumber);
		lblNewLabel_t.setFont(new Font("宋体", Font.BOLD, 45));
		lblNewLabel_t.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_t.setForeground(new Color(0, 255, 255));
		lblNewLabel_t.setBounds(850, 228, 108, 74);
		contentPane.add(lblNewLabel_t);
		/**
		 * 总分数显示
		 */
		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setText(Int.valueOf(mapNumber));
		lblNewLabel.setText(""+winFlag);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setBounds(880, 305, 108, 74);
		contentPane.add(lblNewLabel);
		/*
		 * 总分数
		 */
		JLabel lblNewLabel_1_2 = new JLabel("总分数");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_2.setFont(new Font("宋体", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(780, 305, 140, 74);;
		contentPane.add(lblNewLabel_1_2);
		/*
		 * 第几关的第和关
		 */
		JLabel lblNewLabel_1_1 = new JLabel("第 关");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 70));
		lblNewLabel_1_1.setBounds(736, 0, 300, 74);;
		contentPane.add(lblNewLabel_1_1);
		
		/**
		 * 第几关的几
		 */
		JLabel lblNewLabel1 = new JLabel("");
//		lblNewLabel.setText(Int.valueOf(mapNumber));
		lblNewLabel1.setText(""+Choice.mapNumber);
		lblNewLabel1.setFont(new Font("宋体", Font.BOLD, 77));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setForeground(new Color(0, 255, 255));
		lblNewLabel1.setBounds(830, 0, 108, 74);
		contentPane.add(lblNewLabel1);
		
		ImageIcon icon_JLabel_B = new ImageIcon("img\\Right3.png");
		JLabel lblNewLabel_B  = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(785, 0, 200, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(200, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
//		/*
//		 * 返回按键
//		 */
//		ImageIcon icon_JLabel_Back = new ImageIcon("img\\Return.png");
//		JLabel lblNewLabel_Back  = new JLabel(icon_JLabel_Back);
//		lblNewLabel_Back.setBounds(785, 0, 200, 600);
//		icon_JLabel_Back.setImage(icon_JLabel_Back.getImage().getScaledInstance(200, 600, 0));
//		contentPane.add(lblNewLabel_Back);
//		lblNewLabel_Back.setIcon(icon_JLabel_Back);
//		JButton btnNewButton_begin = new JButton("");
//		btnNewButton_begin.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
////				dispose();
//				Choice choice = new Choice();			
//				choice.setVisible(true);
//				//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//				dispose();
//			}
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				setCursor(Cursor.getDefaultCursor());
//			}
//		});
//		ImageIcon icon_JButton_begin = new ImageIcon("img\\Return.png");
//		int height2 = 48;
//		btnNewButton_begin.setBounds(800, 500, 94, height2);
//		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(94, height2, 0));
//		btnNewButton_begin.setIcon(icon_JButton_begin);
//		contentPane.add(btnNewButton_begin);
		
		//重置AI坦克数组
		AiTank.removeAllTank();
		AiTankArray.firstTankNumber = 0;
		AiTankArray.secondTankNumber = 0;
		AiTankArray.thirdTankNumber = 0;
		//AiTankArray.choice();
		
		//去除分数
		winFlag = 0;
		//去除子弹
		Bullet.removeAllBullets();
		
		Map.selectMap();
		//this.choice();
		customspass = this;
		myTank = new MyTank();
		//Map.selectMap();
		draw = new DrawAll(myTank,contentPane);
		CronJobSet.addJob(new CronJob() {
	 			public void run() {
	 				//contentPane.removeAll();
	 				//contentPane.invalidate();
	 				draw.drawShape();
	 				//System.out.println(myTank.direction +" " + myTank.tank_x +  " num:" + myTank.tank_y );
	 				if(myTank.HP == 1) {
	 					ImageIcon icon_JLabel_B = new ImageIcon("img\\Right1.png");
	 					lblNewLabel_B.setBounds(785, 0, 200, 600);
	 					icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(200, 600, 0));
//	 					contentPane.add(lblNewLabel_B);
	 					lblNewLabel_B.setIcon(icon_JLabel_B);
	 				}else if(myTank.HP == 2) {
	 					ImageIcon icon_JLabel_B = new ImageIcon("img\\Right2.png");
	 					lblNewLabel_B.setBounds(785, 0, 200, 600);
	 					icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(200, 600, 0));
//	 					contentPane.add(lblNewLabel_B);
	 					lblNewLabel_B.setIcon(icon_JLabel_B);
	 				}else if(myTank.HP == 3) {
	 					ImageIcon icon_JLabel_B = new ImageIcon("img\\Right3.png");
	 					lblNewLabel_B.setBounds(785, 0, 200, 600);
	 					icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(200, 600, 0));
//	 					contentPane.add(lblNewLabel_B);
	 					lblNewLabel_B.setIcon(icon_JLabel_B);
	 				}
	 				
	 				lblNewLabel.setText(""+winFlag);
	 				lblNewLabel.setFont(new Font("宋体", Font.BOLD, 50));
	 				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 				lblNewLabel.setForeground(new Color(0, 255, 255));
	 				lblNewLabel.setBounds(880, 305, 108, 74);
	 				
	 				lblNewLabel_f.setText(""+AiTankArray.firstTankNumber);
	 				lblNewLabel_f.setFont(new Font("宋体", Font.BOLD, 45));
	 				lblNewLabel_f.setHorizontalAlignment(SwingConstants.CENTER);
	 				lblNewLabel_f.setForeground(new Color(0, 255, 255));
	 				lblNewLabel_f.setBounds(850, 138, 108, 74);
	 				
	 				lblNewLabel_s.setText(""+AiTankArray.secondTankNumber);
	 				lblNewLabel_s.setFont(new Font("宋体", Font.BOLD, 45));
	 				lblNewLabel_s.setHorizontalAlignment(SwingConstants.CENTER);
	 				lblNewLabel_s.setForeground(new Color(0, 255, 255));
	 				lblNewLabel_s.setBounds(850, 183, 108, 74);
	 				
	 				lblNewLabel_t.setText(""+AiTankArray.thirdTankNumber);
	 				lblNewLabel_t.setFont(new Font("宋体", Font.BOLD, 45));
	 				lblNewLabel_t.setHorizontalAlignment(SwingConstants.CENTER);
	 				lblNewLabel_t.setForeground(new Color(0, 255, 255));
	 				lblNewLabel_t.setBounds(850, 228, 108, 74);
	 				contentPane.updateUI();
	 			}
		}, 1);
		this.choice();
		//contentPane.repaint();
		BulletAlogrism.initAlogrism(Map.wall, Map.ironwall, AiTankArray.aiTank, myTank);
		CronJobSet.startCronJob();
		ThreadCronJob.start();
	 	bindKey();
	 	
	}
	
	/**
	 * 键盘事件
	 */
	private void bindKey(){
				this.addKeyListener(new KeyListener() {
					
					@Override
					public void keyPressed(KeyEvent e) {
						char keyCode = e.getKeyChar();
						
						//System.out.println(keyCode);
						switch(keyCode){
						case 'W':
						case 'w':
							myTank.moveNext(MyTank.UP);
							draw.drawShape();
							break;
						case 'D':
						case 'd':
							myTank.moveNext(MyTank.RIGHT);
							draw.drawShape();
							break;
						case 'S':
						case 's':
							myTank.moveNext(MyTank.DOWN);
							draw.drawShape();
							break;
						case 'A':
						case 'a':
							myTank.moveNext(MyTank.LEFT);
							draw.drawShape();
							break;
						case KeyEvent.VK_SPACE:
							myTank.shootBullet();
							draw.drawShape();
							break;
						}
						
						switch(e.getKeyCode()) {
							case KeyEvent.VK_UP:
								myTank.moveNext(MyTank.UP);
								draw.drawShape();
								break;
							case KeyEvent.VK_RIGHT:
								myTank.moveNext(MyTank.RIGHT);
								draw.drawShape();
								break;
							case KeyEvent.VK_DOWN:
								myTank.moveNext(MyTank.DOWN);
								draw.drawShape();
								break;
							case KeyEvent.VK_LEFT:
								myTank.moveNext(MyTank.LEFT);
								draw.drawShape();
								break;
						}
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {}
					
					@Override
					public void keyTyped(KeyEvent e) {}
				});
	}
	public void choice() {
		AiTankArray.choice();
		//if(Choice.mapNumber == 1) {
//			new AiTank(4,30,Tank.RIGHT,3);
//			new AiTank(33,15,Tank.LEFT,1);
//			new AiTank(18,3,Tank.DOWN,2);
			//new AiTank(22,4,Tank.UP,2);
		//}
	}
	public static void win() {
		switch(Choice.mapNumber) {
			case 1:
				if(winFlag == 4) {
					Victory	victory = new Victory();			
					victory.setVisible(true);
					customspass.dispose();
					ThreadCronJob.stop();
					CronJobSet.removeAll();
				}
			case 2:
				if(winFlag == 6) {
					Victory	victory = new Victory();			
					victory.setVisible(true);
					customspass.dispose();
					ThreadCronJob.stop();
					CronJobSet.removeAll();
				}
			case 3:
				if(winFlag == 8) {
					Victory	victory = new Victory();			
					victory.setVisible(true);
					customspass.dispose();
					ThreadCronJob.stop();
					CronJobSet.removeAll();
				}
			case 4:
				if(winFlag == 10) {
					AllVictory	allvictory = new AllVictory();			
					allvictory.setVisible(true);
					customspass.dispose();
					ThreadCronJob.stop();
					CronJobSet.removeAll();
				}
		}
		/*if(winFlag == 5) {
		Victory	victory = new Victory();			
		victory.setVisible(true);
		customspass.dispose();
		}*/
	}
	
	public static void isLose() {
		Lose lose = new Lose();			
		lose.setVisible(true);
		customspass.dispose();
		ThreadCronJob.stop();
		CronJobSet.removeAll();
		
	}
	
	/*public void loadImg() {
		ImageIcon origin_background = new ImageIcon("img\\tankebegin.png");
		ImageIcon origin_wall = new ImageIcon("img\\tankebegin.png");
		origin_wall.setImage(origin_wall.getImage().getScaledInstance(ELEMENT_SIZE, ELEMENT_SIZE, 0));
		ImageIcon origin_iron_wall = new ImageIcon("img\\tankebegin.png");
		ImageIcon origin_grass = new ImageIcon("img\\tankebegin.png");
		ImageIcon origin_water = new ImageIcon("img\\tankebegin.png");
		background  = new JLabel(origin_wall);
		wall = new JLabel(origin_wall);
		//wall.setBounds(71, 40,ELEMENT_SIZE, ELEMENT_SIZE);
		//contentPane.add(wall);
		water = new JLabel(origin_water);
		ironWall  = new JLabel(origin_grass);
		grass = new JLabel(origin_iron_wall);
		
		for(int x = 0;x < Map1.wall.length;x++) {
			for(int y = 0;y < Map1.wall[x].length;y++) {
				if(Map.wall[x][y] == 1) {
					wall = new JLabel(origin_wall);
					wall.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(wall);
				}
			}
		}
	}
	public void initialPainter()
	{
		int size1 = WINDOW_WIDTH / (TABLE_WIDTH + 1);
		int size2 = WINDOW_HEIGHT / (TABLE_HEIGHT + 1);
		
		ELEMENT_SIZE = size1 < size2 ? size1 : size2; 
	}
	public void drawWall() {//缂備焦锚閸╂鏅跺▎蹇旂
		for(int x = 0;x < Map1.wall.length;x++) {
			for(int y = 0;y < Map1.wall[x].length;y++) {
				if(Map.wall[x][y] == 1) {
					wall = new JLabel(origin_wall);
					wall.setBounds(x*ELEMENT_SIZE, y*ELEMENT_SIZE, ELEMENT_SIZE, ELEMENT_SIZE);
					contentPane.add(wall);
				}
			}
		}
	}*/
}
