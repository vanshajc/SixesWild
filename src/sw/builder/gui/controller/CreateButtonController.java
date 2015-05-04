package sw.builder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.builder.gui.layout.BuilderLayoutManager;
import sw.common.model.entity.Board;
/**
 * @author scyevchak
 */
/** Controls what happens when create button is pressed. */
public class CreateButtonController implements ActionListener {
	/** Controls which screen is displayed. */
	BuilderLayoutManager blm;
	/** Board create to be filled in the next view */
	public static Board board;
	/**
	 * Consructor for Create Button Controller
	 * @param blm the builder lay manager to switch to a new screen.
	 */
	public CreateButtonController(BuilderLayoutManager blm) {
		this.blm = blm;
		board = new Board();
	}
	/**
	 * Switches to the level builder.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		blm.switchToLevelBuilder();
	}

}
