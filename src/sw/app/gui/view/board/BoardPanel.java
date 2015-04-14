package sw.app.gui.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

import sw.app.gui.view.IView;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.manager.IResourceManager;

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
	
	HashMap<Point, Tile> location = new HashMap<Point, Tile>();
	
	IResourceManager resManager;
	HashMap<Square, Image> imageMap = new HashMap<Square, Image>();
	
	public void setLevel(Level level) {
		if (level == null) {
			throw new IllegalArgumentException("Current level is null!");
		}
		
		this.level = level;
		this.board = level.getGame().getBoard();
		this.resManager = level.getMode().getResourceManger();
		columns = new BoardColumn[Board.COLUMN];
		
		initializeLayout();
	}
	
	void initializeLayout() {
		setLayout(null);
		setPreferredSize(preferredSize);
		setDoubleBuffered(true);
		
		// Remove all out-of-date components
		//removeAll();
		
		int x = 0;
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i] = new BoardColumn(this, i);
			
			// Use the column's preferred size
			Rectangle rec = new Rectangle(columns[i].getPreferredSize());
			rec.setLocation(x, 0);			
			columns[i].setBounds(rec);
			
			add(columns[i]);
			x += rec.width;
		}
		
		invalidate();
		repaint();
		
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
		if (level == null || board == null || resManager == null) {
			throw new IllegalStateException("Must set BoardPanel::setLevel first!");
		}
		initializeColumns();
		timer.start();		
	}

	@Override
	public void cleanup() {
		timer.stop();		
		
		// Reset the state of the panel
		level = null;
		board = null;
		resManager = null;
		columns = null;
		
		// remove all components
		removeAll();
	}

	/** Remove every Tile from the board */
	public void clear() {
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i] = null;
			System.gc();			
		}		
	}
	
	private void initializeColumns() {
		for (int i = 0; i < Board.COLUMN; i++) {
			columns[i].initialize();
		}
	}

}
