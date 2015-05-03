/**
 *  @file   PwrUpRemoveActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Game;

/**
 * Controller class for the remove powerup button.
 */
public class PwrUpRemoveActionListener implements ActionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ILevelController lc = SixesWildJFrame.getLevelManager()
				.getLevelController();

		int pwrUps[] = lc.getLevel().getGame().getPwrUps();
		if (pwrUps[Game.PWRUP_REMOVE] > 0) {
			JButton btn = (JButton) e.getSource();
			btn.setSelected(true);

			BoardController bc = new PwrUpRemove(lc, lc.getBoardPanel()
					.getBoardController(), btn);
			lc.getBoardPanel().setBoardController(bc);
		}
	}

	/**
	 * Class for the Remove powerup.
	 */
	private class PwrUpRemove extends MoveRemove {

		JButton btn;

		/**
		 * Construct a Remove powerup.
		 * 
		 * @param lc
		 *            the level controller.
		 * @param prev
		 *            the previous board controller
		 * @param btn
		 *            the button
		 */
		public PwrUpRemove(ILevelController lc, BoardController prev,
				JButton btn) {
			super(lc, prev);
			this.btn = btn;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isRightMouseButton(e)) {
				clearSelection();
				btn.setSelected(false);
				lvlCtrl.getBoardPanel().setBoardController(prev);
				e.consume();
				return;
			}
			super.mouseClicked(e);
		}

		/*
		 * (non-Javadoc)
		 * 
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
