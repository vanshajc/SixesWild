/**
 *  @file   PwrUpShuffleActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.SixesWildJFrame;

/**
 * Controller class for the shuffle powerup button.
 */
public class PwrUpShuffleActionListener implements ActionListener {
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
		ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
		
		IMoveManager mm = lc.getMoveManager();
		mm.pushMove(new MoveShuffle());
	}
	
	private class MoveShuffle implements IMove {

		/* (non-Javadoc)
		 * @see sw.common.model.controller.IMove#doMove()
		 */
		@Override
		public boolean doMove() {
			ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
			
			lc.getBoardPanel().getBoard().shuffle();
			return true;
		}

		/* (non-Javadoc)
		 * @see sw.common.model.controller.IMove#undoMove()
		 */
		@Override
		public boolean undoMove() {
			// Cannot undo shuffle
			return false;
		}
		
	}

}
