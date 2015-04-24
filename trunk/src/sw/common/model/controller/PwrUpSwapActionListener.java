/**
 *  @file   PwrUpSwapActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.board.BoardPanel;
import sw.common.system.manager.LevelManager;

/**
 * Controller class for the Swap powerup button.
 */
public class PwrUpSwapActionListener implements ActionListener {

	BoardPanel bp;
	LevelManager lm;
	public PwrUpSwapActionListener(BoardPanel bp, LevelManager lm){
		this.bp = bp;
		this.lm = lm;;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardController bc = new MoveSwap(bp, lm.getCurrent());
		bp.setBoardController(bc);
	}

}
