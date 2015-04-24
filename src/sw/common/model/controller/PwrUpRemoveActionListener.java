/**
 *  @file   PwrUpRemoveActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.system.manager.LevelManager;

/**
 * Controller class for the remove powerup button.
 */
public class PwrUpRemoveActionListener implements ActionListener {

	LevelManager lm;
	IBoardPanel bp;
	
	public PwrUpRemoveActionListener(LevelManager lm, IBoardPanel bp){
		this.lm = lm;
		this.bp = bp;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardController bc = new MoveRemove(lm, bp);
		bp.setBoardController(bc);
	}

}
