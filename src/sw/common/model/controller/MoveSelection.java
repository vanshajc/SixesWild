/**
 * @file BoardColumnController.java
 * @date Apr 15, 2015 9:17:12 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Tile;

/**
 *
 */
public class MoveSelection extends BoardController implements IMove {
	
	public MoveSelection(){}

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
		doMove();
		clearSelection();
	}

	protected void selectionHandler(MouseEvent e) {
		if (!panel.isAnimating()) {  // If column is still moving, don't do anything
			try {
				Point p = panel.xyToPoint(e.getPoint());
				select(p);
			} catch (Exception e1) {
				clearSelection();
				throw new IndexOutOfBoundsException("Selection out of bound!");
			}
		}
	}

	@Override
	public boolean doMove() {
		if (!isValid()) return false;
		Iterator<Tile> selected = getSelectedTile().iterator();
		while (selected.hasNext()) {
			Point p = getPoint(selected.next());
			boardRemove(p);
		}		
		boardPack();
		boardFill();
		return true;
	}



	boolean isValid(){
		Iterator<Tile> selected = getSelectedTile().iterator();
		if (!selected.hasNext()) return false; // none selected somehow
		Tile prev = selected.next();
		if (prev.getValue()==6) return false; // if only a six is selected
		int sum = prev.getValue();
		while (selected.hasNext()){
			Tile curr = selected.next();
			sum += curr.getValue();
			if (!this.board.adjacent(prev, curr))
				return false;
			prev = curr;
		}

		return sum == 6;

	}

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
	}
}
