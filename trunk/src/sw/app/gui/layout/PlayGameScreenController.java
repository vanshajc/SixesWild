package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayGameScreenController implements ActionListener {

	MainMenuView mainMenu;
	
	public PlayGameScreenController(MainMenuView mm){
		this.mainMenu = mm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainMenu.setVisible(false);
		
		// create screen
		/*
		SecondScreen secondScreen = new SecondScreen();
		secondScreen.setVisible(true);
		 */
		// set controller for previous button
		//secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}

}
