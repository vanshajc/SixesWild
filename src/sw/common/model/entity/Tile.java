/**
 *  @file   Tile.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

/**
 * The model for a particular combination of value and score multiplier in the
 * Board
 */
public class Tile {

	/** Holds the value and multiplier for the tile. */
	int value = 0;
	int multiplier = 0;

	/** Holds the max and min value and multipliers.  */
	public static final int minValue = 1;
	public static final int maxValue = 6;
	public static final int minMultiplier = 1;
	public static final int maxMultiplier = 3;	

	/**
	 * Construct a Tile.
	 * @param value the value for the tile.
	 * @param multiplier the multilplier for the tile.
	 */
	public Tile(int value, int multiplier) {		
		if ((value >= minValue && value <= maxValue) &&
				(multiplier >= minMultiplier && multiplier <= maxMultiplier)) {
			this.value = value;
			this.multiplier = multiplier;
		} else {
			throw new IllegalArgumentException("Value and/or Multiplier invalid!");
		}
	}

	public Tile() {
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the multiplier
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * @param t the Tile to copy
	 */
	public void copy(Tile t) {
		value = t.value;
		multiplier = t.multiplier;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Value : %d, Multiplier : %d\n", value, multiplier);
	}


	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (value + 142) * multiplier; 
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			Tile t = (Tile) o;
			return (this.value == t.value) && (this.multiplier == t.multiplier);
		}
		return false;
	}

}
