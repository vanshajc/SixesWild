package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;

/**
 * Controller for switching to scoreboard view.
 */
public class ScoreboardScreenController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		LayoutManager.switchToScoreBoardView(true);		
	}

}
