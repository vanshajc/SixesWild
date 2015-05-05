package sw.builder.gui.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import sw.app.gui.view.IView;

/**
 * @file LevelBuilderJFrame.java
 * @author Trung-Nghia N. Huynh.
 */

/** JFrame for the Level Builder Application. */
public class LevelBuilderJFrame extends JFrame implements IView{

	private static final long serialVersionUID = 1L;
	BuilderLayoutManager blm = new BuilderLayoutManager(this);
	SplashScreenBuilderView ssbv = new SplashScreenBuilderView(blm);
	
	/** Holds the frame currently being display. */
	Container pane = getContentPane();
	/** Holds the time program was started at. */
	long startTime;
	
	/**
	 * Constructor, creates JFrame and initializes it. 
	 */
	public LevelBuilderJFrame() {
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		setResizable(false);
		this.setVisible(true);
		blm = new BuilderLayoutManager(this);
		
		this.initialize();


	}
	
	/**
	 * Initializes the splash screen view and the builder layout manager.
	 */
	public void initialize() {
		blm.initailize();
		ssbv = new SplashScreenBuilderView(blm);
		getContentPane().add(ssbv);
		ssbv.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				blm.switchToLevelBuilderMenu();
			}			
		});
	}


	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}
