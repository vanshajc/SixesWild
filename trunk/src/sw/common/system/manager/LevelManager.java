/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
	
	/** Current and highest level reached */
	protected int current;
	protected int highest;
	
	/** The current level controller */
	protected LevelController lCtrl;
	
	public LevelManager() {
		
		// Load available levels from resource classpath		
		try {
			List<Level> levels = MementoManager.loadMemento();
			if (levels != null && !levels.isEmpty()) {
				for (Level l : levels) {
					addLevel(l);
				}
				
				// first level is the current level by default
				current = sortedLevel.get(0);
				highest = current;
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	void addLevel(Level lvl) {
		if (lvl != null && !list.containsKey(lvl.getLevelNum())) {
			sortedLevel.add(lvl.getLevelNum());
			Collections.sort(sortedLevel);
			
			list.put(lvl.getLevelNum(), lvl);
		}
	}
	
	void clear() {
		list.clear();
	}
	
	public Level getCurrent() {
		return list.get(current);
	}
	
	public Level getNext() {
		// if current is not the last level available...
		if (current < sortedLevel.get(sortedLevel.size() - 1)) {
			return list.get(current + 1);			
		} else {
			return null;
		}
	}
	
	public Integer getLevelNum(Level l) {
		for (Entry<Integer, Level> entry : list.entrySet()) {
			if (entry.getValue() == l) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public Level getHighestLevel() {
		return list.get(highest);
	}
	
	public ArrayList<Level> getLevels() {
		ArrayList<Level> l = new ArrayList<Level>();
		
		for (Integer i : sortedLevel) {
			l.add(list.get(i));
		}
		
		return l;
	}
	
	public void setHighest(Level level) {
		if (list.containsKey(level.getLevelNum())) {
			highest = level.getLevelNum();
		}
	}
	
	public ILevelController getLevelController() {
		return lCtrl;
	}
	
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
	
	public void startLevel() {
		if (lCtrl != null) {
			lCtrl.startGame();
		}
	}
	
	public void unlockNextLevel() {
		Level next = getNext();
		if (next != null) {
			setHighest(next);
		}
		
		try {
			MementoManager.saveProgress();
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
