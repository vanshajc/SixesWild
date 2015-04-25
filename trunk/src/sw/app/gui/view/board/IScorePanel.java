package sw.app.gui.view.board;

public interface IScorePanel {

	void setMaximum(int max);

	void setMinimum(int min);

	void setScore(int score);

	void setStarImage(String location);

	void setStar(int numStar);

}