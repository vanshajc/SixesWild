/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.manager;

import java.sql.Time;
import java.util.ArrayList;

import sw.app.gui.view.GameplayView;
import sw.app.gui.view.LayoutManager;
import sw.common.model.controller.ILevelController;
import sw.common.model.controller.LevelController;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;

/** Class to manages the player's progress */
public class LevelManager {

	/** List of available levels */
	protected ArrayList<Level> list = new ArrayList<Level>();
	
	/** Current and highest level reached */
	protected int current;
	protected int highest = 4;
	
	/** Load initial board layouts */
	protected Board initBoard = new Board();
	
	/** The current level controller */
	protected LevelController lCtrl;
	
	public LevelManager() {
		
		// Load available levels from resource classpath
		
		// For now, just manually creates new Levels
		int lvlCount = 0;
		
		Statistics lightningStats = new Statistics();
		lightningStats.setTime(Time.valueOf("00:00:10"));
		
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getLightningLevel(++lvlCount, initBoard, lightningStats));
		list.add(LevelFactory.getEliminationLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getLightningLevel(++lvlCount, initBoard, lightningStats));
		
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
	
	public void setHighest(Level level) {
		if (list.contains(level)) {
			highest = list.indexOf(level);			
		}
	}
	
	public ILevelController getLevelController() {
		return lCtrl;
	}
	
	public void setCurrent(Level lvl) {
		if (list.contains(lvl)) {
			current = list.indexOf(lvl);
			if (LayoutManager.getCurrentView() instanceof GameplayView) {
				GameplayView gpv = (GameplayView) LayoutManager.getCurrentView();
				lCtrl = new LevelController(getCurrent(), gpv);
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

}
