package sw.builder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.builder.gui.layout.BuilderLayoutManager;

public class CreateButtonController implements ActionListener {
	
	BuilderLayoutManager blm;

	public CreateButtonController(BuilderLayoutManager blm) {
		this.blm = blm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		blm.switchToLevelBuilder();

	}

}
