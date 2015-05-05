package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;

/**
 * @file PlayGameScreenController.java
 * @author Trung-Nghia N. Huynh
 */

/** Controller for the play game button */
public class PlayGameScreenController implements ActionListener {	

	/**
	 * Switch to pre-game screen to choose level.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LayoutManager.switchToPlayView(true);
	}

}
