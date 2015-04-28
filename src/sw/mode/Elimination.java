/**
 * @file Elimination.java
 * @date Apr 15, 2015 10:48:11 AM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Board;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;

/**
 * Class for respresenting the Elimination Mode
 */
public class Elimination extends AbstractMode {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Elimination";
	}

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#getBoardController()
	 */
	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}	

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#hasFinished(sw.common.model.entity.Game, sw.common.model.entity.Statistics)
	 */
	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		Board board = g.getBoard();
		for (int i = 0; i<9; i++){
			for (int j = 0; j<9; j++){
				if (!board.getColumn(j).getSquare(i).isSelectable())
					continue;
				if (!board.getColumn(j).getSquare(i).getMarked())
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

	
}
