package sw.app.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.layout.LayoutManager;
public class StartGameController implements ActionListener{
	LayoutManager lm;
	public StartGameController(LayoutManager lm){
		this.lm = lm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		lm.switchToGameplayView();
		
	}
	
	

}
