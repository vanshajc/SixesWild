/**
 *  @file   PwrUpSwapActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary, Trung-Nghia N. Huynh.
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
 * Controller class for the Swap powerup button.
 */
public class PwrUpSwapActionListener implements ActionListener {


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ILevelController lc = SixesWildJFrame.getLevelManager()
				.getLevelController();

		int pwrUps[] = lc.getLevel().getGame().getPwrUps();
		if (pwrUps[Game.PWRUP_SWAP] > 0) {
			JButton btn = (JButton) e.getSource();
			btn.setSelected(true);

			BoardController bc = new PwrUpSwap(lc, lc.getBoardPanel()
					.getBoardController(), btn);
			lc.getBoardPanel().setBoardController(bc);
		}
	}

	/**
	 * Class for the Swap powerup.
	 */
	private class PwrUpSwap extends MoveSwap {

		JButton btn;

		public PwrUpSwap(ILevelController lc, BoardController prev, JButton btn) {
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

		public boolean doMove() {
			boolean ret = swap(p1, p2);

			if (ret) {
				int pwrUps[] = lvlCtrl.getLevel().getGame().getPwrUps();
				if (pwrUps[Game.PWRUP_SWAP] > 0) {
					pwrUps[Game.PWRUP_SWAP]--;
					btn.setSelected(false);
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
