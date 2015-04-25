package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;

public class PostGameController implements ActionListener {
	
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
