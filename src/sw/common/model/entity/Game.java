/**
 * @file Game.java
 * @author Tony Vu, Vanshaj Chowdhary
 */
package sw.common.model.entity;

/**
 * Class for representing a game that is being played.
 */
public class Game {

	public static final int PWRUP_SWAP = 0;
	public static final int PWRUP_SHUFFLE = 1;
	public static final int PWRUP_REMOVE = 2;
	
	Statistics stats = new Statistics();
	Board board = new Board();
	/** Holds the number left for each powerup */
	int pwrUps[] = {0, 0, 0};
	
	/**
	 * @return the stats
	 */
	public Statistics getStats() {
		return stats;
	}
	
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * @return the pwrUps
	 */
	public int[] getPwrUps() {
		return pwrUps;
	}	
	
}
