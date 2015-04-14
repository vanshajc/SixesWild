/**
 *  @file   TileFactoryTest.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.factory;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;

/**
 * 
 */
public class TileFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTileTest() {
		int run = 10;
		for (int i = 0; i < run; i++) {
			Tile tile1 = TileFactory.getTile();
			assertNotNull(tile1);
			
			assertNotEquals(0, tile1.getValue());
			assertTrue((tile1.getValue() >= 1) && (tile1.getValue() <= 6));
			
			assertNotEquals(0, tile1.getMultiplier());
			assertTrue((tile1.getMultiplier() >= 1) && (tile1.getMultiplier() <= 3));
		}
	}
	
	/** Get same position for 2 Square instances with same value */
	@Test
	public void hashMapSquarePositionTest() {
		Tile t = TileFactory.getTile();
		Square s1 = new Square(t);
		Square s2 = new Square(t);
		Point test = new Point(0,9);
		
		HashMap<Square, Point> map = new HashMap<Square, Point>();
		map.put(s1, test);
		
		Point test1 = map.get(s2);
		assertEquals(0, test1.x);
		assertEquals(9, test1.y);
	}
	
	/** 2 different Tile instances with same value get different location */
	@Test
	public void hashMapTwoTilePositionTest() {
		Tile t1 = new Tile(1,1);
		Tile t2 = new Tile(1,1);
	}

}
