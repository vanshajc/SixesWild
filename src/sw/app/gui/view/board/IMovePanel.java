/**
 *  @file   IMovePanel.java
 *  @author Tony Vu
 *  @since  Apr 24, 2015
 */
package sw.app.gui.view.board;

/** The interface for configuring and controlling the number of moves display */
public interface IMovePanel {
	
	/** Set the current move count.
	 * 
	 * @param move - the move count to set.
	 */
	void setMove(int move);
	
	/** Get the current move count.
	 * 
	 * @return the number of moves.
	 */
	int getMove();
}
