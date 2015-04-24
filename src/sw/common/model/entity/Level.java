/**
 * @file Level.java
 * @date Apr 11, 2015 4:38:38 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.model.entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.IMoveManager;

/** The model for an arbitrary game level */
public class Level implements IMoveManager {
	
	public final static String strFinished = "finished";
	public final static String strWon      = "won";

	Game game = null;
	Statistics winStats;
	IMode mode;
	int levelNum;

	// The initial layout of the Board
	Board initBoard;

	ActionListener al = null;
	
	Boolean hasFinished = false;

	Stack<IMove> moves = new Stack<IMove>();

	public Level(int levelNum, Board initBoard, Statistics winStats, IMode mode) {
		this.winStats = winStats;
		this.mode = mode;
		this.levelNum = levelNum;
		this.initBoard = initBoard;
		this.game = new Game();
	}

	public void setListener(ActionListener al) {
		if (al != null) {
			this.al = al;
		}
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
		hasFinished = false;
		
		game.stats = new Statistics();
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
			game.stats.numMoves++;
			moves.push(move);
			if (mode.hasFinished(game, winStats)) {
				hasFinished = true;
			}
		}
	}

	public void undoMove() {
		if (!moves.isEmpty()) {
			if (moves.peek().undoMove()) {
				game.stats.numMoves--;
				moves.pop();
			}
		}
	}

	@Override
	public int countMove() {
		return game.stats.numMoves;
	}

	public void updateScore(int delta) {
		game.stats.score += delta;
	}

	@Override
	public boolean hasFinished() {
		return hasFinished;
	}

	@Override
	public void finishGame() {
		if (hasFinished && al != null) {
			String msg = hasWon() ? strWon : strFinished;
			al.actionPerformed(new ActionEvent(this, 0, msg));
		}		
	}

}
