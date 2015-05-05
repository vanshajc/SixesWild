package sw.builder.gui.layout;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.app.ApplicationLevelBuilder;
import sw.app.gui.view.IView;
import sw.common.model.entity.Board;

/**
 * @file SplashScreenBuilderView.java
 * @author Steven Yevchak, Trung-Nghia N. Huynh.
 */

/** Gui of splash screen. */
public class SplashScreenBuilderView extends JPanel implements IView{
	private static final long serialVersionUID = 1L;
	/** The current view. */
	BuilderLayoutManager blm;
	/**
	 * Constructor for splash screen view.
	 * @param bblm the current view.
	 */
	public SplashScreenBuilderView(BuilderLayoutManager bblm) {
		
		this.blm = bblm;
	
	}
	
	public void initialize() {

	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Created splash screen image.
	 */
	public void paintComponent(Graphics g) {
		ImageIcon splashScreen = new ImageIcon(SplashScreenBuilderView.class.getResource("/sw/resource/image/splashScreenImage.png"));
		ImageIcon newSplashScreen = new ImageIcon(splashScreen.getImage().getScaledInstance(800,  573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);
		g.drawImage(newSplashScreen.getImage(), 0, 0, null);
	}
}
