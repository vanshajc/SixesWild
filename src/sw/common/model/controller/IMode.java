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

	IResourceManager getResourceManger();
	
	BoardController getBoardController();
	
	/**
	 * Returns if the move m is valid.
	 * @param m the move to be validated.
	 */
	public boolean isValid(IMove m);
	
	/**
	 * Returns if the current game is finished.
	 */
	public boolean hasFinished(Game g, Statistics winStats);
	
}
