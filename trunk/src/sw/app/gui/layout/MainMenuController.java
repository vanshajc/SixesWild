package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
	
	LayoutManager lm;
	
	public MainMenuController(LayoutManager lm) {
		this.lm = lm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lm.switchToMainMenu();
	}

}
