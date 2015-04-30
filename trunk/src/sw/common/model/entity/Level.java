/**
 * @file Level.java
 * @date Apr 11, 2015 4:38:38 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.model.entity;

import java.awt.event.ActionListener;
import java.sql.Time;

import sw.common.model.controller.IGameController;
import sw.common.model.controller.ILevelController;
import sw.common.model.controller.IMode;
import sw.common.system.factory.TileFactory;
import sw.common.system.factory.TileFrequency;

/** The model for an arbitrary game level */
public class Level {
	
	/** Holds the current game being played. */
	Game game;
	
	/** Holds the winning statistics for the level. */
	Statistics winStats;
	
	/** Holds the mode of the level. */
	IMode mode;
	
	int levelNum;

	/** Holds the Frequencies for each Tile. */
	TileFrequency freq;
	
	/** Holds the board for the level. */
	Board initBoard;

	public Level(int levelNum, Board initBoard, Statistics winStats, IMode mode, TileFrequency freq) {
		this.winStats = winStats;
		this.mode = mode;
		this.levelNum = levelNum;
		this.initBoard = initBoard;
		this.freq = freq;
		
		this.game = new Game();
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
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

	/**
	 * @return the stars earned for the level
	 */
	public int getStars() {
		if (game.stats.score >= winStats.scoreThreeStar) {
			return 3;
		} else if (game.stats.score >= winStats.scoreTwoStar) {
			return 2;
		} else if (game.stats.score >= winStats.scoreOneStar) {
			return 1;
		}			
		return 0;
	}
	
	/**
	 * @return the board of level
	 */
	public Board getInitBoard() {
		return initBoard;
	}

	/**
	 * @return the frequencies of the tiles
	 */
	public TileFrequency getTileFrequency() {
		return freq;
	}
	
	/**
	 * @return the level number
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * Initializes the level.
	 * @param lc the level controller
	 */
	public void initialize(ILevelController lc) {
		IGameController gc = lc.getGameController();
		
		game.stats = new Statistics();
		if (mode.getTimerPolicy() == IMode.TIMER_POLICY.COUNT_DOWN) {
			gc.setTime(winStats.getTime(), true);
			if (mode instanceof ActionListener) {
				gc.setAlarm(Time.valueOf("00:00:00"), (ActionListener) mode);
			} else {
				System.err.println("Mode with COUNT_DOWN policy does not handle timeout event!");
			}
		} else {
			gc.setTime(winStats.getTime(), false);
		}
		
		game.stats.setNumMoves(winStats.getNumMoves());
		
		//lc.getMovePanel().setMove(winStats.numMoves);
		
		mode.initializeGame(gc);
		
		game.board.copy(initBoard);
		
		TileFactory.setFreq(freq);
	}

	/** 
	 * @return if the user has won the level
	 */
	public boolean hasWon() {
		return mode.hasFinished(game, winStats) && this.getStars()>0;
	}

	/**(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return mode.toString().concat(" ".concat(Integer.toString(levelNum)));
	}

}
