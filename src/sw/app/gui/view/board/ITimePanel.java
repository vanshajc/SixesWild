/**
 *  @file   ITimePanel.java
 *  @author Tony Vu
 *  @since  Apr 24, 2015
 */
package sw.app.gui.view.board;

import java.awt.event.ActionListener;
import java.sql.Time;

/** Interface for configuring and controlling the timer of the Game */
public interface ITimePanel {

	/** Get the current time
	 * @return the current Time
	 */
	Time getTime();
	
	/** Set the timer count direction
	 * @param countDown - true means time is decremented, else incremented 
	 */
	void setCountDown(boolean countDown);
	
	/** Set the current time
	 * @param time
	 */
	void setTime(Time time);
	
	/** Start the timer */
	void startTimer();
	
	/** Stop the timer */
	void stopTimer();
	
	/** Set an alarm, the alarm listener will be notified when the time hit the specified value
	 * @param time
	 * @param alarmListener
	 */
	void setAlarm(Time time, ActionListener alarmListener);
}
