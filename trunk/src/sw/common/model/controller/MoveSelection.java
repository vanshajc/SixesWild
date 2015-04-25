/**
 * @file BoardColumnController.java
 * @author Tony Vu, Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Tile;

/**
 * Class for handling moves that involve selecting squares on the board
 */
public class MoveSelection extends BoardController implements IMove {
	
	/**
	 * TODO Remove later on.
	 */
	public MoveSelection(){}

	/**
	 * Constructor for a selection move.
	 * @param bp the board panel being acted upon.
	 */
	public MoveSelection(IBoardPanel bp) {
		super(bp);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		try {
			selectionHandler(e);
		} catch (IndexOutOfBoundsException e1) {
			System.err
			.println("Out of bound error in BoardColumnController::mouseClicked!");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			selectionHandler(e);
		} catch (IndexOutOfBoundsException e1) {
			System.err
			.println("Out of bound error in BoardColumnController::mouseDragged!");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		selectionHandler(e);
		requestPushMove(this);
		clearSelection();
	}

	
	protected void selectionHandler(MouseEvent e) {
		if (!panel.isAnimating()) {  // If column is still moving, don't do anything
			try {
				Point p = panel.xyToPoint(e.getPoint());
				select(p);
			} catch (Exception e1) {
				clearSelection();
				//throw new IndexOutOfBoundsException("Selection out of bound!");
				System.err.println("Selection out of bound!");
			}
		}
	}

	@Override
	public boolean doMove() {
		if (!isValid()) return false;
		
		int score = 0;
		Iterator<Tile> selected = getSelectedTile().iterator();
		while (selected.hasNext()) {
			Tile t = selected.next();
			Point p = getPoint(t);
			score += t.getValue() * t.getMultiplier();
			boardRemove(p);
		}		
		boardPack();
		boardFill();
		updateScore(score);
		return true;
	}	

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
	boolean isValid(){
		Iterator<Tile> selected = getSelectedTile().iterator();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		while(selected.hasNext())
			tiles.add(selected.next());
		
		if (tiles.isEmpty()|| (tiles.size() == 1 && tiles.get(0).getValue() == 6)) return false;
		int sum = 0;
		for (int i = 0; i<tiles.size(); i++){
			Tile t = tiles.get(i);
			sum += t.getValue();
			boolean ad = false;
			for (int j = 0; j<tiles.size(); j++){
				if (i == j) continue;
				if (this.board.adjacent(t, tiles.get(j))) ad = true;
			}
			if (!ad)
				return false;
		}
		
		return sum == 6;
//		
//		if (!selected.hasNext()) return false; // none selected somehow
//		Tile prev = selected.next();
//		if (prev.getValue()==6) return false; // if only a six is selected
//		int sum = prev.getValue();
//		while (selected.hasNext()){
//			Tile curr = selected.next();
//			sum += curr.getValue();
//			if (!this.board.adjacent(prev, curr))
//				return false;
//			prev = curr;
//		}
//		return sum == 6;
	}
	
		
}
