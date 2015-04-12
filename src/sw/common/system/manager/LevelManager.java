/**
 * @file LevelManager.java
 * @date Apr 12, 2015 12:51:53 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.system.manager;

import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.mode.release.Release;

/**
 *
 */
public class LevelManager {
	
	Level current;
	
	public LevelManager() {
		this.current = new Level(1, new Game(), new Statistics(), new Release());
	}
	
	public Level getCurrent() {
		return current;
	}

}
