/**
 *  @file   IGameController.java
 *  @author Tony Vu
 *  @since  Apr 24, 2015
 */
package sw.common.model.controller;

import java.awt.event.ActionListener;
import java.sql.Time;

/** The interface for controlling the Game */
public interface IGameController {
	
	/**
	 * @param t the Time for the game
	 * @param countDown whether the timer will count down
	 */
	void setTime(Time t, boolean countDown);

	/**
	 * @param t the alarm Time
	 * @param al the alarm event listener
	 */
	void setAlarm(Time t, ActionListener al);

	/** Update the Game display */
	void updateGame();

	/** Start the Game */
	void startGame();

	/** Pause the Game */
	void pauseGame();
	
	/** Finish the Game */
	void finishGame();

}
