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

	int value = 0;
	int multiplier = 0;

	public Tile() {
	}

	public Tile(int value, int multiplier) {
		if(value >= 1 && value <= 6){
			this.value = value;
		}
		else{
			System.err.println("Value out of bounds");
		}
		if(multiplier >= 1 && multiplier  <= 3){
			this.multiplier = multiplier;
		}
		else{
			System.err.println("Multiplier out of bounds");
		}
		
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

	// Can't override this, Hashmap will use this to find a match
	// we want to find the exact instance of this object, not another
	// instance with the same value
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	// @Override
	// public boolean equals(Object obj) {
	// if (obj instanceof Tile) {
	// Tile t = (Tile) obj;
	// return (value == t.value) &&
	// (multiplier == t.multiplier);
	// }
	// return false;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Value : %d, Multiplier : %d\n", value, multiplier);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			if ((this.value == ((Tile) o).value)
					&& this.multiplier == ((Tile) o).multiplier) {
				return true;
			}
		}
		return false;
	}

}
