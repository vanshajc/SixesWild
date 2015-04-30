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
	
	int scoreOneStar = 0;
	int scoreTwoStar = 0;
	int scoreThreeStar = 0;
	
	public void copy(Statistics s) {
		this.current = s.current;
		this.numMoves = s.numMoves;
		this.score = s.score;
		this.stars = s.stars;
		
		this.scoreOneStar = s.scoreOneStar;
		this.scoreTwoStar = s.scoreTwoStar;
		this.scoreThreeStar = s.scoreThreeStar;
	}
	
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

	public int getScoreOneStar() {
		return scoreOneStar;
	}

	public int getScoreTwoStar() {
		return scoreTwoStar;
	}

	public int getScoreThreeStar() {
		return scoreThreeStar;
	}

	public void setScoreOneStar(int scoreOneStar) {
		this.scoreOneStar = scoreOneStar;
	}

	public void setScoreTwoStar(int scoreTwoStar) {
		this.scoreTwoStar = scoreTwoStar;
	}

	public void setScoreThreeStar(int scoreThreeStar) {
		this.scoreThreeStar = scoreThreeStar;
	}	
	
	
}
