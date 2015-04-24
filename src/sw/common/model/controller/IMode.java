/**
 * @file IMode.java
 * @date Apr 11, 2015 4:40:30 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.model.controller;

import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.IResourceManager;

/** Interface for every game mode */
public interface IMode {

	IResourceManager getResourceManger();
	
	BoardController getBoardController();
	
	public boolean isValid(IMove m);
	
	public boolean hasFinished(Game g, Statistics winStats);
	
}
