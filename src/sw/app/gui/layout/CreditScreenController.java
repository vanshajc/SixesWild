package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditScreenController implements ActionListener {
	
	MainMenuView mainMenu;
	
	public CreditScreenController(MainMenuView mm) {
		this.mainMenu = mm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainMenu.setVisible(false);
		
		// create screen
		//CreditView credits = new CreditView();
		//credits.setVisible(true);


	}

}
