/**
 *  @file   Tile.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

/** The model for a particular combination of value and score multiplier in the Board */
public class Tile {
	
	int value = 0;
	int multiplier = 0;
	
	public Tile(){}
	
	public Tile(int value, int multiplier) {
		this.value = value;
		this.multiplier = multiplier;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tile) {
			Tile t = (Tile) obj;
			return (value == t.value) &&
					(multiplier == t.multiplier);			
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Value : %d, Multiplier : %d\n", value, multiplier);
	}
	
	
	
}
