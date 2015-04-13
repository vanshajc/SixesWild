/**
 *  @file   TileFactoryTest.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.factory;

import static org.junit.Assert.*;

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
	public void uninitializeTest() {
		int run = 10;
		for (int i = 0; i < run; i++) {
			Tile tile1 = TileFactory.getTile();
			assertNotNull(tile1);		
			System.out.print(tile1.toString());
		}
	}
	
	@Test
	public void hashMapTest() {
		Tile t = TileFactory.getTile();
		Square s1 = new Square(t);
		Square s2 = new Square(t);
		int test = 81;
		
		HashMap<Square, Integer> map = new HashMap<Square, Integer>();
		map.put(s1, test);
		
		int test1 = map.get(s2);
		assertEquals(81, test1);
	}

}
