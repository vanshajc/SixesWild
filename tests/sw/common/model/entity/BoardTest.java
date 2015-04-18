package sw.common.model.entity;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;

public class BoardTest {

	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();  // Create new board and fill it
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/** Test IBoard interface */
	
	@Test
	public void testIBoard() {
		assertEquals(new Dimension(9,9), board.size());		
		assertEquals(81, board.count());
		
		board.clear();
		assertEquals(0, board.count());
		
		board.fill();
		assertEquals(81, board.count());
	}

	@Test
	public void testIBoardLocationManage() {
		int count = board.count();
		
		Point fake1 = new Point(11,9);
		Point fake2 = new Point(8,11);
		assertFalse(board.isValidPoint(fake1));
		assertFalse(board.isValidPoint(fake2));
		
		assertFalse(board.remove(fake1));
		assertFalse(board.remove(fake2));
		
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				Point p = new Point(x,y);
				assertTrue(board.isValidPoint(p));
				
				Tile t = board.getTile(p);
				
				board.remove(p);
				assertTrue(board.isEmpty(p));
				
				assertNull(board.getTile(p));
				assertNull(board.getPoint(t));
				
				assertEquals(--count, board.count());
			}
		}
		
	}

}
