/**
 *  @file   Release.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveRemove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 * Class for Release Mode.
 */
public class Release extends AbstractMode {
	boolean[][] sixLocation = new boolean[9][9];	

	/**
	 * TODO Remove this later.
	 */
	public Release(){
		
	}
	
	/**
	 * Constructor for creating a release mode.
	 * @param sixLocation a 2d boolean array which holds true for all the locations that must have 6.
	 */
	public Release(boolean[][] sixLocation){
		this.sixLocation = sixLocation;		
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
		if (m instanceof MoveRemove){
			return ((MoveRemove) m).getRemoveTile().getValue() != 6;
		}
		return true;
	}	
	
	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		// TODO Auto-generated method stub
		boolean found = false;
		for (int i = 0; i<sixLocation.length; i++)
			for (int j = 0; j<9; j++)
				if (!sixLocation[i][j])
					found = true;
		if (!found) return false;
		
		for (int i = 0; i<sixLocation.length; i++){
			for (int j = 0; j<sixLocation[i].length; i++){
				if (g.getBoard().getColumn(i).getTile(j).getValue() != 6 && sixLocation[i][j])
					return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#initializeGame(sw.common.model.controller.IGameController)
	 */
	@Override
	public void initializeGame(IGameController g) {
		// TODO Auto-generated method stub
		
		
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getTimePolicy()
	 */
	@Override
	public TIMER_POLICY getTimerPolicy() {
		return TIMER_POLICY.COUNT_UP;
	}
	

}
