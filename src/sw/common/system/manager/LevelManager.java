/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.manager;

import java.util.ArrayList;

import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;
import sw.mode.Elimination;
import sw.mode.Lightning;
import sw.mode.Puzzle;
import sw.mode.Release;

/**
 *
 */
public class LevelManager {

	ArrayList<Level> list = new ArrayList<Level>();
	
	int current;
	int highest = 4;
	
	public LevelManager() {
		// Load available levels from resource classpath
		
		// For now, just manually creates new Levels
		int lvlCount = 0;
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getLightningLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getEliminationLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, new Statistics()));
		list.add(LevelFactory.getLightningLevel(++lvlCount, new Statistics()));
		
		// first level is the current level by default
		current = 0;
	}
	
	public Level getCurrent() {
		return list.get(current);
	}
	
	public Level getNext() {		
		if (current < list.size() - 1) {
			return list.get(current + 1);			
		} else {
			return null;
		}
	}
	
	public Level getHighestLevel() {
		return list.get(highest);
	}
	
	public ArrayList<Level> getLevels() {
		return list;
	}
	
	public void setCurrent(Level level) {
		if (list.contains(level)) {
			current = list.indexOf(level);
		}
	}
	
	public void setHighest(Level level) {
		if (list.contains(level)) {
			highest = list.indexOf(level);			
		}
	}

}
