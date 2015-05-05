package sw.app.gui.view.board;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import sw.common.model.entity.Statistics;
import sw.common.system.manager.TimerTaskManager;

import java.awt.Color;

/**
 * @file TimeMovePanel.java
 * @author Vanshaj Chowdhary, Trung-Nghia N. Huynh.
 */

/**
 * Class for representing the panel with the move and time
 */
@SuppressWarnings("serial")
public class TimeMovePanel extends JPanel implements ITimePanel, IMovePanel {
	
	/** Labels for the information. */
	JLabel timeLabel;
	JLabel time;
	JLabel moveLabel;
	JLabel move;
	
	Statistics stats;
	
	// Timer task fields
	final String timerTask = "TimeMovePanelTask";
	final long timerPeriod = 1000;
	
	boolean countDown = false;
	
	// Alarm timer
	Time alarm;
	ActionListener listener;	
	
	/**
	 * TimeMovePanel constructor.
	 */
	public TimeMovePanel() {		
		setBackground(Color.LIGHT_GRAY);		
		
		setPreferredSize(new Dimension(450, 25));
		
		timeLabel = new JLabel("Time");
		timeLabel.setForeground(new Color(184, 134, 11));
		timeLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		time = new JLabel();
		time.setForeground(new Color(184, 134, 11));
		time.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		
		move = new JLabel();
		move.setForeground(new Color(184, 134, 11));
		move.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		move.setHorizontalAlignment(SwingConstants.CENTER);
		
		moveLabel = new JLabel("Move");
		moveLabel.setForeground(new Color(184, 134, 11));
		moveLabel.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		moveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(time, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
					.addComponent(moveLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(move, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(time, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(move, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}
	
	//////////////////////////////////////////////////////////
	// IMovePanel methods
	//
	
	/**
	 * Get the time.
	 */
	public Time getTime() {
		return Time.valueOf(this.time.getText());
		//return stats.getTime();
	}
	
	/**
	 * Get the countdown time.
	 */
	public void setCountDown(boolean countDown) {
		this.countDown = countDown;
	}
	
	/**
	 * Set the time.
	 */
	public void setTime(Time time) {
		this.time.setText(time.toString());
	}	
	
	/**
	 * Start the timer.
	 */
	public void startTimer() {
		TimerTaskManager.scheduleTask(timerTask, new timerTask(), timerPeriod);
	}
	
	/**
	 * Stop the timer.
	 */
	public void stopTimer() {
		TimerTaskManager.cancelTask(timerTask);
	}
	
	/**
	 * Set the alarm.
	 */
	public void setAlarm(Time time, ActionListener al) {
		listener = al;
		alarm = time;
	}
	
	//////////////////////////////////////////////////////////
	// IMovePanel methods
	//
	
	/**
	 * Set the move.
	 */
	public void setMove(int move) {
		this.move.setText(Integer.toString(move));
	}
	
	/**
	 * Get the move.
	 */
	public int getMove() {
		return Integer.parseInt(this.move.getText());
	}	
	
	//////////////////////////////////////////////////////////
	// pseudo-IView methods
	//	
	
	/**
	 * Set the time and move for the game.
	 * @param stats Statistics
	 */
	public void initialize(Statistics stats) {
		this.stats = stats;
		
		setTime(stats.getTime());
		setMove(stats.getNumMoves());
	}
	
	public void cleanup() {
		stopTimer();		
	}
	
	//////////////////////////////////////////////////////////
	// Miscellaneous methods
	//
	
	//public void reset() {		
	//	setTime(Time.valueOf("00:00:00"));
	//	setMove(0);
	//}	
	
	//////////////////////////////////////////////////////////
	// Timer refresh task
	//
	
	private class timerTask extends TimerTask {

		@Override
		public void run() {
			Time currentTime = getTime();
			long time = currentTime.getTime();  // msec
			
			if (listener != null && currentTime.compareTo(alarm) == 0) {
				// Fire action event
				try {
					listener.actionPerformed(new ActionEvent(this, 0, null));
				} catch (Exception e) {
					System.err.println("Not supposed to reach here!");
				}				
			}
			
			if (countDown && time >= timerPeriod) {
				time -= timerPeriod;			
			} else {
				time += timerPeriod;
			}			
			
			// Update
			Time current = new Time(time);
			setTime(current);	
		}

		/* (non-Javadoc)
		 * @see java.util.TimerTask#cancel()
		 */
		@Override
		public boolean cancel() {
			listener = null;
			
			return super.cancel();
		}		
		
	}

}
