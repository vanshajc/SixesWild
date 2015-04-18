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
		double valPercentage[] = {0, 0, 0, 0, 0, 0, 0};  // use value as index, so add 1 extra space 
		double mulPercentage[] = {0, 0, 0, 0};
		
		int run = 100000;
		for (int i = 0; i < run; i++) {
			Tile tile1 = TileFactory.getTile();
			assertNotNull(tile1);
			
			assertTrue((tile1.getValue() >= 1) && (tile1.getValue() <= 6));			
			assertTrue((tile1.getMultiplier() >= 1) && (tile1.getMultiplier() <= 3));
			
			valPercentage[tile1.getValue()]++;
			mulPercentage[tile1.getMultiplier()]++;
		}
		
		for (int i = 1; i <= 6; i++) {
			assertEquals(16.67, valPercentage[i] / (double) run * 100, 1.00);
		}
		for (int i = 1; i <= 3; i++) {
			assertEquals(33.33, mulPercentage[i] / (double) run * 100, 1.00);
		}
		
	}

}
