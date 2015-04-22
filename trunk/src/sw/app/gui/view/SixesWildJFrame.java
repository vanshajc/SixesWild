package sw.app.gui.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import sw.common.system.manager.LevelManager;

public class SixesWildJFrame extends JFrame {	

	LevelManager levelManager = new LevelManager();
	LayoutManager lm = new LayoutManager(this);	
	
	SplashScreenView ssv = new SplashScreenView();
	
	public SixesWildJFrame() {
		setTitle("Sixes Wild");		
		setSize(800,600);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}

	void initialize() {		
		getContentPane().add(ssv);
		ssv.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				lm.switchToMainMenu();
			}			
		});
	}	
	
	public LevelManager getLevelManager(){
		return levelManager;
	}	
	
}

