/**
 * @file IMode.java
 * @date Apr 11, 2015 4:40:30 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.model.controller;

import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.IResourceManager;

/** Interface for every game mode */
public interface IMode {
	
	static enum TIMER_POLICY {
		COUNT_UP,
		COUNT_DOWN
	}
	
	IResourceManager getResourceManger();
	
	BoardController getBoardController();
	
	/**
	 * Returns if the move m is valid.
	 * @param m the move to be validated.
	 */
	boolean isValid(IMove m);

	/**
	 * Returns if the current game is finished.
	 */
	boolean hasFinished(Game g, Statistics winStats);
	
	void initializeGame(IGameController g);
	
	
	TIMER_POLICY getTimerPolicy();
}
