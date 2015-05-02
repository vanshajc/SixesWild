/**
 * @file Elimination.java
 * @date Apr 15, 2015 10:48:11 AM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.mode;

import java.awt.Point;
import java.util.Iterator;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Board;
import sw.common.model.entity.Game;
import sw.common.model.entity.Square;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;

/**
 * Class for respresenting the Elimination Mode
 */
public class Elimination extends AbstractMode {
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Elimination";
	}

	/** (non-Javadoc)
	 * @see sw.mode.AbstractMode#getBoardController()
	 */
	@Override
	public BoardController getBoardController() {
		return new EliminationMoveSelection();
	}	

	/** (non-Javadoc)
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

	/**
	 * Class for handling selection moves for the elimination mode.
	 */
	private class EliminationMoveSelection extends MoveSelection {
		/** (non-Javadoc)
		 * @see sw.common.model.controller.MoveSelection#doMove()
		 */
		@Override
		public boolean doMove() {
			if (!isValid()) return false; 
			
			int score = 0;
			Iterator<Square> selected = getSelectedSquare().iterator();
			
			while (selected.hasNext()) {
				Square s = selected.next();
				s.setMarked(true);
				
				Tile t = s.getTile();
				score += t.getValue() * t.getMultiplier();
				
				Point p = getPoint(t);
				boardRemove(p);
			}		
			boardPack();
			boardFill();
			
			updateScore(score);
			clearSelection();
			return true;
		}
	}

}
