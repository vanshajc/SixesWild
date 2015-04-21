/**
 *  @file   PwrUpRemoveActionListener.java
 *  @author Tony Vu
 *  @since  Apr 12, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Level;

/**
 * 
 */
public class PwrUpRemoveActionListener implements ActionListener {

	Level level;
	IBoardPanel bp;
	
	public PwrUpRemoveActionListener(Level level, IBoardPanel bp){
		this.level = level;
		this.bp = bp;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardController bc = new MoveRemove(level, bp);
		bp.setBoardController(bc);
	}

}
