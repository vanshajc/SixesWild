package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
	
	MainMenuView mainMenu;
	
	public MainMenuController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mainMenu.setVisible(true);
	}

}
