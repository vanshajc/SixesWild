/**
 *  @file   IMoveManager.java
 *  @author Tony Vu
 *  @since  Apr 21, 2015
 */
package sw.common.model.controller;

/** The interface for a Move manager, manages performing and undoing Moves */
public interface IMoveManager {
	
	/**
	 * @param move the Move to attempt
	 */
	boolean pushMove(IMove move);
	
	/** Attempt to undo the last Move made */
	boolean undoMove();	
	
	/**
	 * @return the number of successful Moves performed
	 */
	int countMove();

	/**
	 * @param delta the difference to update score
	 */
	boolean updateScore(int delta);
	
	/**
	 * @return whether the game is finished
	 */
	boolean hasFinished();
	
	/** Finish the game */
	void finishGame();
}
