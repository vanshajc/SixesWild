/**
 * @file PostGameMenuController.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.system.manager.LevelManager;
import sw.common.system.manager.MementoManager;

public class PostGameMenuController implements ActionListener {
	
	LevelManager lm;
	
	
	public PostGameMenuController(LevelManager lm){
		this.lm = lm;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SixesWildJFrame.getLevelManager().unlockNextLevel();
			MementoManager.saveProgress();
		} catch (IOException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LayoutManager.switchToPostGameView(true, lm.getCurrent());
	}

}
