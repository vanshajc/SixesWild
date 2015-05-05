package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;

/**
 * @file PostGameController.java
 * @author Trung-Nghia N. Huynh
 */

/**
 * Class for the controller for reaching the post game
 */
public class PostGameController implements ActionListener {
	
	/**
	 * Switch to Main Menu screen,
	 * switch back to the screen of last level,
	 * or the screen of the next level
	 * based on the input.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LevelManager lvlm = SixesWildJFrame.getLevelManager();
		
		Level n = lvlm.getNext();
		if (n != null) {
			LayoutManager.switchToGameplayView(false);			
			lvlm.setCurrent(n);
			LayoutManager.initCurrentView();
			
			lvlm.startLevel();
		} else {
			LayoutManager.switchToMainMenu(true);
		}
	}

}
