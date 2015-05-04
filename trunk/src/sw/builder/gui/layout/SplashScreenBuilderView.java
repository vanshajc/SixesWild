package sw.builder.gui.layout;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.app.ApplicationLevelBuilder;
import sw.app.gui.view.IView;
import sw.common.model.entity.Board;
/**
 * @author scyevchak
 */
/** Gui of splash screen */
public class SplashScreenBuilderView extends JPanel implements IView{
	
	private static final long serialVersionUID = 1L;
	/** Controls which screens are viewed */
	BuilderLayoutManager blm;
	/**
	 * 
	 * @param bblm
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
	
	public void paintComponent(Graphics g) {
		ImageIcon splashScreen = new ImageIcon(SplashScreenBuilderView.class.getResource("/sw/resource/image/splashScreenImage.png"));
		ImageIcon newSplashScreen = new ImageIcon(splashScreen.getImage().getScaledInstance(800,  573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);
		g.drawImage(newSplashScreen.getImage(), 0, 0, null);
	}
}
