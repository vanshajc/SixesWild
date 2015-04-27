package sw.builder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.builder.gui.layout.BuilderLayoutManager;
import sw.common.model.entity.Board;

public class CreateButtonController implements ActionListener {
	
	BuilderLayoutManager blm;
	public static Board board;

	public CreateButtonController(BuilderLayoutManager blm) {
		this.blm = blm;
		board = new Board();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		blm.switchToLevelBuilder();
	}

}
