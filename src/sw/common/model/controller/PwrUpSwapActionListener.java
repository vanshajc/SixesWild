/**
 *  @file   PwrUpSwapActionListener.java
 *  @author Tony Vu
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.board.BoardPanel;
import sw.common.model.entity.Level;

/**
 * 
 */
public class PwrUpSwapActionListener implements ActionListener {

	BoardPanel bp;
	Level level;
	public PwrUpSwapActionListener(BoardPanel bp, Level level){
		this.bp = bp;
		this.level = level;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardController bc = new MoveSwap(bp, level);
		bp.setBoardController(bc);
	}

}
