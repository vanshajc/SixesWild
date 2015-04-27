/**
 * @file Lightning.java
 * @author Tony Vu, Vanshaj Chowdhary
 */
package sw.mode;

import java.awt.event.ActionEvent;

import sw.common.model.controller.BoardController;
import sw.common.model.controller.IGameController;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;
import sw.common.model.entity.Game;
import sw.common.model.entity.Statistics;

public class Lightning extends AbstractMode {

	boolean timeOut = false;
	
	IGameController gc;
	
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
		return m instanceof MoveSelection;
	}
	

	@Override
	public boolean hasFinished(Game g, Statistics winStats) {
		return timeOut;
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#initializeGame(sw.common.model.controller.IGameController)
	 */
	@Override
	public void initializeGame(IGameController g) {
		gc = g;		
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMode#getTimePolicy()
	 */
	@Override
	public TIMER_POLICY getTimerPolicy() {
		return TIMER_POLICY.COUNT_DOWN;
	}

	/* (non-Javadoc)
	 * @see sw.mode.AbstractMode#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		timeOut = true;
		gc.finishGame();
	}	
	
}
