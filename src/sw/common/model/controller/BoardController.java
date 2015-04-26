/**
 *  @file   BoardPanelController.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 16, 2015
 */
package sw.common.model.controller;

import java.awt.Dimension;
import java.awt.Point;
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

/** Model for an abstract BoardController */
public abstract class BoardController extends MouseAdapter implements ActionListener {
	
	ILevelController       lvlCtrl  = null;
	
	IBoardPanel            panel    = null;
	IBoard                 board    = null;
	IBoardLocationManager  locator  = null;
	IBoardSelectionManager selector = null;
	
	IMoveManager           manager  = null;
	
	public BoardController(){}
	
	public BoardController(ILevelController lc) {
		initialize(lc);
	}
	
	public void initialize(ILevelController lc) {
		this.lvlCtrl  = lc;
		
		this.panel    = lc.getBoardPanel();
		this.board    = lc.getBoardPanel().getBoard();		
		
		this.locator  = lc.getBoardLocator();
		this.selector = lc.getBoardSelector();
		this.manager  = lc.getMoveManager();
	}
	
	protected void setBoardController(BoardController bc) {
		lvlCtrl.setBoardController(bc);
	}
	
	protected void finishGameHandler() {
		manager.finishGame();
	}
	
	protected void requestPushMove(IMove m) {
		if (manager.pushMove(m) && manager.hasFinished()) {
			while (panel.isAnimating()){}
			
			manager.finishGame();
		}
	}
	
	protected void requestUndoMove() {
		manager.undoMove();
	}
	
	protected void updateScore(int delta) {
		manager.updateScore(delta);
	}
	
	protected boolean select(Point p) {
		return selector.select(p);
	}

	public Queue<Square> getSelectedSquare() {
		return selector.getSelectedSquare();
	}
	
	public Queue<Tile> getSelectedTile() {
		return selector.getSelectedTile();
	}

	protected boolean clearSelection() {
		return selector.clearSelection();
	}
	
	protected void removeSelected() {
		Iterator<Tile> ti = getSelectedTile().iterator();
		while (ti.hasNext()) {
			boardRemove(getPoint(ti.next()));
		}
	}

	public boolean isValidX(int x) {
		return locator.isValidX(x);
	}

	public boolean isValidY(int y) {
		return locator.isValidY(y);
	}

	public boolean isValidPoint(Point p) {
		return locator.isValidPoint(p);
	}

	public Point getPoint(Tile tile) {
		return locator.getPoint(tile);
	}

	public Tile getTile(Point p) {
		return locator.getTile(p);
	}

	public Square getSquare(Point p) {
		return locator.getSquare(p);
	}

	public Dimension boardSize() {
		return board.size();
	}

	public boolean isEmpty(Point p) {
		return board.isEmpty(p);
	}

	public boolean boardRemove(Point p) {
		return board.remove(p);
	}

	protected boolean boardReplace(Point p, Tile t) {
		return board.replace(p, t);
	}

	protected void boardClear() {
		board.clear();
	}

	protected void boardFill() {
		board.fill();		
	}

	protected void boardPack() {
		board.pack();
	}

	protected int boardCount() {
		return board.count();
	}	
	
}
