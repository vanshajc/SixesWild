package sw.common.model.entity;

public class Game {

	public static final int PWRUP_SWAP = 0;
	public static final int PWRUP_SHUFFLE = 1;
	public static final int PWRUP_REMOVE = 2;
	
	Statistics stats = new Statistics();
	Board board = new Board();
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
