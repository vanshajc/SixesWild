/**
 *  @file   Release.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveRemove;
import sw.common.model.controller.MoveSelection;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 * 
 */
public class Release extends CommonResourceManager implements IMode {
	
	

	@Override
	public IResourceManager getResourceManger() {
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Release";
	}

	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	@Override
	public boolean isValid(IMove m) {
		System.out.println("Calling on release valid");
		if (m instanceof MoveRemove){
			return ((MoveRemove) m).getRemoveTile().getValue() != 6;
		}
		return true;
	}	
	
	@Override
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}

}
