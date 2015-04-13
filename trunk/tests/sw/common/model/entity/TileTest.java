package sw.common.model.entity;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sw.common.model.entity.Tile;
import org.junit.Test;

public class TileTest {

	@Test
	public void tileTest() {
		Tile tile = new Tile(6, 3);
		Tile tile2 = new Tile(8,2);
		
		assertEquals(tile, new Tile(6,3));
		assertEquals(tile.getValue(), 6);
		assertEquals(tile.getMultiplier(), 3);
	}
	

}
