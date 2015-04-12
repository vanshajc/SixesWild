package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import sw.app.gui.layout.IView;
import sw.common.model.entity.Board;
import sw.mode.release.Release;

public class BoardPanel extends JPanel implements IView, ActionListener {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;
	
	/* The Board to manage */
	Board board = new Board(true);
	
	Dimension preferredSize = new Dimension(800, 600);
	
	BoardColumn columns[];
	
	// Timer to update columns
	Timer timer;
	int refreshPeriod = 10; // msec
	
	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setLayout(null);
		setPreferredSize(preferredSize);
		setDoubleBuffered(true);
		
		// Initialize the columns
		columns = new BoardColumn[board.COLUMN];
		
		int x = 0;
		for (int i = 0; i < board.COLUMN; i++) {
			columns[i] = new BoardColumn(new Release(), i);
			
			// Use the column's preferred size
			Rectangle rec = new Rectangle(columns[i].getPreferredSize());
			rec.setLocation(x, 0);			
			columns[i].setBounds(rec);
			
			add(columns[i]);
			x += rec.width;
		}
		
		// Start timer 
		timer = new Timer(refreshPeriod, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < board.COLUMN; i++) {
			columns[i].updatePosition();
		}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < board.COLUMN; i++) {
			columns[i].repaint();
		}
	}

	@Override
	public void initialize() {
		timer.start();		
	}

	@Override
	public void cleanup() {
		timer.stop();		
	}

	public void clear() {
		for (int i = 0; i < board.COLUMN; i++) {
			columns[i].clear();
		}		
	}
	
}
