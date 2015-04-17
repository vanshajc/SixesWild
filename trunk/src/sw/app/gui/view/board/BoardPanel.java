package sw.app.gui.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

import sw.app.gui.controller.BoardColumnController;
import sw.app.gui.view.IView;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.manager.IResourceManager;

public class BoardPanel extends JPanel implements IView, ActionListener {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;
	
	/** Keep reference to the current level being played */
	Level level;
	
	/** The Board to manage */
	Board board;
	Dimension boardSize;
	
	/** Timer to update columns */
	Timer timer;
	int refreshPeriod = 10; // msec
	
	/** Map of icon images to use */
	IResourceManager resManager;
	HashMap<String, Image> imageMap = new HashMap<String, Image>();
	
	/** The columns to paint */
	ArrayList<BoardColumn> columns = new ArrayList<BoardColumn>();
	
	Dimension preferredSize = new Dimension(800, 600);
	
	public BoardPanel() {
		// Initialize the timer only once
		timer = new Timer(refreshPeriod, this);
	}
	
	public BoardPanel(Level level) {
		// Initialize the timer only once
		timer = new Timer(refreshPeriod, this);
		
		setLevel(level);
	}
	
	public void setLevel(Level level) {
		if (level == null) {
			throw new IllegalArgumentException("Current level is null!");
		}
		
		this.level = level;
		this.board = level.getGame().getBoard();
		this.boardSize  = board.size();
		this.resManager = level.getMode().getResourceManger();		
		
		//removeAll();  // Remove all component before setting new level
		initializeLayout();
	}
	
	void initializeLayout() {
		setLayout(null);
		setPreferredSize(preferredSize);
		setDoubleBuffered(true);
		
		int x = 0;
		for (int i = 0; i < boardSize.width; i++) {
			BoardColumn bc = new BoardColumn(this, i); // Guarantee to not be null...
			
			// Add to array
			columns.add(i, bc);
			
			// Use the column's preferred size
			Rectangle rec = new Rectangle(bc.getPreferredSize());
			rec.setLocation(x, 0);			
			bc.setBounds(rec);
			bc.addMouseListener(new BoardColumnController(bc, board));
			
			// Add new component
			add(bc);
			x += rec.width;
		}
		
		// Repaint panel
		invalidate();
		repaint();		
	}
	
	/** Initialize every BoardColumn */
	void initializeColumns() {
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).initialize(this, i);
		}
	}
	
	@Override
	public void initialize() {
		if (level == null || board == null || resManager == null) {
			throw new IllegalStateException("Must call BoardPanel::setLevel first!");
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
		columns.clear();
		
		// remove all components
		removeAll();
	}
	
	/** Remove every Tile from the board */
	public void clear() {
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).clear();		
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).update();
		}		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).repaint();
		}
	}

}
