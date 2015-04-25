package sw.app.gui.view.board;

import java.awt.Point;

import sw.app.gui.view.IView;
import sw.common.model.controller.BoardController;
import sw.common.model.entity.IBoard;
import sw.common.model.entity.Level;

/** Interface for displaying the Board */
public interface IBoardPanel extends IView {

	/**
	 * @param level to display
	 */
	void setLevel(Level level);
	
	/** Disable animation */
	void disableAnimation();
	
	/** Enable animation */
	void enableAnimation();
	
	/** Clear display */
	void clear();

	/**
	 * @param point the XY coordinate of the panel
	 * @return the board position
	 */
	Point xyToPoint(Point point);

	/**
	 * @return whether the board is in animation
	 */
	boolean isAnimating();
	
	/**
	 * @param colIdx the index of the Column
	 * @return whether the Column is in animation
	 */
	boolean isAnimating(int colIdx);
	
	/**
	 * @return the underlying Board interface
	 */
	IBoard getBoard();
	
	/**
	 * @param bc the new board controller
	 */
	void setBoardController(BoardController bc);
}