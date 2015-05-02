/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import sw.app.gui.view.GameplayView;
import sw.app.gui.view.LayoutManager;
import sw.common.model.controller.ILevelController;
import sw.common.model.controller.LevelController;
import sw.common.model.entity.Level;
import sw.common.system.factory.LevelFactory;

/** Class to manages the player's progress */
public class LevelManager {

	/** List of available levels */
	protected ArrayList<Integer> sortedLevel = new ArrayList<Integer>();
	protected HashMap<Integer, Level> list = new HashMap<Integer, Level>();
	
	/** List of highscore */
	protected HashMap<Integer, Level> hiScore;
	
	/** Current and highest level reached */
	protected int current;
	protected int highest;
	
	/** The current level controller */
	protected LevelController lCtrl;
	
	/**
	 * Constructor for the level manager.
	 */
	public LevelManager() {
		
		highest = MementoManager.getHighestLevel();
		hiScore = MementoManager.loadProgress();
		
		List<Level> levels = MementoManager.loadPlayableLevel();
		if (levels != null && !levels.isEmpty()) {
			for (Level l : levels) {
				addLevel(l);
			}
			
			// first level is the current level by default
			current = sortedLevel.get(0);
		}

	}
	
	public List<Level> getHighScore() {
		return new ArrayList<Level>(hiScore.values());
	}
	
	/**
	 * Adds a level to the list of levels.
	 * @param lvl the level to be added.
	 */
	public void addLevel(Level lvl) {
		if (lvl != null && !list.containsKey(lvl.getLevelNum())) {
			sortedLevel.add(lvl.getLevelNum());
			Collections.sort(sortedLevel);
			
			list.put(lvl.getLevelNum(), lvl);
		}
	}
	
	/**
	 * Remove all levels.
	 */
	public void clear() {
		list.clear();
	}
	
	/**
	 * @return the current level being played
	 */
	public Level getCurrent() {
		return list.get(current);
	}
	
	/**
	 * @return the next level
	 */
	public Level getNext() {
		// if current is not the last level available...
		if (current < sortedLevel.get(sortedLevel.size() - 1)) {
			return list.get(current + 1);			
		} else {
			return null;
		}
	}
	
	/**
	 * @param l the level
	 * @return the number of the level, null if level is not in list.
	 */
	public Integer getLevelNum(Level l) {
		for (Entry<Integer, Level> entry : list.entrySet()) {
			if (entry.getValue() == l) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	/**
	 * @return the highest level reached by player.
	 */
	public Level getHighestLevel() {
		return list.get(highest);
	}
	
	/**
	 * @return all the levels
	 */
	public ArrayList<Level> getLevels() {
		ArrayList<Level> l = new ArrayList<Level>();
		
		for (Integer i : sortedLevel) {
			l.add(list.get(i));
		}
		
		return l;
	}
	
	public void setHighest(Integer levelNum) {
		if (list.containsKey(levelNum)) {
			highest = levelNum;
		}
	}
	
	/**
	 * Sets the highest level reached
	 * @param level the level to be set as highest
	 */
	public void setHighest(Level level) {
		if (list.containsKey(level.getLevelNum())) {
			highest = level.getLevelNum();
			MementoManager.setHighestLevel(highest);
		}
	}
	
	/**
	 * @return the level controller.
	 */
	public ILevelController getLevelController() {
		return lCtrl;
	}
	
	/**
	 * Sets the current level
	 * @param lvl the level to be set as current.
	 */
	public void setCurrent(Level lvl) {
		if (list.containsValue(lvl)) {
			current = getLevelNum(lvl);
			if (LayoutManager.getCurrentView() instanceof GameplayView) {
				GameplayView gpv = (GameplayView) LayoutManager.getCurrentView();
				Level l = LevelFactory.copyLevel(getCurrent());
				lCtrl = new LevelController(l, gpv);
			} else {
				lCtrl = null;
				throw new IllegalStateException("Hasn't switched to gameplay view!");
			}
		}
	}
	
	/**
	 * Starts the current level.
	 */
	public void startLevel() {
		if (lCtrl != null) {
			lCtrl.startGame();
		}
	}
	
	/**
	 * Unlocks the next level.
	 */
	public void unlockNextLevel() {
		// Unlock next level
		Level next = getNext();
		if (next != null) {
			setHighest(next);
		}
		
		// Save high score
		Level c = getLevelController().getLevel();
		if (hiScore.containsKey(c.getLevelNum())) {
			Level p = hiScore.get(c.getLevelNum());
			//Level p = 
			if (c.getGame().getStats().getScore() > p.getGame().getStats().getScore()) {
				hiScore.remove(c.getLevelNum());
			}
		}
		hiScore.put(c.getLevelNum(), c);

		MementoManager.saveLevel(c);
	}

}
