/**
 *  @file   TileFrequency.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.factory;

import java.util.HashMap;
import java.util.Random;

import sw.common.model.entity.Tile;

/** The model to describe the frequency of each value and multiplier appearing in the level */
public class TileFrequency {
	
	/** Probability of each value to appear in the level */
	HashMap<Integer, Double> valFreq = new HashMap<Integer, Double>();
	
	/** Probability of each multiplier value to appear in the level */
	HashMap<Integer, Double> mulFreq = new HashMap<Integer, Double>();
	
	/** Random number generator */
	static Random rand = new Random();
	
	/**
	 * Construct a tile frequency with equal chance for all values.
	 */
	public TileFrequency() {		
		double val  = 100.0 / Tile.maxValue;      // Equal frequency for each value
		double mult = 100.0 / Tile.maxMultiplier; // Equal frequency for each multiplier
		
		HashMap<Integer, Double> vhm = new HashMap<Integer, Double>();
		for (int i = Tile.minValue; i <= Tile.maxValue; i++) {
			vhm.put(i, val);
		}
		
		HashMap<Integer, Double> mhm = new HashMap<Integer, Double>();
		for (int i = Tile.minMultiplier; i <= Tile.maxMultiplier; i++) {
			mhm.put(i, mult);
		}
		
		setValFreq(vhm);
		setMulFreq(mhm);
	}
	
	/**
	 * Construct a TileFrequency with the given value and multiplier frequency
	 * @param valFreq the map for each tile value to the frequency
	 * @param mulFreq the map for each multiplier to the frequency
	 */
	public TileFrequency(HashMap<Integer, Double> valFreq, HashMap<Integer, Double> mulFreq) {
		setValFreq(valFreq);
		setMulFreq(mulFreq);
	}
	
	/**
	 * @param valFreq the map from each value to frequency
	 * @return if valid set.
	 */
	public boolean setValFreq(HashMap<Integer, Double> valFreq) {
		double sum = 0;
		
		this.valFreq.clear();
		this.valFreq.put(0, 0.0);
		
		for (int i = Tile.minValue; i <= Tile.maxValue; i++) {
			if (valFreq.containsKey(i)) {
				sum += valFreq.get(i);
				if (sum > 100.00) {
					this.valFreq.put(i, Math.floor(sum)); // round down
				} else {
					this.valFreq.put(i, sum); // save the percentile
				}
			} else {
				break;
			}
		}
		// the total must be 100
		if (Math.floor(sum) != 100) {
			valFreq.clear();
			return false;
		}
		return true;
	}
	
	/**
	 * @param mulFreq map from each multiplier to its frequency
	 * @return if the set was valid
	 */
	public boolean setMulFreq(HashMap<Integer, Double> mulFreq) {
		double sum = 0;
		
		this.mulFreq.clear();
		this.mulFreq.put(0, 0.0);
		
		for (int i = Tile.minMultiplier; i <= Tile.maxMultiplier; i++) {
			if (mulFreq.containsKey(i)) {
				sum += mulFreq.get(i);
				if (sum > 100.00) {
					this.mulFreq.put(i, Math.floor(sum)); // round down
				} else {
					this.mulFreq.put(i, sum); // save the percentile
				}
				
			} else {
				break;
			}
		}
		// the total must be 100
		if (Math.floor(sum) != 100.00) {
			mulFreq.clear();
			return false;
		}
		return true;
	}
	
	/**
	 * @param i the Tile value
	 * @return frequency of i appearing in the level
	 */
	public double getValFreq(int i) {
		try {
			return valFreq.get(i);
		} catch (IndexOutOfBoundsException e) {
			return 0.0;		
		} 
	}
	
	/**
	 * @param i the Tile multiplier value
	 * @return frequency of i appearing in the level
	 */
	public double getMulFreq(int i) {
		try {
			return mulFreq.get(i);
		} catch (IndexOutOfBoundsException e) {
			return 0.0;			
		}
	}
	
	/**
	 * @return the next value to appear
	 */
	int nextVal() {
		double f0, f1;
		double freq = rand.nextDouble() * 100;
		
		for (int i = Tile.minValue; i <= Tile.maxValue; i++) {
			f1 = getValFreq(i);
			f0 = getValFreq(i-1);
			if (freq > f0 && freq < f1) {
				return i;
			}
		}
		return 0;
	}	
	
	/**
	 * @return the next multiplier value to appear
	 */
	int nextMul() {
		double f0, f1;
		double freq = rand.nextDouble() * 100;
		
		for (int i = Tile.minMultiplier; i <= Tile.maxMultiplier; i++) {
			f1 = getMulFreq(i);
			f0 = getMulFreq(i-1);
			if (freq > f0 && freq < f1) {
				return i;
			}
		}
		return 0;
	}
	
}

