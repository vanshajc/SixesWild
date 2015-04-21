/**
 * @file Elimination.java
 * @date Apr 15, 2015 10:48:11 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 *
 */
public class Elimination extends CommonResourceManager implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Elimination";
	}

	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	@Override
	public boolean isValid(IMove m) {
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
