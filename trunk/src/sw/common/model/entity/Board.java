/**
 *  @file   Board.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

/** The model for the game board */
public class Board {
	
	/** Default dimension for the board */
	static int COLUMN = 9;
	static int ROW    = 9;
	
	/** The grid of Square */
	Square grid[][] = new Square[Board.ROW][Board.COLUMN];

	public Board() {
		// TODO Auto-generated constructor stub
	}

}
