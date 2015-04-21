package sw.mode;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

public class Lightning extends CommonResourceManager implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return this;
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
	public boolean hasWon() {
		// TODO Auto-generated method stub
		return false;
	}
}
