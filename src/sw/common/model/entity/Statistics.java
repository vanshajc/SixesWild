/**
 *  @file   Statistics.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

import java.sql.Time;

/**
 * Class for representing Statistics.
 */
public class Statistics {
	
	Time current = Time.valueOf("00:00:00");
	int numMoves = 0;
	int score = 0;
	int stars = 0;
	
	int scoreOneStar = 0;
	int scoreTwoStar = 0;
	int scoreThreeStar = 0;
	
	/**
	 * @param s the stats to be copied.
	 */
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
	
	/**
	 * @param t the time to be set
	 */
	public void setTime(Time t) {
		current = t;
	}
	
	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * @param stars the new number of stars
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}

	/**
	 * @param delta the change in number of moves
	 */
	public void setNumMoves(int delta) {
		this.numMoves += delta;
	}

	/**
	 * @param delta the change in score
	 */
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

	/**
	 * @return the score for getting 1 star.
	 */
	public int getScoreOneStar() {
		return scoreOneStar;
	}

	/**
	 * @return the score for getting 2 stars
	 */
	public int getScoreTwoStar() {
		return scoreTwoStar;
	}

	/**
	 * @return the score for getting 3 stars
	 */
	public int getScoreThreeStar() {
		return scoreThreeStar;
	}

	/**
	 * @param scoreOneStar the score needed for 1 star
	 */
	public void setScoreOneStar(int scoreOneStar) {
		this.scoreOneStar = scoreOneStar;
	}

	/**
	 * @param scoreTwoStar the score needed for 2 stars
	 */
	public void setScoreTwoStar(int scoreTwoStar) {
		this.scoreTwoStar = scoreTwoStar;
	}

	/**
	 * @param scoreThreeStar the score needed for 3 stars
	 */
	public void setScoreThreeStar(int scoreThreeStar) {
		this.scoreThreeStar = scoreThreeStar;
	}	
	
	
}
