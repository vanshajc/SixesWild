/**
 * @file Level.java
 * @date Apr 11, 2015 4:38:38 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.model.entity;

import java.util.Stack;

import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.IMoveManager;

/** The model for an arbitrary game level */
public class Level implements IMoveManager {

	Game game = null;
	Statistics winStats;
	IMode mode;
	int levelNum;
	
	// The initial layout of the Board
	Board initBoard;

	Stack<IMove> moves = new Stack<IMove>();

	public Level(int levelNum, Board initBoard, Statistics winStats, IMode mode) {
		this.winStats = winStats;
		this.mode = mode;
		this.levelNum = levelNum;
		this.initBoard = initBoard;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		if (game == null) {
			initialize();
		}
		return game;
	}

	/**
	 * @return the winStats
	 */
	public Statistics getWinStats() {
		return winStats;
	}

	/**
	 * @return the mode
	 */
	public IMode getMode() {
		return mode;
	}

	public int getStars() {
		return 1;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public void initialize() {
		game = new Game();
		game.board.copy(initBoard);
	}

	public boolean hasWon() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return mode.toString().concat(" ".concat(Integer.toString(levelNum)));
	}

	public void pushMove(IMove move) {
		if (move.doMove()) {
			moves.push(move);
		}
	}

	public void undoMove() {
		if (!moves.isEmpty()) {
			if (moves.peek().undoMove()) {
				moves.pop();
			}
		}
	}

	@Override
	public int countMove() {
		return moves.size();
	}

	public void updateScore(int delta) {
		game.stats.score += delta;
	}

}
