package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreboardScreenController implements ActionListener {
	
	MainMenuView mainMenu;
	
	public ScoreboardScreenController(MainMenuView mm) {
		this.mainMenu = mm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainMenu.setVisible(false);
		
		// create screen
		ScoreBoardView scoreboard = new ScoreBoardView();
		scoreboard.setVisible(true);

		// set controller for previous button
	}

}
