/**
 *  @file   Statistics.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

import java.sql.Time;

/**
 * 
 */
public class Statistics {
	
	Time current = Time.valueOf("00:00:00");
	int numMoves = 0;
	int score = 0;
	int stars = 0;
	
	/**
	 * @return the current
	 */
	public Time getTime() {
		return current;
	}
	
	public void setTime(Time t) {
		current = t;
	}
	
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setCurrent(Time current) {
		this.current = current;
	}

	public void setNumMoves(int delta) {
		this.numMoves += delta;
	}

	public void setScore(int delta) {
		this.score += delta;
	}

	/**
	 * @return the numMoves
	 */
	public int getNumMoves() {
		return numMoves;
	}
	
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}	
	
	public int getStar() {
		return stars;
	}
	
}
