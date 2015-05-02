package sw.app.gui.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;

import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.LevelManager;
import sw.common.system.manager.MementoManager;

public class SixesWildJFrame extends JFrame {
	
	static LevelManager lvlm = null;
	static LayoutManager lm  = null;
	static CommonResourceManager crm = null;
	
	SplashScreenView ssv;
	
	public SixesWildJFrame() {
		setTitle("Sixes Wild");		
		setSize(800,600);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Sixes Wild is started!");
				
				System.out.println("Loading progress...");
				MementoManager.initialize();
				lvlm = new LevelManager();
				
				System.out.println("Loading resources...");
				try {
					crm = new CommonResourceManager();
				} catch (IOException e1) {
					System.err.println("Can't load resources!!!");
				}
				
				System.out.println("Ready!");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Sixes Wild is closing!");
				
				System.out.println("Saving progress...");
				try {
					MementoManager.saveProgress();
				} catch (IOException e1) {
					System.err.println("Can't save progress!!!");
				}
				
				System.out.println("Goodbye!");
			}

		});
		
		// Application initialization
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
	
	public static CommonResourceManager getCommonResourceManager() {
		return crm;
	}
}

