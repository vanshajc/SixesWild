/**
 *  @file   Board.java
 *  @author Tony Vu, Vanshaj Chowdhary
 *  @since  Apr 11, 2015
 */
package sw.common.model.entity;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import sw.common.system.factory.SquareFactory;
import sw.common.system.manager.IBoardLocationManager;
import sw.common.system.manager.IBoardSelectionManager;

/** The model for the game board<br>
 * <br>
 *  Layout:<br>
 * <br>
 *     00  01  02  03  04  05  06  07  08<br>
 *     10  11  12  13  14  15  16  17  18<br>
 *     ...<br>
 *     80  81  82  83  84  85  86  87  88<br> 
 * 
 * */
public class Board implements IBoard, IBoardSelectionManager, IBoardLocationManager {
	
	/** Default dimension for the board */
	public static final int COLUMN = 9;
	public static final int ROW    = 9;
	
	/** The grid of Square */
	ArrayList<Column> grid = new ArrayList<Column>();
	
	/** The selection queue */
	SelectionQueue<Square> selection = new SelectionQueue<Square>(Board.COLUMN * Board.ROW);
			
	/** Create a new Board
	 * @param fill the board with randomly generated value or not
	 */
	public Board() {
		createBoard(true);
	}
	
	public Board(boolean fill) {
		createBoard(fill);
	}
	
	/** Create new Board
	 * @param fill whether to fill board with Tile
	 */
	private void createBoard(boolean fill) {
		// Create the board
		for (int x = 0; x < Board.COLUMN; x++) {
			// Create rows first since we want easy access to columns
			ArrayList<Square> row = new ArrayList<Square>();
			for (int y = 0; y < Board.ROW; y++) {
				row.add(SquareFactory.getSquare(fill));
			}
			// Add the new row to the grid			
			grid.add(new Column(row));
		}		
	}
	
	/**
	 * @param b the Board to copy
	 */
	public void copy(Board b) {
		for (int x = 0; x < Board.COLUMN; x++) {
			for (int y = 0; y < Board.ROW; y++) {
				Point p = new Point(x,y);
				getSquare(p).copy(b.getSquare(p));				
			}
		}
	}
	
	/**
	 * @param col to get
	 * @return the column of Square
	 */
	public Column getColumn(int col) {
		try {
			return grid.get(col);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}		
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#clear()
	 */
	@Override
	public void clear() {
		for (int x = 0; x < Board.COLUMN; x++) {
			grid.get(x).clear();
		}		
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#fill()
	 */
	@Override
	public void fill() {
		for (int x = 0; x < Board.COLUMN; x++) {
			grid.get(x).fill();
		}		
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#pack()
	 */
	@Override
	public void pack() {
		for (int x = 0; x < Board.COLUMN; x++) {
			grid.get(x).pack();
		}	
	}
	
	public void releasePack(){
		for (int i = 0; i<Board.COLUMN; i++){
			grid.get(i).releasePack();
		}
	}
	
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#size()
	 */
	@Override
	public Dimension size() {
		return new Dimension(Board.COLUMN, Board.ROW);
	}	
	
	/**
	 * @param p position to remove
	 * @param fill whether to fill empty spaces with new Tiles
	 */
	public boolean remove(Point p) {
		if (isValidPoint(p)) {
			Column c = grid.get(p.x);
			return c.removeTile(p.y);  // Remove Tile			
		}
		return false;
	}
	
	/**
	 * @return the number of Tile currently in the Board
	 */
	@Override
	public int count() {
		int total = 0;
		for (int x = 0; x < Board.COLUMN; x++) {
			total += grid.get(x).count();
		}
		return total;
	}

	/**
	 * @param p the position
	 * @param t the new Tile to place at the position
	 * @return true if the new Tile was placed at the position, false if not
	 */
	@Override
	public boolean replace(Point p, Tile t) {
		if (remove(p)) {
			return grid.get(p.x).setTile(t, p.y);
		}
		return false;
	}
	
	/**
	 * @param p the positon
	 * @return true if the position is empty, false if not
	 */
	@Override
	public boolean isEmpty(Point p) {
		if (isValidPoint(p)) {
			return grid.get(p.x).getTile(p.y) == null;
		}
		return true;
	}
	
	/**
	 * Shuffle the Board.
	 */
	public void shuffle() {
		Board b = new Board(false);
		LinkedList<Point> points = new LinkedList<Point>();
		for (int i = 0; i<Board.COLUMN; i++){
			for (int j = 0; j<Board.ROW; j++){
				int newX = (int) (Math.random()*Board.COLUMN);
				int newY = (int) (Math.random()*Board.ROW);
				Point newP = new Point(newX, newY);
				Point curr = new Point(i,j);
				
				if (this.getSquare(curr).isOnlySix()){
					b.getSquare(curr).setOnlySix(true);
					b.getSquare(curr).setSelectable(false);
					if (this.getTile(curr)!=null && this.getTile(curr).getValue() == 6){
						b.replace(curr, this.getTile(curr));
					}
					continue;
				}
				if (!this.getSquare(curr).isSelectable()){
					b.replace(curr, this.getTile(curr));
					b.getSquare(curr).setSelectable(false);
					continue;
				}
				if (this.getSquare(curr).getMarked()){
					b.getSquare(curr).setMarked(true);
				}
				
				if (this.getTile(curr)!=null && this.getTile(curr).getValue() == 6){
					b.replace(curr, this.getTile(curr));
					continue;
				}
				while (points.contains(newP) || !this.getSquare(newP).selectable || 
						(this.getTile(newP) != null && (this.getTile(newP).getValue() ==6))){
					newX = (int) (Math.random()*Board.COLUMN);
					newY = (int) (Math.random()*Board.ROW);
					newP = new Point(newX, newY);
				}
				b.replace(curr, this.getTile(newP));
				b.getSquare(curr).setSelectable(true);
				points.add(newP);
			}
		}
		
		this.copy(b);
		for (Column c : this.grid){
			for (int i = 0; i<9; i++){
				System.out.print(c.getTile(i));
			}
			System.out.println();
		}
		
	}
	
	//////////////////////////////////////////////////////////
	// IBoardLocationnManager methods
	//
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#isValidX(int)
	 */
	@Override
	public boolean isValidX(int x) {
		return (x >= 0 && x < Board.COLUMN);
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#isValidY(int)
	 */
	@Override
	public boolean isValidY(int y) {
		return (y >= 0 && y < Board.ROW);
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#isValidPoint(java.awt.Point)
	 */
	@Override
	public boolean isValidPoint(Point p) {
		return (isValidX(p.x) && isValidY(p.y));
	}
	
	/**
	 * @param tile the Tile to search for
	 * @return the position of the Tile in the Board
	 */
	public Point getPoint(Tile tile) {
		for (int x = 0; x < Board.COLUMN; x++) {
			try {
				int y = grid.get(x).indexOf(tile);
				return new Point(x, y);
			} catch (IllegalAccessError e) {
				continue;
			}			
		}
		return null;
	}
	
	/**
	 * @param p the position
	 * @return the Tile at the position
	 */
	public Tile getTile(Point p) {
		if (isValidPoint(p)) {
			return grid.get(p.x).getTile(p.y);
		}
		return null;
	}
	
	/**
	 * @param p the position
	 * @return the Square at the position
	 */
	public Square getSquare(Point p) {
		if (isValidPoint(p)) {
			return grid.get(p.x).getSquare(p.y);
		}
		return null;
	}
	
	//////////////////////////////////////////////////////////
	// IBoardSelectionManager methods
	//
	
	/**
	 * @param p the position to select
	 */
	public boolean select(Point p) {
		Square s = getSquare(p);
		
		if (!s.isSelectable()) {
			return false;
		}		
		
		if (!selection.contains(s)) {			
			try {
				s.setSelected(true);
				selection.put(s);
				return true;
			} catch (InterruptedException e) {
				// Queue is full, discard this selection
				System.err.println("Selection queue is full!");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return the selected Squares
	 */
	public Queue<Square> getSelectedSquare() {
		Queue<Square> sq = new SelectionQueue<Square>(Board.COLUMN * Board.ROW);
		sq.addAll(selection);
		return sq;
	}
	
	/**
	 * @return the selected Tiles
	 */
	public Queue<Tile> getSelectedTile() {
		Queue<Tile> tq = new SelectionQueue<Tile>(Board.COLUMN * Board.ROW);
		Iterator<Square> si = selection.iterator();
		while (si.hasNext()) {
			tq.add(si.next().getTile());
		}
		return tq;
	}
	
	public boolean clearSelection() {
		Iterator<Square> si = selection.iterator();
		while (si.hasNext()) { 
			si.next().setSelected(false);
		}		
		selection.clear();		
		return true;
	}	

	/* (non-Javadoc)
	 * @see sw.common.model.entity.IBoard#adjacent(sw.common.model.entity.Square, sw.common.model.entity.Square)
	 */
	@Override
	public boolean adjacent(Tile s1, Tile s2) {
		int col1 = findCol(s1);
		int col2 = findCol(s2);
		if (col1 == -1 || col2 == -1)
			return false;
		if (Math.abs(col1 - col2) == 1){
			return (grid.get(col1).indexOf(s1) == grid.get(col2).indexOf(s2));
		}
		else if (col1 == col2){
			return (Math.abs(grid.get(col1).indexOf(s1) - grid.get(col2).indexOf(s2)) == 1);
		}
		return false;
	}
	
	/**
	 * @param t the tile to be located
	 * @return the index of the column
	 */
	public int findCol(Tile t){
		for (int i = 0; i < this.grid.size(); i++){
			try{
				grid.get(i).indexOf(t);
				return i;
			}catch(IllegalAccessError e){
			}
		}
		return -1;
	}
	
	private class SelectionQueue<T> extends ArrayBlockingQueue<T> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3158414763532356898L;

		public SelectionQueue(int capacity) {
			super(capacity, true);			
		}
		
	}

}
