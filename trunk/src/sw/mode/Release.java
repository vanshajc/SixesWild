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
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 * 
 */
public class Release extends CommonResourceManager implements IMode {
	boolean[][] sixLocation;	

	public Release(){
		
	}
	
	public Release(boolean[][] sixLocation){
		this.sixLocation = sixLocation;		
	}	
	
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
	public boolean hasFinished(Game g) {
		// TODO Auto-generated method stub
		for (int i = 0; i<sixLocation.length; i++){
			for (int j = 0; j<sixLocation[i].length; i++){
				if (g.getBoard().getColumn(i).getTile(j).getValue() != 6 && sixLocation[i][j])
					return false;
			}
		}
		return true;
	}

}
