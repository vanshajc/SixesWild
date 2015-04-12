package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.sql.Time;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TimeMovePanel extends JPanel {
	
	JLabel lblTime;
	JLabel time;
	JLabel lblMove;
	JLabel move;
	
	public TimeMovePanel() {
		setPreferredSize(new Dimension(300, 15));
		
		lblTime = new JLabel("Time");
		
		time = new JLabel();
		time.setPreferredSize(new Dimension(70,15));		
		
		move = new JLabel();
		move.setPreferredSize(new Dimension(70,15));
		
		lblMove = new JLabel("Move");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblTime)
					.addGap(18)
					.addComponent(time)
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addComponent(move)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMove))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTime)
						.addComponent(time)
						.addComponent(lblMove)
						.addComponent(move))
					.addContainerGap(285, Short.MAX_VALUE))
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
