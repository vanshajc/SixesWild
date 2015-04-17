/**
 * @file Puzzle.java
 * @date Apr 15, 2015 10:46:13 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.mode;

import sw.common.model.controller.IMode;
import sw.common.model.controller.MoveSelection;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;
import sw.common.system.manager.IResourceManager;

/**
 *
 */
public class Puzzle extends CommonResourceManager implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Puzzle";
	}

	@Override
	public IBoardLocationManager getBoardLocationManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBoardSelectionManager getBoardSelectionManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoveSelection getBoardColumnController() {
		// TODO Auto-generated method stub
		return null;
	}

}
