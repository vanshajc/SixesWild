/**
 *  @file   PwrUpShuffleActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Game;

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
		int pwrUps[] = lc.getLevel().getGame().getPwrUps();
		if (pwrUps[Game.PWRUP_SHUFFLE] > 0) {
			mm.pushMove(new PwrUpShuffle((JButton) e.getSource()));	
		}
	}
	
	/**
	 * Class for the Shuffle powerup.
	 */
	private class PwrUpShuffle implements IMove {
		
		JButton btn;
		
		PwrUpShuffle(JButton btn) {
			this.btn = btn;
		}

		/* (non-Javadoc)
		 * @see sw.common.model.controller.IMove#doMove()
		 */
		@Override
		public boolean doMove() {
			ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
			
			lc.getBoardPanel().getBoard().shuffle();
			
			int pwrUps[] = lc.getLevel().getGame().getPwrUps();
			if (pwrUps[Game.PWRUP_SHUFFLE] > 0) {
				pwrUps[Game.PWRUP_SHUFFLE]--;
			}
			if (pwrUps[Game.PWRUP_SHUFFLE] == 0) {
				btn.setEnabled(false);
			}
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
