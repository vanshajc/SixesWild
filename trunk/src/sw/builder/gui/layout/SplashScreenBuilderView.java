package sw.builder.gui.layout;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.app.gui.view.IView;

public class SplashScreenBuilderView extends JPanel implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BuilderLayoutManager blm;
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
		super.paintComponent(g);
		g.drawImage(new ImageIcon(SplashScreenBuilderView.class.getResource("/sw/resource/image/SplashScreenImage.png")).getImage(), 0, 0, null);
	}
}
