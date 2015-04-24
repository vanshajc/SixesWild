package sw.app.gui.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SplashScreenView extends JPanel implements IView {
	
	private static final long serialVersionUID = 1L;
	final String res = "/sw/resource/image/SplashScreenImage.png";
	
	public void initialize() {}

	public void cleanup() {}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(SplashScreenView.class.getResource(res)).getImage(), 0, 0, null);
	}
}
