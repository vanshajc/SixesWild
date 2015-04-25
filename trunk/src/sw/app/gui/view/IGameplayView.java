package sw.app.gui.view;

import sw.app.gui.view.board.IBoardPanel;
import sw.app.gui.view.board.IMovePanel;
import sw.app.gui.view.board.IScorePanel;
import sw.app.gui.view.board.ITimePanel;
import sw.common.model.entity.Level;

/** The interface for displaying the Game */
public interface IGameplayView {
	
	void setLevel(Level level);
	
	IBoardPanel getBoardPanel();
	
	IScorePanel getScorePanel();
	
	ITimePanel  getTimePanel();
	
	IMovePanel  getMovePanel();

}