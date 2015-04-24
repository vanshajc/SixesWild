/**
 * @file LayoutManager.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

public class LayoutManager {

	SixesWildJFrame f;
	
	MainMenuView mmv;
	SplashScreenView ssv;
	GameplayView gv;
	CreditScreenView csv;
	ScoreBoardView sbv;
	PlayGameScreenView pgs;
	PostGameView pgv;

	JPanel current = null;

	public LayoutManager(SixesWildJFrame f) {
		this.f = f;		
	}
	
	void initialize() {
		mmv = new MainMenuView(this);
		gv = new GameplayView(this, f.getLevelManager());
		csv = new CreditScreenView(this);
		sbv = new ScoreBoardView(this);
		pgs = new PlayGameScreenView(this, f.getLevelManager());
		pgv = new PostGameView(this, f.getLevelManager());
	}

	public void switchToMainMenu() {
		switchToScreen(mmv);
	}

	public void switchToGameplayView() {
		switchToScreen(gv);
	}

	public void switchToScoreBoardView() {
		switchToScreen(sbv);
	}

	public void switchToCreditScreenView() {
		switchToScreen(csv);
	}

	public void switchToPlayView() {
		switchToScreen(pgs);
	}

	public void switchToPostGameView() {
		switchToScreen(pgv);
	}

	void switchToScreen(JPanel screen) {
		Container pane = f.getContentPane();

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

		current = screen;

		// initialize the new view
		if (screen instanceof IView) {
			((IView) screen).initialize();
		}
	}

	public JPanel getCurrentView() {
		return current;
	}

}
