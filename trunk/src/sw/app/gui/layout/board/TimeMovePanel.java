package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.sql.Time;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class TimeMovePanel extends JPanel {
	
	JLabel timeLabel;
	JLabel time;
	JLabel moveLabel;
	JLabel move;
	
	public TimeMovePanel() {
		setPreferredSize(new Dimension(450, 15));
		
		timeLabel = new JLabel("Time");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		time = new JLabel("testTime");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		
		move = new JLabel("testMove");
		move.setHorizontalAlignment(SwingConstants.CENTER);
		
		moveLabel = new JLabel("Move");
		moveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(time, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
					.addComponent(moveLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(move, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(timeLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(time, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(move, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(moveLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}
	
	public void setTime(Time time) {
		this.time.setText(time.toString());
		this.time.repaint();
	}
	
	public Time getTime() {
		return Time.valueOf(this.time.getText());
	}
	
	public void setMove(int move) {
		this.move.setText(Integer.toString(move));
		this.move.repaint();
	}
	
	public int getMove() {
		return Integer.parseInt(this.move.getText());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8208502195019158726L;
}
