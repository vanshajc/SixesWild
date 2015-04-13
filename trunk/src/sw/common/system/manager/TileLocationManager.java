/**
 *  @file   TileLocationManager.java
 *  @author Tony Vu
 *  @since  Apr 12, 2015
 */
package sw.common.system.manager;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import sw.common.model.entity.Board;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;

/** This class keeps track of the location of all the 
 * Tile in the Board 
 */
public class TileLocationManager {
	
	/** The board to manage */
	Board board;
	
	/** We want to be able to get a location from a Tile, and vice versa */
	HashMap<Point, Tile> location = new HashMap<Point, Tile>();

	public TileLocationManager(Board board) {
		this.board = board;
		
		// Start keeping track of the Tile
		for (int x = 0; x < Board.COLUMN; x++) {
			ArrayList<Square> col = board.getColumn(x);
			for (int y = 0; y < Board.ROW; y++) {
				Square s = col.get(y);
				if (!s.isEmpty()) {
					location.put(new Point(x,y), s.getTile());
				}
			}
		}
	}
}
