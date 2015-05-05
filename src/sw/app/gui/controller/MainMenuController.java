package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;

/**
 * @file MainMenuController.java
 * @author Trung-Nghia N. Huynh
 */

/** Controller for the main menu button */
public class MainMenuController implements ActionListener {

	/**
	 * Switch the Main Menu.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LayoutManager.switchToMainMenu(true);
	}

}
