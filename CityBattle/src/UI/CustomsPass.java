package UI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import edu.nwpu.citybattle.IngameElements.AiTank;
import edu.nwpu.citybattle.IngameElements.Bullet;
import edu.nwpu.citybattle.IngameElements.MyTank;
import edu.nwpu.citybattle.IngameElements.Tank;
import edu.nwpu.citybattle.TankMap.Map;
import edu.nwpu.citybattle.TankMap.Map1;
import edu.nwpu.citybattle.alogrism.CronJob;
import edu.nwpu.citybattle.alogrism.CronJobSet;
import edu.nwpu.citybattle.alogrism.ThreadCronJob;
import edu.nwpu.citybattle.painter.DrawAll;
import edu.nwpu.citybattle.painter.ShapePainterbeiyong;
/**
 * @author 鐞氱繑
 * version V1.0
 */
public class CustomsPass extends JFrame {

	public static JPanel contentPane;
	private static DrawAll draw;
	Graphics g2d = this.getGraphics();
	public static MyTank myTank;
	//Bullet bullet;
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
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		setBackground(new Color(0, 0, 0));
		//bullet = new Bullet(0,20,2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//鑾峰緱灞忓箷灏哄
		int width = 1000;
		int height = 600;//璁剧疆绐楀彛瀹藉害鍜岄珮搴�
		setBounds((d.width-width)/2, (d.height-height)/2, width, height);//绐楀彛鐨勫潗鏍囧拰灏哄锛屼互姝ょ鏂瑰紡灞呬腑
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Map.selectMap();
		this.choice();
		myTank = new MyTank();
		draw = new DrawAll(myTank,contentPane);
		CronJobSet.addJob(new CronJob() {
	 			public void run() {
	 				//contentPane.removeAll();
	 				//contentPane.invalidate();
	 				draw.drawShape();
	 				//System.out.println(myTank.direction +" " + myTank.tank_x +  " num:" + myTank.tank_y );
	 			}
		}, 1);
		//contentPane.repaint();
		CronJobSet.startCronJob();
		ThreadCronJob.start();
	 	bindKey();
	}
	
	private void bindKey(){
		//缂佹垵鐣鹃幐澶愭暛
				this.addKeyListener(new KeyListener() {
					
					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						char keyCode = e.getKeyChar();
						
						System.out.println(keyCode);
						switch(keyCode){
						case 'W'://娑撳﹪鏁幐澶夌瑓閿涘牊妫嗘潪顒婄礆
						case 'w':
							myTank.moveNext(MyTank.UP);
							draw.drawShape();
							break;
						case 'D'://閸欐娊鏁幐澶夌瑓
						case 'd':
							myTank.moveNext(MyTank.RIGHT);
							draw.drawShape();
							break;
						case 'S'://娑撳鏁幐澶夌瑓
						case 's':
							myTank.moveNext(MyTank.DOWN);
							draw.drawShape();
							break;
						case 'A'://瀹革箓鏁幐澶夌瑓
						case 'a':
							myTank.moveNext(MyTank.LEFT);
							draw.drawShape();
							break;
						case 'p'://缁岀儤鐗搁柨顔藉瘻娑撳绱欓拃钘夌俺閿涳拷
						case 'P':
							myTank.shootBullet();
							draw.drawShape();
							break;
						}
						
					}
					
					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void keyPressed(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
	}
	public void choice() {
		if(Choice.mapNumber == 1) {
			new AiTank(1,30,Tank.RIGHT,3);
		}
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
