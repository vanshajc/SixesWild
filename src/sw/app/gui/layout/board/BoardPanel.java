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
import sw.common.model.entity.Level;
import sw.mode.release.Release;

public class BoardPanel extends JPanel implements IView, ActionListener {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;
	
	/* Keep reference to the current level being played */
	Level level;
	
	/* The Board to manage */
	Board board;
	
	Dimension preferredSize = new Dimension(800, 600);
	
	BoardColumn columns[];
	
	// Timer to update columns
	Timer timer;
	int refreshPeriod = 10; // msec
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Level level) {
		this.level = level;
		this.board = level.getGame().getBoard();
		initializeLayout();		
	}
	
	void initializeLayout() {
		setLayout(null);
		setPreferredSize(preferredSize);
		setDoubleBuffered(true);
		
		// Initialize the columns
		columns = new BoardColumn[Board.COLUMN];
		
		int x = 0;
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i] = new BoardColumn(level.getMode().getResourceManger(), i);
			
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
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i].updatePosition();
		}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < Board.COLUMN; i++) {
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

	/** Remove every Tile from the board */
	public void clear() {
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i].clear();
		}		
	}
	
}
