/**
 * @file ILevelController.java
 * @author Tony Vu, Vanshaj Chowdhary
 */
package sw.common.model.controller;

import sw.app.gui.view.IGameplayView;
import sw.common.model.entity.Level;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;

/**
 * Interface for the Level Controller.
 */
public interface ILevelController extends IGameplayView {
	
	/**
	 * @return the level.
	 */
	Level getLevel();
	
	/**
	 * @param bc the new board controller
	 */
	void setBoardController(BoardController bc);
	
	/**
	 * @return the game controller
	 */
	IGameController getGameController();
	
	/**
	 * @return the move manager
	 */
	IMoveManager getMoveManager();

	/**
	 * @return the board locator
	 */
	IBoardLocationManager getBoardLocator();

	/**
	 * @return the board selection manager
	 */
	IBoardSelectionManager getBoardSelector();
	
}
