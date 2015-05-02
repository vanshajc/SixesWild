/**
 * @file BoardColumnController.java
 * @author Tony Vu, Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;

/**
 * Class for handling moves that involve selecting squares on the board
 */
public class MoveSelection extends BoardController implements IMove {
	
	public MoveSelection(){}

	/**
	 * Constructor for a selection move.
	 * @param lc the level controller.
	 */
	public MoveSelection(ILevelController lc) {
		super(lc);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (manager.hasFinished()) {
			manager.finishGame();
		}
		
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
		
		if (!manager.hasFinished()) {
			requestPushMove(this);
			clearSelection();
		}
	}

	/**
	 * Selects the square the mouse is over.
	 * @param e the mouse event
	 */
	protected void selectionHandler(MouseEvent e) {
		if (!manager.hasFinished() && !panel.isAnimating()) {  // If column is still moving, don't do anything
			try {
				Point p = panel.xyToPoint(e.getPoint());
				
				Square s = getSquare(p);
				if (s.isSelectable()) {
					if (s.isEmpty()) {
						clearSelection();
						return;
					}
					select(p);
				} else {
					clearSelection();
				}
			} catch (Exception e1) {
				clearSelection();
				System.err.println("Selection out of bound!");
			}
		}
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMove#doMove()
	 */
	@Override
	public boolean doMove() {
		if (!isValid()) return false; 
		
		Iterator<Tile> selected = getSelectedTile().iterator();
		int score = 10 * this.getSelectedSquare().size();
		while (selected.hasNext()) {
			Tile t = selected.next();
			
			Point p = getPoint(t);
			score *= t.getMultiplier();
			boardRemove(p);
		}		
		boardPack();
		boardFill();
		
		updateScore(score);
		clearSelection();
		return true;
	}	

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMove#undoMove()
	 */
	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @return if the current move is valid
	 */
	protected boolean isValid(){
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
	}	
		
}
