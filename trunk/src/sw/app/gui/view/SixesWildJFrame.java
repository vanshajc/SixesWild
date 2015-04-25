package sw.app.gui.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import sw.common.system.manager.LevelManager;

public class SixesWildJFrame extends JFrame {
	
	static LevelManager lvlm = new LevelManager();
	static LayoutManager lm  = null;
	
	SplashScreenView ssv;
	
	public SixesWildJFrame() {
		setTitle("Sixes Wild");		
		setSize(800,600);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		lm  = new LayoutManager(this);
		
		initialize();
	}

	void initialize() {		
		ssv = new SplashScreenView();
		getContentPane().add(ssv);
		ssv.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				LayoutManager.switchToMainMenu(true);
			}			
		});		
	}
	
	public static LevelManager getLevelManager() {
		return lvlm;
	}
	
	public static LayoutManager getLayoutManager() {
		return lm;
	}
}

