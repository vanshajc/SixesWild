/**
 * @file LevelFactory.java
 * @date Apr 14, 2015 8:39:04 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.factory;

import sw.common.model.controller.IMode;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.mode.Elimination;
import sw.mode.Lightning;
import sw.mode.Puzzle;
import sw.mode.Release;

/** Factory model for Level objects */
public class LevelFactory {

	/**
	 * @param lvl level number
	 * @param mode the mode of the level
	 * @param initBoard the board for the level
	 * @param winStats the win conditions for the level
	 * @param freq the tile frequencies for the level
	 * @return the Level with the given parameters.
	 */
	public static Level getLevel(int lvl, IMode mode, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, mode, freq);
	}
	
	/**
	 * @param lvl the level to be copied
	 * @return the copied version of the level
	 */
	public static Level copyLevel(Level lvl) {
		Level l = null;
		if (lvl.getMode() instanceof Puzzle) {
			l = getPuzzleLevel(lvl.getLevelNum(), lvl.getInitBoard(), lvl.getWinStats(), lvl.getTileFrequency());
			l.getGame().copy(lvl.getGame());
		} else if (lvl.getMode() instanceof Release) {
			l = getReleaseLevel(lvl.getLevelNum(), lvl.getInitBoard(), lvl.getWinStats(), lvl.getTileFrequency());
			l.getGame().copy(lvl.getGame());
		} else if (lvl.getMode() instanceof Lightning) {
			l = getLightningLevel(lvl.getLevelNum(), lvl.getInitBoard(), lvl.getWinStats(), lvl.getTileFrequency());
			l.getGame().copy(lvl.getGame());
		} else if (lvl.getMode() instanceof Elimination) {
			l = getEliminationLevel(lvl.getLevelNum(), lvl.getInitBoard(), lvl.getWinStats(), lvl.getTileFrequency());
			l.getGame().copy(lvl.getGame());
		}
		return l;
	}
	
	/**
	 * @param lvl level number
	 * @param initBoard the board for the level
	 * @param winStats the win conditions for the level
	 * @param freq the tile frequencies for the level
	 * @return the puzzle level
	 */
	public static Level getPuzzleLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Puzzle(), freq);
	}
	
	/**
	 * @param lvl level number
	 * @param initBoard the board for the level
	 * @param winStats the win conditions for the level
	 * @param freq the tile frequencies for the level
	 * @return the release level.
	 */
	public static Level getReleaseLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Release(), freq);
	}
	
	/**
	 * @param lvl level number
	 * @param initBoard the board for the level
	 * @param winStats the win conditions for the level
	 * @param freq the tile frequencies for the level
	 * @return the lightning level
	 */
	public static Level getLightningLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Lightning(), freq);
	}
	
	/**
	 * @param lvl level number
	 * @param initBoard the board for the level
	 * @param winStats the win conditions for the level
	 * @param freq the tile frequencies for the level
	 * @return the elimination level
	 */
	public static Level getEliminationLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Elimination(), freq);
	}
	
}
