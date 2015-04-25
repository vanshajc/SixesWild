package sw.common.model.entity;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sw.common.system.factory.TileFactory;

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
		
		assertTrue(board.isValidX(4));
		assertFalse(board.isValidX(10));
		assertFalse(board.isValidX(-1));
		
		assertTrue(board.isValidY(8));
		assertFalse(board.isValidY(10));
		assertFalse(board.isValidY(-6));
		
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
				assertEquals(p, board.getPoint(t));
				
				board.remove(p);
				assertTrue(board.isEmpty(p));
				
				assertNull(board.getTile(p));
				assertNull(board.getPoint(t));
				
				assertEquals(--count, board.count());
			}
		}
		
		Tile t1 = TileFactory.getTile();
		board.replace(new Point(4,7), t1);
		assertEquals(t1, board.getTile(new Point(4,7)));
		
	}
	
	@Test
	public void testPack() {
		Column c = board.getColumn(1);
		assertNotNull(c);
		
		Tile t3 = c.getTile(3);
		Tile t4 = c.getTile(4);
		Tile t5 = c.getTile(5);		
		
		assertTrue(c.removeTile(6));
		assertTrue(c.removeTile(7));
		assertTrue(c.removeTile(8));
		
		c.pack();
		assertEquals(t3, c.getTile(6));
		assertEquals(t4, c.getTile(7));
		assertEquals(t5, c.getTile(8));
	}
	
	@Test
	public void testSelect() {
		board.select(new Point(0,0));
		board.select(new Point(0,1));
		
		Queue<Square> sq = board.getSelectedSquare();
		assertEquals(2, sq.size());
		
		Queue<Tile> tq = board.getSelectedTile();
		assertEquals(2, tq.size());
		
		Square s = sq.remove();
		Tile t = tq.remove();
		assertTrue(s.isSelected());
		assertEquals(s, board.getSquare(new Point(0,0)));
		assertEquals(t, board.getTile(new Point(0,0)));
		assertTrue(s.getTile() == t);
		
		s = sq.remove();
		t = tq.remove();
		assertTrue(s.isSelected());
		assertEquals(s, board.getSquare(new Point(0,1)));
		assertEquals(t, board.getTile(new Point(0,1)));
		assertTrue(s.getTile() == t);
		
		board.clearSelection();
		assertEquals(0, board.getSelectedSquare().size());
		
		board.select(new Point(0,0));
		board.select(new Point(0,1));
		
		sq = board.getSelectedSquare();
		assertEquals(2, sq.size());		
		tq = board.getSelectedTile();
		assertEquals(2, tq.size());
	}

}
