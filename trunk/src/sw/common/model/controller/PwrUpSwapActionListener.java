/**
 *  @file   PwrUpSwapActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.SixesWildJFrame;

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
		
		BoardController bc = new MoveSwap(lc);
		lc.getBoardPanel().setBoardController(bc);
	}

}
