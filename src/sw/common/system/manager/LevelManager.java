/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import sw.app.gui.view.LayoutManager;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;

/**
 *
 */
public class LevelManager implements ActionListener {

	ArrayList<Level> list = new ArrayList<Level>();
	
	int current;
	int highest = 4;
	
	// Load initial board layouts
	Board initBoard = new Board();
	
	LayoutManager lm;
	
	public LevelManager(LayoutManager lm) {
		this.lm = lm;
		
		boolean[][] bottomSix = new boolean[9][9];
		for (int i = 8; i<9; i++)
			bottomSix[i][8] = true;
		
		// Load available levels from resource classpath
		
		// For now, just manually creates new Levels
		int lvlCount = 0;
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, initBoard, new Statistics(), bottomSix));
		list.add(LevelFactory.getLightningLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getEliminationLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getPuzzleLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getReleaseLevel(++lvlCount, initBoard, new Statistics()));
		list.add(LevelFactory.getLightningLevel(++lvlCount, initBoard, new Statistics()));
		
		// first level is the current level by default
		current = 0;
		
		// set game finished listener
		for (Level l : list) {
			l.setListener(this);
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof Level) {
			String str = e.getActionCommand();
			if (str.equals(Level.strFinished)) {
				lm.switchToPostGameView();
			} else if (str.equals(Level.strWon)) {
				
				lm.switchToPostGameView();
			}
		}		
	}

}
