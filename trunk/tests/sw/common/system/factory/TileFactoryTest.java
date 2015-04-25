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
		TileFactory.setFreq(new TileFrequency());
	}
	
	@Test
	public void getTileTestManual() {
		HashMap<Integer, Double> valFreq = new HashMap<Integer, Double>();
		valFreq.put(1, 20.0);
		valFreq.put(2, 20.0);
		valFreq.put(3, 20.0);
		valFreq.put(4, 20.0);
		valFreq.put(5, 20.0);
		valFreq.put(6, 0.0);
		
		HashMap<Integer, Double> mulFreq = new HashMap<Integer, Double>();
		mulFreq.put(1, 83.5);
		mulFreq.put(2, 16.5);
		mulFreq.put(3, 0.0);
		
		TileFrequency freq = new TileFrequency(valFreq, mulFreq);
		TileFactory.setFreq(freq);
		
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
			assertEquals(valFreq.get(i), valPercentage[i] / (double) run * 100, 1.00);
		}
		for (int i = 1; i <= 3; i++) {
			assertEquals(mulFreq.get(i), mulPercentage[i] / (double) run * 100, 1.00);
		}
		
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
	
	@Test
	public void testGetTile() {
		Tile t1 = TileFactory.getTile(6, 2);
		assertNotNull(t1);
		assertEquals(6, t1.getValue());
		assertEquals(2, t1.getMultiplier());
		
		Tile t2 = TileFactory.getTile(t1);
		assertNotNull(t2);
		assertTrue(t2.equals(t1));
		
		Tile t3 = TileFactory.getTile(6, 9);
		assertNull(t3);
	}

}
