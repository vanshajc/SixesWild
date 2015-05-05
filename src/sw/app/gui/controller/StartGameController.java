/**
 * @file StartGameController.java
 * @author Vanshaj Chowdhary, Tony Vu
 */
package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.PlayGameScreenView;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;
/**
 * Controller for switching to the game view.
 */
public class StartGameController implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel current = LayoutManager.getCurrentView();
		
		LevelManager lvlm = SixesWildJFrame.getLevelManager();
		
		Level l = lvlm.getCurrent();
		if (current instanceof PlayGameScreenView) {
			l = ((PlayGameScreenView) current).getSelectedLevel();
		}
		LayoutManager.switchToGameplayView(false);		
		lvlm.setCurrent(l);
		LayoutManager.initCurrentView();
		
		lvlm.startLevel();
	}
	
	

}
