package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.LayoutManager;

/** Controller for the Credits screen */
public class CreditScreenController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		LayoutManager.switchToCreditScreenView(true);
	}

}
