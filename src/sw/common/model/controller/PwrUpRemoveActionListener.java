/**
 *  @file   PwrUpRemoveActionListener.java
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
 * Controller class for the remove powerup button.
 */
public class PwrUpRemoveActionListener implements ActionListener {
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
		
		int pwrUps[] = lc.getLevel().getGame().getPwrUps();
		if (pwrUps[Game.PWRUP_REMOVE] > 0) {			
			BoardController bc = new PwrUpRemove(lc, lc.getBoardPanel().getBoardController(), (JButton) e.getSource());
			lc.getBoardPanel().setBoardController(bc);
		}			
	}

	private class PwrUpRemove extends MoveRemove {

		JButton btn;
		
		public PwrUpRemove(ILevelController lc, BoardController prev, JButton btn) {
			super(lc, prev);
			this.btn = btn;
		}

		/* (non-Javadoc)
		 * @see sw.common.model.controller.MoveRemove#doMove()
		 */
		@Override
		public boolean doMove() {
			lvlCtrl.getBoardPanel().setBoardController(prev);
			if (super.doMove()) {
				int pwrUps[] = lvlCtrl.getLevel().getGame().getPwrUps();
				if (pwrUps[Game.PWRUP_REMOVE] > 0) {
					pwrUps[Game.PWRUP_REMOVE]--;
				}
				if (pwrUps[Game.PWRUP_REMOVE] <= 0) {
					btn.setEnabled(false);
				}
				return true;
			}
			return false;
		}		
		
	}
}
