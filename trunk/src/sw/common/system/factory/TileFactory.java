/**
 *  @file   TileFrequencyFactory.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.factory;

import sw.common.model.entity.Tile;

/** Creates Tiles depends on the TileFrequency */
public class TileFactory {
	
	/** Probability of each value and multiplier to appear in the game */
	static TileFrequency frequencies = new TileFrequency();	
	
	/**
	 * @param freq the new frequencies
	 */
	static public void setFreq(TileFrequency freq) {
		TileFactory.frequencies = freq;
	}
	
	/**
	 * @return a Tile generated based on the frequencies
	 */
	static public Tile createTile() {		
		return new Tile(frequencies.nextVal(), frequencies.nextMul());
	}

}
