/**
 *  @file   TileLocationManager.java
 *  @author Tony Vu
 *  @since  Apr 12, 2015
 */
package sw.common.system.manager;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import sw.common.model.entity.Board;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;

/**
 * This class keeps track of the location of all the Tile in the Board
 */
public class TileLocationManager {

	/** The board to manage */
	Board board;

	/** We want to be able to get a location from a Tile, and vice versa */
	HashMap<Point, Tile> location = new HashMap<Point, Tile>();

	public TileLocationManager(){}
	
	public TileLocationManager(Board board) {
		manageBoard(board);
	}

	public void manageBoard(Board board) {
		this.board = board;
		// Start keeping track of the Tile
		for (int x = 0; x < Board.COLUMN; x++) {
			ArrayList<Square> col = board.getColumn(x);
			for (int y = 0; y < Board.ROW; y++) {
				Square s = col.get(y);
				if (!s.isEmpty()) {
					location.put(new Point(x, y), s.getTile());
				}
			}
		}
	}

	/**
	 * @param tile
	 *            the Tile to get the location
	 * @return the location of the Tile
	 */
	public Point getLocation(Tile tile) {
		if (location.containsValue(tile)) {
			Iterator<Entry<Point, Tile>> i = location.entrySet().iterator();
			while (i.hasNext()) {
				Entry<Point, Tile> e = i.next();
				if (e.getValue() == tile) { // has to be the same instance
					return e.getKey();
				}
				i.remove();
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * @param loc
	 *            the location
	 * @return the Tile at that location
	 */
	public Tile getTile(Point loc) {
		if (location.containsKey(loc)) {
			return location.get(loc);
		}
		return null;
	}
}
