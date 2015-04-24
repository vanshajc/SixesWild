/**
 * @file Elimination.java
 * @date Apr 15, 2015 10:48:11 AM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 *
 */
public class Elimination implements IMode {
//	boolean[][] marked;

	@Override
	public IResourceManager getResourceManger() {
		return new CommonResourceManager();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Elimination";
	}

	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	@Override
	public boolean isValid(IMove m) {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
//		if (marked == null){
//			this.initialize(g.getBoard());
//		}
//		for (int i = 0; i<9; i++){
//			for (int j = 0; j<9; j++){
//				if (!marked[i][j])
//					return false;
//			}
//		}
		return true;
	}	

//	void initialize(Board board){
//		marked = new boolean[9][9];
//		for (int i = 0; i<9; i++){
//			for (int j = 0; j<9; j++){
//				Square s = board.getColumn(j).getSquare(i);
//				if (!s.isSelectable() && s.getTile() == null) // empty squares
//					marked[i][j] = true;
//			}
//		}
//	}
}
