package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;

/**
 * @file ScoreboardScreenController.java
 * @author Trung-Nghia N. Huynh
 */

/**
 * Controller for switching to scoreboard view.
 */
public class ScoreboardScreenController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		LayoutManager.switchToScoreBoardView(true);		
	}

}
