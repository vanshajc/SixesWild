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
import sw.common.model.entity.Column;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;

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
		return new ReleaseMoveSelection();
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
		if (sixLocation == null)
			return false;
		
		for (int i = 0; i<sixLocation.length; i++)
			for (int j = 0; j<9; j++)
				if (!sixLocation[i][j])
					found = true;
		if (!found) return false;
		
		for (int i = 0; i<sixLocation.length; i++){
			for (int j = 0; j<sixLocation[i].length; j++){
				Column c = g.getBoard().getColumn(j);
				if (c.getTile(i) == null && c.getSquare(i).isOnlySix())
					return false;
				if (c.getTile(i) == null)
					continue;
				if (c.getTile(i).getValue() != 6 && sixLocation[i][j])
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
	
	private class ReleaseMoveSelection extends MoveSelection {

		/* (non-Javadoc)
		 * @see sw.common.model.controller.MoveSelection#doMove()
		 */
		@Override
		public boolean doMove() {
			if (!isValid()) {
				return false;
			}
			
			return super.doMove();
		}
		
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
