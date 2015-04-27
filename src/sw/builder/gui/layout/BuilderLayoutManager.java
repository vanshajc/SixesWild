package sw.builder.gui.layout;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

import sw.app.gui.view.IView;
import sw.builder.gui.layout.SplashScreenBuilderView;
import sw.builder.gui.layout.LevelBuilderJFrame;
import sw.builder.gui.layout.LevelBuilderView;



public class BuilderLayoutManager {
	LevelBuilderJFrame lbjf;
	SplashScreenBuilderView ssbv;
	LevelBuilderView lbv;
	LevelBuilderMenuView lbmv;
	BuilderBoardPanel bbp;
	JPanel current = null;
	
	public BuilderLayoutManager(LevelBuilderJFrame lbjf){
		this.lbjf = lbjf;
	}
	
	public void initailize() {
		lbv = new LevelBuilderView(this);
		ssbv = new SplashScreenBuilderView(this);
		lbmv = new LevelBuilderMenuView(this);
		//bbp = new BuilderBoardPanel(this);
	}
	
	public void switchToLevelBuilder(){
		switchToScreen(lbv);
	}
	
	public void switchToLevelBuilderMenu(){
		switchToScreen(lbmv);
	}

	public void switchToBuilderBoard() {
		bbp = new BuilderBoardPanel(this);
		switchToScreen(bbp);
		bbp.setBoardView(LevelBuilderView.boardStr);
	}
	
	public void switchToScreen(JPanel screen){
		System.out.println("Switch to next screen");
		Container pane = lbjf.getContentPane();
		
		// call cleanup on all IView components
		int count = pane.getComponentCount();
		Component[] c = pane.getComponents();
		for (int i = 0; i < count; i++) {
			if (c[i] instanceof IView) {
				((IView) c[i]).cleanup();
			}
		}
		
		pane.removeAll();
		pane.add(screen);		
		pane.revalidate();
		pane.repaint();
		
		// initialize the new view
		if (screen instanceof IView) {
			((IView) screen).initialize();
		}
	}

}
