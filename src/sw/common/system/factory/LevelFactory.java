/**
 * @file LevelFactory.java
 * @date Apr 14, 2015 8:39:04 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.factory;

import sw.common.model.controller.IMode;
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.mode.Elimination;
import sw.mode.Lightning;
import sw.mode.Puzzle;
import sw.mode.Release;

/** Factory model for Level objects */
public class LevelFactory {

	public static Level getLevel(int lvl, IMode mode, Statistics winStats) {
		return new Level(lvl, winStats, mode);
	}
	
	public static Level getPuzzleLevel(int lvl, Statistics winStats) {
		return new Level(lvl, winStats, new Puzzle());
	}
	
	public static Level getReleaseLevel(int lvl, Statistics winStats) {
		return new Level(lvl, winStats, new Release());
	}
	
	public static Level getLightningLevel(int lvl, Statistics winStats) {
		return new Level(lvl, winStats, new Lightning());
	}
	
	public static Level getEliminationLevel(int lvl, Statistics winStats) {
		return new Level(lvl, winStats, new Elimination());
	}
	
}
