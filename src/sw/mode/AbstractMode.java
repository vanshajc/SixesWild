/**
 *  @file   AbstractMode.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 25, 2015
 */
package sw.mode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.IMode;
import sw.common.model.controller.IMove;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.IResourceManager;

/** A generic Mode implementation */
public abstract class AbstractMode implements IMode, ActionListener {

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getResourceManger()
	 */
	@Override
	public IResourceManager getResourceManger() {
		return SixesWildJFrame.getCommonResourceManager();
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getBoardController()
	 */
	@Override
	abstract public BoardController getBoardController();

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#isValid(sw.common.model.controller.IMove)
	 */
	@Override
	public boolean isValid(IMove m) {
		return true;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#hasFinished(sw.common.model.entity.Game, sw.common.model.entity.Statistics)
	 */
	@Override
	abstract public boolean hasFinished(Game g, Statistics winStats);

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#initializeGame(sw.common.model.controller.IGameController)
	 */
	@Override
	abstract public void initializeGame(IGameController g);

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getTimerPolicy()
	 */
	@Override
	public TIMER_POLICY getTimerPolicy() {
		return TIMER_POLICY.COUNT_UP;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getMovePolicy()
	 */
	@Override
	public MOVE_POLICY getMovePolicy() {
		return MOVE_POLICY.COUNT_UP;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Do nothing, should be overridden by mode that has a COUNT_DOWN timer policy 
	}
	
}
