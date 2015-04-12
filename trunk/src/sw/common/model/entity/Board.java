/**
 *  @file   Board.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import sw.common.system.factory.SquareFactory;
import sw.common.system.factory.TileFactory;

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
	// Not sure if we want multidimensional arraylist or a hashmap
	ArrayList<ArrayList<Square>> grid = new ArrayList<ArrayList<Square>>();
	
	/** Create a new Board
	 * @param fill the board with randomly generated value or not
	 */
	public Board() {
		createBoard(true);
	}
	
	public Board(boolean fill) {
		createBoard(fill);
	}
	
	private void createBoard(boolean fill) {
		// Create the board
		for (int x = 0; x < Board.COLUMN; x++) {
			// Create rows first since we want easy access to columns
			ArrayList<Square> row = new ArrayList<Square>();
			for (int y = 0; y < Board.ROW; y++) {
				row.add(SquareFactory.getSquare(fill));
			}
			// Add the new row to the grid
			grid.add(row);
		}
	}
	
	/**
	 * @param col to get
	 * @return the column of Square
	 */
	public ArrayList<Square> getColumn(int col) {
		try {
			return grid.get(col);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}		
	}
	
	/** Remove all Tile in the board */
	public void clearBoard() {
		for (int x = 0; x < Board.COLUMN; x++) {
			Iterator<Square> i = grid.get(x).iterator();
			while (i.hasNext()) {
				Square s = i.next();
				s.setTile(null);  // Remove the Tile
				i.remove();
			}			
		}		
	}
	
	/** If there is unused space in each column, create new Tile to fill it */
	public void fillBoard() {
		for (int x = 0; x < Board.COLUMN; x++) {
			ArrayList<Square> c = grid.get(x);
			pack(c); // Pack the column
			for (int y = 0; y < Board.ROW; y++) {
				Square s = c.get(y);
				if (s.isEmpty()) {
					s.setTile(TileFactory.getTile());
				} else {
					break;  // Don't want to fill spaces below un-selectable squares
				}
			}
		}		
	}
	
	/** Move all non-empty Square into one contiguous block so we can fill 
	 *  empty space with new Tile
	 *  
	 *  If we hit a non-selectable block, treat it as the bottom of the column
	 *  
	 * @param col
	 */
	void pack(ArrayList<Square> col) {
		/* Find all selectable block, put them on a stack,
		 * clear the column, then put them back from the bottom
		 */	
		int bottom = Board.ROW;
		Stack<Square> stack = new Stack<Square>();		
		for (int y = 0; y < Board.ROW; y++) {
			Square s = col.get(y);
			if (!s.isSelectable()) {
				bottom = y;  // Find bottom of the column
				break;
			} else if (!s.isEmpty()){
				stack.push(s);    // If non-empty, push it on the stack
				s.setTile(null);  // Clear the Tile
			}
		}
		// Fill the column from the bottom
		for (int y = bottom - 1; y >= 0; y--) {
			col.get(y).setTile(stack.pop().getTile());
		}
	}
	
	/** Exchange the Tile between two Squares, even if one is empty
	 * @param s1
	 * @param s2
	 */
	public void swapTile(Square s1, Square s2) {
		Tile t = s1.getTile();
		s1.setTile(s2.getTile());
		s2.setTile(t);
	}

}
