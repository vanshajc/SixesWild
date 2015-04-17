/**
 *  @file   BoardPanelController.java
 *  @author Tony Vu
 *  @since  Apr 16, 2015
 */
package sw.common.model.controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.util.Queue;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.IBoard;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;

/**
 * 
 */
public abstract class BoardController extends MouseAdapter {
	
	IBoardPanel            panel;
	IBoard                 board;
	IBoardLocationManager  locator;
	IBoardSelectionManager selector;
	
	public BoardController(IBoardPanel bp) {
		this.panel    = bp;
		this.board    = bp.getBoard();
		this.locator  = bp.getLocator();
		this.selector = bp.getSelector();
	}
	
	boolean select(Point p) {
		return selector.select(p);
	}

	Queue<Square> getSelectedSquare() {
		return selector.getSelectedSquare();
	}
	
	Queue<Tile> getSelectedTile() {
		return selector.getSelectedTile();
	}

	boolean clearSelection() {
		return selector.clearSelection();
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

	boolean boardReplace(Point p, Tile t) {
		return board.replace(p, t);
	}

	void boardClear() {
		board.clear();
	}

	void boardFill() {
		board.fill();		
	}

	void boardPack() {
		board.pack();
	}

	int count() {
		return board.count();
	}	
	
}
