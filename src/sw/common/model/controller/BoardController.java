/**
 *  @file   BoardPanelController.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 16, 2015
 */
package sw.common.model.controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Iterator;
import java.util.Queue;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.IBoard;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;
import sw.mode.Release;

/** Model for an abstract BoardController */
public abstract class BoardController extends MouseAdapter implements ActionListener {
	
	protected ILevelController       lvlCtrl  = null;
	
	protected IBoardPanel            panel    = null;
	protected IBoard                 board    = null;
	protected IBoardLocationManager  locator  = null;
	protected IBoardSelectionManager selector = null;
	
	protected IMoveManager           manager  = null;
	
	public BoardController(){}
	
	/**
	 * Construct a Board Controller.
	 * @param lc the level controller.
	 */
	public BoardController(ILevelController lc) {
		initialize(lc);
	}
	
	/**
	 * @param lc the level controller
	 */
	public void initialize(ILevelController lc) {
		this.lvlCtrl  = lc;
		
		this.panel    = lc.getBoardPanel();
		this.board    = lc.getBoardPanel().getBoard();		
		
		this.locator  = lc.getBoardLocator();
		this.selector = lc.getBoardSelector();
		this.manager  = lc.getMoveManager();
	}
	
	/**
	 * @param bc the new board controller
	 */
	protected void setBoardController(BoardController bc) {
		lvlCtrl.setBoardController(bc);
	}
	
	/**
	 * Finish the game.
	 */
	protected void finishGameHandler() {
		manager.finishGame();
	}
	
	/**
	 * @param m the move to be pushed
	 */
	protected void requestPushMove(IMove m) {
//		if (manager.pushMove(m) && manager.hasFinished()) {
//			while (panel.isAnimating()){}
//			
//			manager.finishGame();
//		}
		manager.pushMove(m);
	}
	
	/**
	 * Undo the last move.
	 */
	protected void requestUndoMove() {
		manager.undoMove();
	}
	
	/**
	 * @param delta the change in score
	 */
	protected void updateScore(int delta) {
		manager.updateScore(delta);
	}
	
	/**
	 * @param p the point 
	 * @return if the square was selected
	 */
	protected boolean select(Point p) {
		return selector.select(p);
	}

	/**
	 * @return all the selected squares
	 */
	public Queue<Square> getSelectedSquare() {
		return selector.getSelectedSquare();
	}
	
	/**
	 * @return all the selected tiles
	 */
	public Queue<Tile> getSelectedTile() {
		return selector.getSelectedTile();
	}

	/**
	 * Sets all the squares to be unselected.
	 * @return if the selection was cleared
	 */
	protected boolean clearSelection() {
		return selector.clearSelection();
	}
	
	/**
	 * Removes all the selected squares.
	 */
	protected void removeSelected() {
		Iterator<Tile> ti = getSelectedTile().iterator();
		while (ti.hasNext()) {
			boardRemove(getPoint(ti.next()));
		}
	}

	/**
	 * @param x the x coordinate
	 * @return if x is valid.
	 */
	public boolean isValidX(int x) {
		return locator.isValidX(x);
	}

	/**
	 * @param y the y coordinate
	 * @return if y is valid
	 */
	public boolean isValidY(int y) {
		return locator.isValidY(y);
	}

	/**
	 * @param p the point
	 * @return if the point is valid
	 */
	public boolean isValidPoint(Point p) {
		return locator.isValidPoint(p);
	}

	/**
	 * @param tile the tile
	 * @return the point of the tile
	 */
	public Point getPoint(Tile tile) {
		return locator.getPoint(tile);
	}

	/**
	 * @param p the point
	 * @return the tile at the point
	 */
	public Tile getTile(Point p) {
		return locator.getTile(p);
	}

	/**
	 * @param p the point
	 * @return the square at the point
	 */
	public Square getSquare(Point p) {
		return locator.getSquare(p);
	}

	/**
	 * @return the size of the board
	 */
	public Dimension boardSize() {
		return board.size();
	}

	/**
	 * @param p the point
	 * @return if the square at the point doesn't have a tile
	 */
	public boolean isEmpty(Point p) {
		return board.isEmpty(p);
	}

	/**
	 * @param p the point
	 * @return if removal was successful
	 */
	public boolean boardRemove(Point p) {
		return board.remove(p);
	}

	/**
	 * @param p the point
	 * @param t the tile
	 * @return if replace was successful
	 */
	protected boolean boardReplace(Point p, Tile t) {
		return board.replace(p, t);
	}

	/**
	 * Clears the board.
	 */
	protected void boardClear() {
		board.clear();
	}

	/**
	 * Fills the board.
	 */
	protected void boardFill() {
		board.fill();		
	}

	/**
	 * Adds the gravity to the board.
	 */
	protected void boardPack() {
		if (this.lvlCtrl.getLevel().getMode() instanceof Release){
			board.releasePack();
			return;
		}
		board.pack();
	}

	/**
	 * @return the number of tiles on the board.
	 */
	protected int boardCount() {
		return board.count();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
