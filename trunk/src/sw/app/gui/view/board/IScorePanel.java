package sw.app.gui.view.board;

/**
 * @file IScorePanel.java
 * @author Vanshaj Chowdhary, Trung-Nghia N. Huynh.
 */

/**
 * Interface for the score panel
 */
public interface IScorePanel {

	/**
	 * @param max sets the max score
	 */
	void setMaximum(int max);

	/**
	 * @param min sets the min score
	 */
	void setMinimum(int min);

	/**
	 * @param score sets the current score
	 */
	void setScore(int score);

	/**
	 * @param location the string location of the star
	 */
	void setStarImage(String location);

	/**
	 * @param numStar the number of stars
	 */
	void setStar(int numStar);

}