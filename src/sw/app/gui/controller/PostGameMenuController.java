/**
 * @file PostGameMenuController.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;
import sw.common.system.manager.LevelManager;

public class PostGameMenuController implements ActionListener {
	
	LevelManager lm;
	
	
	public PostGameMenuController(LevelManager lm){
		this.lm = lm;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LayoutManager.switchToPostGameView(true, lm.getCurrent());
	}

}
