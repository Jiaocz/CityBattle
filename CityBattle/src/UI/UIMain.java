/**
 * 
 */
package UI;

import java.awt.EventQueue;
import java.io.*;
import java.net.URI;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

/**
 * @author 琚翔
 * version V1.0
 */
public class UIMain {
	
	
	public static void playMusic() {// 背景音乐播放
		try {
//			getFile();
//			InputStream in = Reader.class.getResourceAsStream("/com/lavasoft/res/a.txt"); 
			AudioInputStream ais = AudioSystem.getAudioInputStream(UIMain.class.getResource("Alive.wav")); // 绝对路径
			AudioFormat aif = ais.getFormat();
			final SourceDataLine sdl;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
			sdl = (SourceDataLine) AudioSystem.getLine(info);
			sdl.open(aif);
			sdl.start();
			FloatControl fc = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
			// value可以用来设置音量，从0-2.0
			double value = 2;
			float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
			fc.setValue(dB);
			int nByte = 0;
			final int SIZE = 1024 * 64;
			byte[] buffer = new byte[SIZE];
			while (nByte != -1) {
				nByte = ais.read(buffer, 0, SIZE);
				sdl.write(buffer, 0, nByte);
			}
			sdl.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void getFile(){
//		File file = new File(this.getClass().getResource("/city.josn").getPath());
//		
//	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Thread(()->{while(true) {playMusic();} //while中的true可换成参数来控制音乐的停止播放
					}).start();
					StartInterface startinterface = new StartInterface();
					startinterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

}
