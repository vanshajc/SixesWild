package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostGameMenuController implements ActionListener {
	
	LayoutManager lm;
	PostGameMenuController(LayoutManager lm) {
		this.lm = lm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		lm.switchToPostGameView();
	}

}
