/**
 *  @file   Release.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.mode;

import java.util.ArrayList;
import java.util.Iterator;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveRemove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.controller.MoveSwap;
import sw.common.model.entity.Board;
import sw.common.model.entity.Column;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;

/**
 * Class for Release Mode.
 */
public class Release extends AbstractMode {

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Release";
	}

	/** (non-Javadoc)
	 * @see sw.mode.AbstractMode#getBoardController()
	 */
	@Override
	public BoardController getBoardController() {
		return new ReleaseMoveSelection();
	}

	/** (non-Javadoc)
	 * @see sw.mode.AbstractMode#isValid(sw.common.model.controller.IMove)
	 */
	@Override
	public boolean isValid(IMove m) {
		if (m instanceof MoveRemove){
			return ((MoveRemove) m).getRemoveTile().getValue() != 6;
		}
		if (m instanceof MoveSwap){
			Iterator<Tile> ts = ((MoveSwap) m).getSelectedTile().iterator();
			return ts.next().getValue()!=6 && ts.next().getValue()!=6; 
		}
		return true;
	}	

	/** (non-Javadoc)
	 * @see sw.mode.AbstractMode#hasFinished(sw.common.model.entity.Game, sw.common.model.entity.Statistics)
	 */
	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		Board b = g.getBoard();
		for (int i = 0; i<9; i++){
			Column c = b.getColumn(i);
			for (int j = 0; j<9; j++){
				if (c.getSquare(j).isOnlySix()){
					if (c.getTile(j) == null)
						return false;
				}
			}
		}
		System.out.println("finished??");
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

	/**
	 * Class for handling selection moves specifically for the Release Mode.
	 */
	private class ReleaseMoveSelection extends MoveSelection {

		/** (non-Javadoc)
		 * @see sw.common.model.controller.MoveSelection#doMove()
		 */
		@Override
		public boolean doMove() {
			if (!isValid()) {
				return false;
			}

			return super.doMove();
		}

		/** (non-Javadoc)
		 * @see sw.common.model.controller.MoveSelection#isValid()
		 */
		@Override
		protected boolean isValid() {
			Iterator<Tile> selected = getSelectedTile().iterator();
			ArrayList<Tile> tiles = new ArrayList<Tile>();
			while(selected.hasNext())
				tiles.add(selected.next());

			if (tiles.isEmpty()|| (tiles.size() == 1 && tiles.get(0).getValue() == 6)) return false;
			int sum = 0;
			for (int i = 0; i<tiles.size(); i++){
				Tile t = tiles.get(i);
				sum += t.getValue();
				boolean ad = false;
				for (int j = 0; j<tiles.size(); j++){
					if (i == j) continue;
					if (board.adjacent(t, tiles.get(j))) ad = true;
				}
				if (!ad)
					return false;
			}

			return sum == 6;
		}
	}

}
