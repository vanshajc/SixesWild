/**
 * @file Puzzle.java
 * @date Apr 15, 2015 10:46:13 AM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;

/**
 * Class for representing Puzzle mode.
 */
public class Puzzle extends AbstractMode {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Puzzle";
	}

	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	@Override
	public boolean isValid(IMove m) {
		return true;
	}
	
	public boolean doMove(IMove m){
		return true;
	}
	
	@Override
	public boolean hasFinished(Game g, Statistics winStat) {
		return g.getStats().getNumMoves() == 0;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#initializeGame(sw.common.model.controller.IGameController)
	 */
	@Override
	public void initializeGame(IGameController g) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#getMovePolicy()
	 */
	@Override
	public MOVE_POLICY getMovePolicy() {
		// TODO Auto-generated method stub
		return MOVE_POLICY.COUNT_DOWN;
	}	

}
