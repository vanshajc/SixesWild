/**
 *  @file   PwrUpSwapActionListener.java
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
 * Controller class for the Swap powerup button.
 */
public class PwrUpSwapActionListener implements ActionListener {
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
		
		int pwrUps[] = lc.getLevel().getGame().getPwrUps();
		if (pwrUps[Game.PWRUP_SWAP] > 0) {
			BoardController bc = new PwrUpSwap(lc, lc.getBoardPanel().getBoardController(), (JButton)e.getSource());
			lc.getBoardPanel().setBoardController(bc);			
		}
	}
	
	private class PwrUpSwap extends MoveSwap {

		JButton btn;
		
		public PwrUpSwap(ILevelController lc, BoardController prev, JButton btn) {
			super(lc, prev);
			this.btn = btn;
		}
		
		public boolean doMove() {
			boolean ret = swap(p1, p2);
			
			if (ret) {
				int pwrUps[] = lvlCtrl.getLevel().getGame().getPwrUps();
				if (pwrUps[Game.PWRUP_SWAP] > 0) {
					pwrUps[Game.PWRUP_SWAP]--;
				}
				// disable button
				if (pwrUps[Game.PWRUP_SWAP] == 0) {
					btn.setEnabled(false);
				}
			}
			
			setBoardController(prev);			
			return ret;
		}
	}

}
