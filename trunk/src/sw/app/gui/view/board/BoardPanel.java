package sw.app.gui.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.common.model.controller.BoardController;
import sw.common.model.entity.Board;
import sw.common.model.entity.Column;
import sw.common.model.entity.IBoard;
import sw.common.model.entity.Level;
import sw.common.system.manager.IResourceManager;
import sw.common.system.manager.TimerTaskManager;

public class BoardPanel extends JPanel implements IBoardPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;
	
	/** Keep reference to the current level being played */
	Level level;
	
	/** The Board to manage */
	Board board;
	Dimension boardSize;
	
	/** Timer to update columns */
	final String refreshTask = "BoardPanelRefresh";
	long  refreshPeriod = 10; // msec
	
	/** Map of icon images to use */
	IResourceManager resManager;
	HashMap<String, Image> imageMap = new HashMap<String, Image>();
	
	/** The columns to paint */
	ArrayList<BoardColumn> columns = new ArrayList<BoardColumn>();
	
	/** Keep track of whether animation is enabled */
	boolean enableAnimation = true;
	
	/** Keep track of whether the board is in animation */
	boolean isAnimating = false;
	
	/** The preferred size */
	Dimension preferredSize;
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#setLevel(sw.common.model.entity.Level)
	 */
	@Override
	public void setLevel(Level level) {
		if (level == null) {
			throw new IllegalArgumentException("Current level is null!");
		}
		
		this.level = level;
		this.board = level.getGame().getBoard();
		this.boardSize  = board.size();
		this.resManager = level.getMode().getResourceManger();
		
		// Load all images we need now
		Iterator<String> si = resManager.getTileImage().values().iterator();
		while (si.hasNext()) {
			String path = si.next();
			if (!imageMap.containsKey(path)) {
				 Image img = new ImageIcon(BoardPanel.class.getResource(path)).getImage();
				 if (img != null) {
					 imageMap.put(path, img); // Store the image
				 }
			}			
		}
		
		//BoardController bc = level.getMode().getBoardController();
		//if (bc != null) {
		//	setBoardController(bc);
		//	bc.initialize(this);
		//}
		
		initializeLayout();
	}
	
	public void setBoardController(BoardController bc) {
		MouseListener[] ml = this.getMouseListeners();
		for (int i = 0; i < ml.length; i++) {
			removeMouseListener(ml[i]);
		}
		
		MouseMotionListener[] mml = this.getMouseMotionListeners();
		for (int i = 0; i < mml.length; i++) {
			removeMouseMotionListener(mml[i]);
		}
		
		if (bc != null) {
			addMouseListener(bc);
			addMouseMotionListener(bc);
			//bc.initialize(this);
		}
	}
	
	void initializeLayout() {
		setLayout(null);		
		setDoubleBuffered(true);
		
		preferredSize = new Dimension();
		
		int x = 0;
		for (int i = 0; i < boardSize.width; i++) {
			BoardColumn bc = new BoardColumn(this, i); // Guarantee to not be null...
			
			// Add to array
			columns.add(i, bc);
			
			// Use the column's preferred size
			Rectangle rec = new Rectangle(bc.getPreferredSize());
			rec.setLocation(x, 0);			
			bc.setBounds(rec);			
			
			// Add new component
			add(bc);
			x += rec.width;
			
			preferredSize.width = Math.max(preferredSize.width, x);
			preferredSize.height = Math.max(preferredSize.height, rec.height);
		}
		
		setPreferredSize(preferredSize);
		
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
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#initialize()
	 */
	@Override
	public void initialize() {
		if (level == null || board == null || resManager == null) {
			throw new IllegalStateException("Must call BoardPanel::setLevel first!");
		}
		
		initializeColumns();
		TimerTaskManager.scheduleTask(refreshTask, new refreshTask(), refreshPeriod);
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#cleanup()
	 */
	@Override
	public void cleanup() {
		TimerTaskManager.cancelTask(refreshTask);
		
		// Reset the state of the panel
		level = null;
		board = null;
		resManager = null;
		columns.clear();
		
		setBoardController(null);
		
		// remove all components
		removeAll();
	}
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#clear()
	 */
	@Override
	public void clear() {
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).clear();		
		}		
	}
	
	boolean refresh() {
		boolean updated = false;
		for (int i = 0; i < boardSize.width; i++) {
			if (columns.get(i).update()) {
				updated = true;
			}
		}
		return updated;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, preferredSize.width, preferredSize.height);
		for (int i = 0; i < boardSize.width; i++) {
			columns.get(i).repaint();
		}
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#isAnimating()
	 */
	@Override
	public synchronized boolean isAnimating() {
		if (enableAnimation) {
			return isAnimating;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#xyToPoint(java.awt.Point)
	 */
	@Override
	public Point xyToPoint(Point point) {
		int xStart = 0;
		for (int x = 0; x < boardSize.width; x++) {
			BoardColumn bc = columns.get(x);			
			int xEnd = xStart + bc.getSize().width;
			if (point.x >= xStart && point.x < xEnd) {
				try {
					return new Point(x, bc.yToIdx(point.y));
				} catch (Exception e) {
					System.err.println("XY coordinate out of bound!");
					return null;
				}
			}
			xStart += bc.getSize().width;
		}
		return null;
	}
	
	Column getColumn(int i) {
		return board.getColumn(i);
	}

	@Override
	public boolean isAnimating(int colIdx) {
		return false;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.board.IBoardPanel#getBoard()
	 */
	@Override
	public IBoard getBoard() {
		return (IBoard) board;
	}

	@Override
	public void disableAnimation() {
		enableAnimation = false;
		for (int x = 0; x < boardSize.width; x++) {
			columns.get(x).disableAnimation();
		}		
	}

	@Override
	public void enableAnimation() {
		enableAnimation = true;
		for (int x = 0; x < boardSize.width; x++) {
			columns.get(x).enableAnimation();
		}
	}
	
	private class refreshTask extends TimerTask {

		@Override
		public void run() {
			isAnimating = refresh();
			repaint();
		}
		
	}

}
