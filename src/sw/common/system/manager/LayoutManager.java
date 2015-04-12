/**
 * @file LayoutManager.java
 * @date Apr 11, 2015 3:17:17 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.manager;

import sw.app.gui.layout.GameplayView;
import sw.app.gui.layout.IView;

/** Manages all the views used by Sixes Wild game application */
public class LayoutManager {
	
	/** All the views in Sixes Wild application */
	public static enum view {
		SPLASH,
		MAIN,
		CREDIT,
		SCOREBOARD,
		START_GAME,
		GAMEPLAY,
		POST_GAME
	}
	
	IView current = null;
	
	public void switchToView(LayoutManager.view newView) {
		// Clean up current View before switching
		if (current != null) {
			current.cleanup();
		}
		
		// Create new View
		switch (newView) {
		case GAMEPLAY:
			LevelManager lm = new LevelManager();
			current = new GameplayView(this, lm);
			break;
		default:
			break;
		}
		
		// Initialize new View
		current.initialize();
	}
	
	public void backToMain() {
		switchToView(view.MAIN);		
	}

}
