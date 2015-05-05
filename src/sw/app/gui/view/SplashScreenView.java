package sw.app.gui.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class for representing the splash screen view.
 */
public class SplashScreenView extends JPanel implements IView {
	public SplashScreenView() {
	}
	
	final String res = "/sw/resource/image/splashScreenImage.png";
	
	public void initialize() {}

	public void cleanup() {}
	
	public void paintComponent(Graphics g) {
		ImageIcon splashScreen = new ImageIcon(SplashScreenView.class.getResource(res));
		ImageIcon newSplashScreen = new ImageIcon(splashScreen.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);
		g.drawImage(newSplashScreen.getImage(), 0, 0, null);
	}
}
