/**
 * @file LayoutManager.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;

import sw.common.model.entity.Level;

/**
 * Class for handling all the different views and switching between them.
 */
public class LayoutManager {

	static SixesWildJFrame swf = null;
	static JPanel current = null;

	@SuppressWarnings("static-access")
	public LayoutManager(SixesWildJFrame swf) {
		this.swf = swf;
	}

	/**
	 * Switches to the Main Menu View.
	 * @param init
	 */
	public static void switchToMainMenu(boolean init) {
		switchToScreen(new MainMenuView(), init);
	}

	/**
	 * Switches to the Gameplay View.
	 * @param init
	 */
	public static void switchToGameplayView(boolean init) {
		switchToScreen(new GameplayView(), init);
	}

	/**
	 * Switches to the Scoreboard View.
	 * @param init
	 */
	public static void switchToScoreBoardView(boolean init) {
		switchToScreen(new ScoreBoardView(), init);
	}

	/**
	 * Switches to the Credit Screen View.
	 * @param init
	 */
	public static void switchToCreditScreenView(boolean init) {
		switchToScreen(new CreditScreenView(), init);
	}

	/**
	 * Switches to the Play Screen (or Choose Level) View.
	 * @param init
	 */
	public static void switchToPlayView(boolean init) {
		switchToScreen(new PlayGameScreenView(), init);
	}

	/**
	 * Switches to the Post Game View.
	 * @param init
	 * @param level
	 */
	public static void switchToPostGameView(boolean init, Level level) {		
		switchToScreen(new PostGameView(level), init);
	}

	/**
	 * Switches to a given screen.
	 * @param screen the screen to be displayed
	 * @param init
	 */
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

	/**
	 * Initializes the current view.
	 */
	public static void initCurrentView() {		
		if (current instanceof IView) {
			((IView) current).initialize();
		}
	}

	/**
	 * @return the current view
	 */
	public static JPanel getCurrentView() {
		return current;
	}

}
