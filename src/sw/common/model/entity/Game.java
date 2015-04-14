package sw.common.model.entity;

import sw.common.system.manager.TileLocationManager;

public class Game {

	Statistics stats = new Statistics();
	Board board = new Board();
	int pwrUps[] = {0, 0, 0};
	
	TileLocationManager locManager = new TileLocationManager(board);
	
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
	
	public TileLocationManager getLocationManager() {
		return locManager;
	}
	
	/**
	 * @return the pwrUps
	 */
	public int[] getPwrUps() {
		return pwrUps;
	}	
	
}
