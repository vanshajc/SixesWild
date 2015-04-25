/**
 * @file LayoutManager.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

public class LayoutManager {

	static SixesWildJFrame swf = null;
	static JPanel current = null;

	public LayoutManager(SixesWildJFrame swf) {
		this.swf = swf;
	}

	public static void switchToMainMenu(boolean init) {
		switchToScreen(new MainMenuView(), init);
	}

	public static void switchToGameplayView(boolean init) {
		switchToScreen(new GameplayView(), init);
	}

	public static void switchToScoreBoardView(boolean init) {
		switchToScreen(new ScoreBoardView(), init);
	}

	public static void switchToCreditScreenView(boolean init) {
		switchToScreen(new CreditScreenView(), init);
	}

	public static void switchToPlayView(boolean init) {
		switchToScreen(new PlayGameScreenView(), init);
	}

	public static void switchToPostGameView(boolean init) {		
		switchToScreen(new PostGameView(), init);
	}

	static void switchToScreen(JPanel screen, boolean init) {
		if (swf == null) {
			throw new IllegalStateException("LayoutManager is not initialized!");
		}

		Container pane = swf.getContentPane();

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
		
		if (init) {
			initCurrentView();
		}
		
	}

	public static void initCurrentView() {		
		if (current instanceof IView) {
			((IView) current).initialize();
		}
	}

	public static JPanel getCurrentView() {
		return current;
	}

}
