package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

public class Lightning implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return new CommonResourceManager();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lightning";
	}

	@Override
	public BoardController getBoardController() {
		return new MoveSelection();
	}

	@Override
	public boolean isValid(IMove m) {
		return true;
	}

	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		return g.getStats().getCurrent().getTime() <
				winStats.getCurrent().getTime(); 
	}
}
