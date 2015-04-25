package sw.common.model.controller;

import sw.app.gui.view.IGameplayView;
import sw.common.model.entity.Level;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;

public interface ILevelController extends IGameplayView {
	
	Level getLevel();
	
	void setBoardController(BoardController bc);
	
	IGameController getGameController();
	
	IMoveManager getMoveManager();

	IBoardLocationManager getBoardLocator();

	IBoardSelectionManager getBoardSelector();
	
}
