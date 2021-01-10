/**
 * 
 */
package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import edu.nwpu.citybattle.TankMap.MapSelf;
import edu.nwpu.citybattle.painter.SelfPainter;

/**
 * 自定义地图界面
 * 
 * @author 琚翔
 * @version 1.0
 */
public class SelfConfigFrame extends JFrame {

	public static int type;
	public static int Wall = 1;
	public static int IronWall = 2;
	public static int Water = 3;
	public static int Grass = 4;

	private static final long serialVersionUID = 1L;
	public static int x;
	public static int y;
//	private String img_path = null;
//	private int height=0, width=0;
	public static JPanel contentPane;

	ImageIcon icon_JLabel;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelfConfigFrame frame = new SelfConfigFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

//			/*
//			 * 设置方格用于划分
//			 */
//			  @SuppressWarnings("unused")
//			public void paint(Graphics g) {
//				    paint(g); 
//				    Graphics2D g2 = (Graphics2D) g;
//				    g2.setColor(Color.WHITE);
//				    Line2D lin = new Line2D.Float(15, 0, 115, 600);
//				    g2.draw(lin);
//				  }
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public SelfConfigFrame() {

		super("坦克大战");
		setResizable(false);
//		this.setUndecorated(true);//隐藏标题栏		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		int width = 1000;
		int height = 640;// 设置窗口宽度和高度
		setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);// 窗口的坐标和尺寸，以此种方式居中
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * 设置一条白线分界
		 */
		ImageIcon icon_JLabel_B = new ImageIcon("img\\line.png");
		JLabel lblNewLabel_B = new JLabel(icon_JLabel_B);
		lblNewLabel_B.setBounds(61, 0, 1000, 600);
		icon_JLabel_B.setImage(icon_JLabel_B.getImage().getScaledInstance(1000, 600, 0));
		contentPane.add(lblNewLabel_B);
		lblNewLabel_B.setIcon(icon_JLabel_B);
		// 转置数组
		/**
		 * 放置皇冠
		 */
		ImageIcon icon_JLabel_H = new ImageIcon("img\\home.png");
		JLabel lblNewLabel_H = new JLabel(icon_JLabel_H);
		lblNewLabel_H.setBounds(405, 540, 45, 45);
		icon_JLabel_H.setImage(icon_JLabel_H.getImage().getScaledInstance(45, 45, 0));
		contentPane.add(lblNewLabel_H);
		lblNewLabel_H.setIcon(icon_JLabel_H);
		/*
		 * 绘制网格方便放置图案
		 */
		ImageIcon icon_JLabel_FangGe = new ImageIcon("img\\FangGe.png");
		// ImageIcon icon_JLabel_FangGe = new ImageIcon("");
		JLabel lblNewLabel_FangGe = new JLabel(icon_JLabel_FangGe);
		new SelfPainter(this.contentPane);
		// selfPainter = new SelfPainter();
		lblNewLabel_FangGe.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			public void mousePressed(MouseEvent e) {
				int screenWidth = d.width;
				int screenHeight = d.height;
//				x=(int) ((screenWidth-getLocation().getX())/2);
//				y=(int) ((screenHeight-getLocation().getY())/2);//框架frame的左上角坐标
//				System.out.println(getLocation().getX());
//				System.out.println(getLocation().getY());
				x = (int) (e.getXOnScreen() - getLocationOnScreen().getX() - 5);
				y = (int) (e.getYOnScreen() - getLocationOnScreen().getY() - 36);
//				System.out.println(e.getXOnScreen());
//				System.out.println(e.getYOnScreen());
//				System.out.println(getLocation().getX());
//				System.out.println(getLocation().getY());
//				System.out.println(x);
//				System.out.println(y);
				x = x / 15;
				y = y / 15;
				System.out.println(x);
				System.out.println(y);
				switch (type) {
				case 1:
					if (MapSelf.grass[y][x] == 0 && MapSelf.ironwall[y][x] == 0 && MapSelf.wall[y][x] == 0
							&& MapSelf.water[y][x] == 0) {
						MapSelf.wall[y][x] = 1;
						icon_JLabel = new ImageIcon("img\\wall.jpg");
						icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(15, 15, 0));
						lblNewLabel = new JLabel(icon_JLabel);
						lblNewLabel.setBounds(15 * x, 15 * y, 15, 15);
						contentPane.add(lblNewLabel);
						contentPane.updateUI();
					}

					break;
				case 2:
					if (MapSelf.grass[y][x] == 0 && MapSelf.ironwall[y][x] == 0 && MapSelf.wall[y][x] == 0
							&& MapSelf.water[y][x] == 0) {
						MapSelf.ironwall[y][x] = 1;
						icon_JLabel = new ImageIcon("img\\ironwall.jpg");
						icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(15, 15, 0));
						lblNewLabel = new JLabel(icon_JLabel);
						lblNewLabel.setBounds(15 * x, 15 * y, 15, 15);
						contentPane.add(lblNewLabel);
						contentPane.updateUI();
					}

					// selfPainter.drawWall();
				case 3:
					if (MapSelf.grass[y][x] == 0 && MapSelf.ironwall[y][x] == 0 && MapSelf.wall[y][x] == 0
							&& MapSelf.water[y][x] == 0) {
						MapSelf.water[y][x] = 1;
						icon_JLabel = new ImageIcon("img\\water.jpg");
						icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(15, 15, 0));
						lblNewLabel = new JLabel(icon_JLabel);
						lblNewLabel.setBounds(15 * x, 15 * y, 15, 15);
						contentPane.add(lblNewLabel);
						contentPane.updateUI();
					}
					break;
				// selfPainter.drawWall();
				case 4:
					if (MapSelf.grass[y][x] == 0 && MapSelf.ironwall[y][x] == 0 && MapSelf.wall[y][x] == 0
							&& MapSelf.water[y][x] == 0) {
						MapSelf.grass[y][x] = 1;
						icon_JLabel = new ImageIcon("img\\grass.png");
						icon_JLabel.setImage(icon_JLabel.getImage().getScaledInstance(15, 15, 0));
						lblNewLabel = new JLabel(icon_JLabel);
						lblNewLabel.setBounds(15 * x, 15 * y, 15, 15);
						contentPane.add(lblNewLabel);
						contentPane.updateUI();
					}
					break;
				// selfPainter.drawWall();
				default:
					return;
				}
			}// 设置鼠标监听，获取x,y的相对坐标
		});
		lblNewLabel_FangGe.setBounds(0, 0, 840, 600);
		icon_JLabel_FangGe.setImage(icon_JLabel_FangGe.getImage().getScaledInstance(840, 600, 0));
		contentPane.add(lblNewLabel_FangGe);
		lblNewLabel_FangGe.setIcon(icon_JLabel_FangGe);
		/*
		 * 右边的墙
		 */
		ImageIcon icon_JLabel_Wall = new ImageIcon("img\\wall.jpg");
		JLabel lblNewLabel_Wall = new JLabel(icon_JLabel_Wall);
		lblNewLabel_Wall.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				type = 1;
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
		lblNewLabel_Wall.setBounds(900, 20, 50, 50);
		icon_JLabel_Wall.setImage(icon_JLabel_Wall.getImage().getScaledInstance(50, 50, 0));
		contentPane.add(lblNewLabel_Wall);
		lblNewLabel_Wall.setIcon(icon_JLabel_Wall);
		/*
		 * 右边的铁墙
		 */
		ImageIcon icon_JLabel_Ironwall = new ImageIcon("img\\ironwall.jpg");
		JLabel lblNewLabel_Ironwall = new JLabel(icon_JLabel_Ironwall);
		lblNewLabel_Ironwall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				type = 2;
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
		lblNewLabel_Ironwall.setBounds(900, 100, 50, 50);
		icon_JLabel_Ironwall.setImage(icon_JLabel_Ironwall.getImage().getScaledInstance(50, 50, 0));
		contentPane.add(lblNewLabel_Ironwall);
		lblNewLabel_Ironwall.setIcon(icon_JLabel_Ironwall);
		/*
		 * 右边的水
		 */
		ImageIcon icon_JLabel_Water = new ImageIcon("img\\water.jpg");
		JLabel lblNewLabel_Water = new JLabel(icon_JLabel_Water);
		lblNewLabel_Water.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				type = 3;
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
		lblNewLabel_Water.setBounds(900, 180, 50, 50);
		icon_JLabel_Water.setImage(icon_JLabel_Water.getImage().getScaledInstance(50, 50, 0));
		contentPane.add(lblNewLabel_Water);
		lblNewLabel_Water.setIcon(icon_JLabel_Water);
		/*
		 * 右边的草
		 */
		ImageIcon icon_JLabel_Grass = new ImageIcon("img\\grass.png");
		JLabel lblNewLabel_Grass = new JLabel(icon_JLabel_Grass);
		lblNewLabel_Grass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				type = 4;
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
		lblNewLabel_Grass.setBounds(900, 260, 50, 50);
		icon_JLabel_Grass.setImage(icon_JLabel_Grass.getImage().getScaledInstance(50, 50, 0));
		contentPane.add(lblNewLabel_Grass);
		lblNewLabel_Grass.setIcon(icon_JLabel_Grass);
		/*
		 * 开始游戏
		 */
		JButton btnNewButton_begin = new JButton("");
		btnNewButton_begin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				dispose();
				Choice.mapNumber = 5;
				CustomsPass customsPass = new CustomsPass();
				customsPass.setVisible(true);
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
		ImageIcon icon_JButton_begin = new ImageIcon("img\\ButtonBegin.png");
		int height2 = 48;
		btnNewButton_begin.setBounds(870, 340, 94, height2);
		icon_JButton_begin.setImage(icon_JButton_begin.getImage().getScaledInstance(94, height2, 0));
		btnNewButton_begin.setIcon(icon_JButton_begin);
		contentPane.add(btnNewButton_begin);
		/*
		 * 返回主菜单
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
		ImageIcon icon_JButton_help = new ImageIcon("img\\Return.png");
		btnNewButton_help.setBounds(870, 400, 94, height2);
		icon_JButton_help.setImage(icon_JButton_help.getImage().getScaledInstance(94, height2, 0));
		contentPane.add(btnNewButton_help);
		btnNewButton_help.setIcon(icon_JButton_help);
	}

}
