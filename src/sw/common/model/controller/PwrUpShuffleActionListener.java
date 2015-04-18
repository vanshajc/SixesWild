/**
 *  @file   PwrUpShuffleActionListener.java
 *  @author Tony Vu
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.common.model.entity.Level;

/**
 * 
 */
public class PwrUpShuffleActionListener implements ActionListener {

	Level level;
	public PwrUpShuffleActionListener(Level level){
		this.level = level;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		level.getGame().getBoard().shuffle();

	}

}
