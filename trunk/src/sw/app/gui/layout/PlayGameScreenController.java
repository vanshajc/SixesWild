package sw.app.gui.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayGameScreenController implements ActionListener {

	LayoutManager lm;
	
	public PlayGameScreenController(LayoutManager lm){
		this.lm = lm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lm.switchToPlayView();
		
		// create screen
		/*
		SecondScreen secondScreen = new SecondScreen();
		secondScreen.setVisible(true);
		 */
		// set controller for previous button
		//secondScreen.getPreviousButton().addActionListener(new PrevScreenController(main, secondScreen));
		
	}

}
