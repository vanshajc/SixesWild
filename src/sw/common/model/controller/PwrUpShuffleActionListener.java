/**
 *  @file   PwrUpShuffleActionListener.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.common.system.manager.LevelManager;

/**
 * Controller class for the shuffle powerup button.
 */
public class PwrUpShuffleActionListener implements ActionListener {

	LevelManager lm;
	public PwrUpShuffleActionListener(LevelManager lm){
		this.lm = lm;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		lm.getCurrent().getGame().getBoard().shuffle();
		lm.getCurrent().addToMoves();

	}

}
