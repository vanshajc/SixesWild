package sw.builder.gui.layout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sw.app.gui.view.IView;
import sw.app.gui.view.SplashScreenView;

public class LevelBuilderJFrame extends JFrame implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BuilderLayoutManager blm = new BuilderLayoutManager(this);
	SplashScreenBuilderView ssbv = new SplashScreenBuilderView(blm);
	
	Container pane = getContentPane();
	long startTime;
	
	
	public LevelBuilderJFrame() {
		this.setSize(800,600);
		this.setLayout(new BorderLayout());
		setResizable(false);
		this.setVisible(true);
		blm = new BuilderLayoutManager(this);
		
		this.initialize();


	}
	
	
	public void initialize() {
		blm.initailize();
		ssbv = new SplashScreenBuilderView(blm);
		getContentPane().add(ssbv);
		ssbv.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				blm.switchToLevelBuilder();
			}			
		});
	}


	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

}
