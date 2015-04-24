/**
 * @file Puzzle.java
 * @date Apr 15, 2015 10:46:13 AM
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
public class Puzzle implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return new CommonResourceManager();
	}

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
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean hasFinished(Game g, Statistics winStat) {
		//return (g.getStats().getNumMoves() >= winStat.getNumMoves()); <- actual code, dont uncomment until stats class is done
		return g.getStats().getScore() >= 200;  // test
	}

}
