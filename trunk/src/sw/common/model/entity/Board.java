/**
 *  @file   Board.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import sw.common.system.factory.SquareFactory;

/** The model for the game board 
 * 
 *  Layout:
 * 
 *     00  01  02  03  04  05  06  07  08
 *     10  11  12  13  14  15  16  17  18
 *     ...
 *     80  81  82  83  84  85  86  87  88 
 * 
 * */
public class Board {
	
	/** Default dimension for the board */
	public static int COLUMN = 9;
	public static int ROW    = 9;
	
	/** The grid of Square */
	ArrayList<Column> grid = new ArrayList<Column>();
	
	/** The selection queue */
	ArrayBlockingQueue<Square> selection = new ArrayBlockingQueue<Square>(Board.COLUMN * Board.ROW, true);
			
	/** Create a new Board
	 * @param fill the board with randomly generated value or not
	 */
	public Board() {
		createBoard(true);
	}
	
	public Board(boolean fill) {
		createBoard(fill);
	}
	
	/**
	 * @param x the x-position to check
	 * @return true if valid, false if not
	 */
	boolean isValidX(int x) {
		return (x >= 0 && x < Board.COLUMN);
	}
	
	/**
	 * @param y the y-position to check
	 * @return true if valid, false if not
	 */
	boolean isValidY(int y) {
		return (y >= 0 && y < Board.ROW);
	}
	
	/**
	 * @param p the Point to check
	 * @return true if valid, false if not
	 */
	boolean isValidPoint(Point p) {
		return (isValidX(p.x) && isValidY(p.y));
	}
	
	/** Create new Board
	 * @param fill whether to fill board with Tile
	 */
	private void createBoard(boolean fill) {
		// Create the board
		for (int x = 0; x < Board.COLUMN; x++) {
			// Create rows first since we want easy access to columns
			ArrayList<Square> row = new ArrayList<Square>();
			for (int y = 0; y < Board.ROW; y++) {
				row.add(SquareFactory.getSquare(fill));
			}
			// Add the new row to the grid			
			grid.add(new Column(row));
		}		
	}	
	
	/**
	 * @param pos the position
	 * @return the Square at the position
	 */
	public Square getSquare(Point pos) {
		if (isValidPoint(pos)) {
			return grid.get(pos.x).getSquare(pos.y);
		}
		return null;
	}
	
	/**
	 * @param tile the Tile to search for
	 * @return the position of the Tile in the Board
	 */
	public Point getLocation(Tile tile) {
		for (int x = 0; x < Board.COLUMN; x++) {
			int y;
			try {
				y = grid.get(x).indexOf(tile);
			} catch (IllegalAccessError e) {
				continue;
			}
			return new Point(x, y);
		}
		return null;
	}
	
	/**
	 * @param loc the location
	 * @return the Tile at the location
	 */
	public Tile getTile(Point loc) {
		if (isValidPoint(loc)) {
			return grid.get(loc.x).getTile(loc.y);
		}
		return null;
	}	
	
	/**
	 * @param col to get
	 * @return the column of Square
	 */
	public Column getColumn(int col) {
		try {
			return grid.get(col);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}		
	}
	
	/** Remove all Tile in the board */
	public void clear() {
		for (int x = 0; x < Board.COLUMN; x++) {
			grid.get(x).clear();
		}		
	}
	
	/** If there is unused space in each column, create new Tile to fill it */
	public void fill() {
		for (int x = 0; x < Board.COLUMN; x++) {
			Column c = grid.get(x);
			c.pack();
			c.fill();
		}		
	}	
	
	/**
	 * @return the dimension of the Board
	 */
	public Dimension size() {
		return new Dimension(Board.COLUMN, Board.ROW);
	}
	
	/**
	 * @param p the position to select
	 */
	public void select(Point p) {
		Square s = getSquare(p);
		s.setSelected(true);
		try {
			selection.put(s);
		} catch (InterruptedException e) {
			// Queue is full, discard this selection
			System.err.println("Selection queue is full!");
		}		
	}
	
	/**
	 * @return the selection queue
	 */
	public Queue<Square> getSelected() {
		return selection;
	}
	
	/**
	 * @param p position to remove
	 * @param fill whether to fill empty spaces with new Tiles
	 */
	public void removeTile(Point p, boolean fill) {
		if (isValidPoint(p)) {
			Column c = grid.get(p.x);
			c.removeTile(p.y);  // Remove Tile
			c.pack();           // Pack the Column
			if (fill) {
				c.fill();           // Fill empty spaces
			}
		}
	}
	
	/** Exchange the Tile of 2 positions
	 * @param s1
	 * @param s2
	 */
	public void swapTile(Point p1, Point p2) {
		Square s1 = getSquare(p1);
		Tile   t1 = s1.getTile();
		
		Square s2 = getSquare(p2);
		
		s1.setTile(s2.getTile());
		s2.setTile(t1);
	}

}
