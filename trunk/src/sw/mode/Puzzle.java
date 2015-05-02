/**
 * @file Puzzle.java
 * @date Apr 15, 2015 10:46:13 AM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.mode;

import sw.common.model.controller.BoardController;
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

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#getBoardController()
	 */
	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#isValid(sw.common.model.controller.IMove)
	 */
	@Override
	public boolean isValid(IMove m) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#hasFinished(sw.common.model.entity.Game, sw.common.model.entity.Statistics)
	 */
	@Override
	public boolean hasFinished(Game g, Statistics winStat) {
		return g.getStats().getNumMoves() == 0;
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
