package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreboardScreenController implements ActionListener {
	
	LayoutManager lm;
	
	public ScoreboardScreenController(LayoutManager lm) {
		this.lm = lm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lm.switchToScoreBoardView();
		// set controller for previous button
	}

}
