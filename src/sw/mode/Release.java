/**
 *  @file   Release.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveRemove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 * Class for handling operations dependent on the Release mode.
 */
public class Release implements IMode {
	/** Holds the location on the board which must be filled with 6s. */
	boolean[][] sixLocation = new boolean[9][9];	

	/**
	 * TODO Remove this Constructor after testing phase is done...
	 */
	public Release(){
		
	}
	
	/**
	 * Constructor for the release mode. 
	 * @param sixLocation a 9x9 boolean array which holds true for the locations that must be filled with 6s.
	 */
	public Release(boolean[][] sixLocation){
		this.sixLocation = sixLocation;		
	}	
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getResourceManger()
	 */
	@Override
	public IResourceManager getResourceManger() {
		return new CommonResourceManager();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Release";
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getBoardController()
	 */
	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#isValid(sw.common.model.controller.IMove)
	 */
	@Override
	public boolean isValid(IMove m) {
		System.out.println("Calling on release valid");
		if (m instanceof MoveRemove){
			return ((MoveRemove) m).getRemoveTile().getValue() != 6;
		}
		return true;
	}	
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#hasFinished(sw.common.model.entity.Game, sw.common.model.entity.Statistics)
	 */
	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		// TODO Auto-generated method stub
		boolean found = false;
		// check for any 6 locations...
		for (int i = 0; i<9; i++)
			for (int j = 0; j<9; j++)
				if (!sixLocation[i][j])
					found = true;
		
		if (!found) return false;
		
		
		for (int i = 0; i<sixLocation.length; i++){
			for (int j = 0; j<sixLocation[i].length; j++){
				if (g.getBoard().getColumn(i).getTile(j).getValue() != 6 && sixLocation[i][j])
					return false;
			}
		}
		return true;
	}
	

}
