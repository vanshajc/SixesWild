package sw.app.gui.view;

import sw.app.gui.view.board.IBoardPanel;
import sw.app.gui.view.board.IMovePanel;
import sw.app.gui.view.board.IScorePanel;
import sw.app.gui.view.board.ITimePanel;
import sw.common.model.entity.Level;

/**
 * @file IGameplayView.java
 * @author Trung-Nghia N. Huynh, Steven Yevchak.
 */

/** The interface for displaying the Game */
public interface IGameplayView {
	
	/**
	 * @param level the level to be set
	 */
	void setLevel(Level level);
	
	/**
	 * @return the board panel
	 */
	IBoardPanel getBoardPanel();
	
	/**
	 * @return the score panel
	 */
	IScorePanel getScorePanel();
	
	/**
	 * @return the time panel
	 */
	ITimePanel  getTimePanel();
	
	/**
	 * @return the move panel
	 */
	IMovePanel  getMovePanel();

}