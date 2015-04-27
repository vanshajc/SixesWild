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

	public static Level getLevel(int lvl, IMode mode, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, mode, freq);
	}
	
	public static Level getPuzzleLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Puzzle(), freq);
	}
	
	public static Level getReleaseLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Release(), freq);
	}
	
	public static Level getReleaseLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq, boolean[][] sixLoc) {
		return new Level(lvl, initBoard, winStats, new Release(sixLoc), freq);
	}
	
	public static Level getLightningLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Lightning(), freq);
	}
	
	public static Level getEliminationLevel(int lvl, Board initBoard, Statistics winStats, TileFrequency freq) {
		return new Level(lvl, initBoard, winStats, new Elimination(), freq);
	}
	
}
