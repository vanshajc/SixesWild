/**
 * @file BoardColumnController.java
 * @date Apr 15, 2015 9:17:12 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Queue;

import javax.swing.SwingUtilities;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Tile;

/**
 *
 */
public class MoveSelection extends BoardController implements IMove {
	
//	public MoveSelection(){}
//
//	public MoveSelection(IBoardPanel bp) {
//		super(bp);
//	}
//
//	/* (non-Javadoc)
//	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
//	 */
//	@Override
//	public void mousePressed(MouseEvent e) {
//		try {
//			selectionHandler(e);
//		} catch (IndexOutOfBoundsException e1) {
//			System.err
//			.println("Out of bound error in BoardColumnController::mouseClicked!");
//		}
//	}
//
//	/* (non-Javadoc)
//	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
//	 */
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		try {
//			selectionHandler(e);
//		} catch (IndexOutOfBoundsException e1) {
//			System.err
//			.println("Out of bound error in BoardColumnController::mouseDragged!");
//		}
//	}
//
//	/* (non-Javadoc)
//	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
//	 */
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		selectionHandler(e);
//		requestPushMove(this);
//		clearSelection();
//	}
//
//	protected void selectionHandler(MouseEvent e) {
//		if (!panel.isAnimating()) {  // If column is still moving, don't do anything
//			try {
//				Point p = panel.xyToPoint(e.getPoint());
//				select(p);
//			} catch (Exception e1) {
//				clearSelection();
//				throw new IndexOutOfBoundsException("Selection out of bound!");
//			}
//		}
//	}
//
//	@Override
//	public boolean doMove() {
//		if (!isValid()) return false;
//		Iterator<Tile> selected = getSelectedTile().iterator();
//		while (selected.hasNext()) {
//			Point p = getPoint(selected.next());
//			boardRemove(p);
//		}		
//		boardPack();
//		boardFill();
//		return true;
//	}	
//
//	@Override
//	public boolean undoMove() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	boolean isValid(){
//		Iterator<Tile> selected = getSelectedTile().iterator();
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
//	}
	
		// This makes sure the selection is contiguous tiles
		boolean moveStarted = false;
		
		// Keep track of last point
		Point lastPoint = null;
		
		public MoveSelection(){}
		
		public MoveSelection(IBoardPanel bp) {
			super(bp);
		}

		/* (non-Javadoc)
		 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			// If right click request undo
			if (SwingUtilities.isRightMouseButton(e)) {
				requestUndoMove();
				return;
			}
			
			try {
				lastPoint = null;
				moveStarted = true;
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
			if (moveStarted) {
				moveStarted = false;
				requestPushMove(this);			
			}
		}

		protected void selectionHandler(MouseEvent e) {
			if (moveStarted && !panel.isAnimating()) {  // If column is still moving, don't do anything
				try {
					Point p = panel.xyToPoint(e.getPoint());
					if (!(lastPoint != null && !isAdjacent(p, lastPoint))) {
						if (isEmpty(p) || !select(p)) {
							moveStarted = false;
							clearSelection();
						}
						lastPoint = p;
					}					
				} catch (Exception e1) {
					moveStarted = false;
					clearSelection();
				}
			}
		}

		@Override
		public boolean doMove() {
			boolean status = true;
			
			int sum = 0;
			Queue<Tile> tq = getSelectedTile();	
			while (!tq.isEmpty()) {
				Tile t = tq.remove();
				
				// Cannot select 6
				if (t.getValue() == 6) {
					status = false;
					break;
				}
				
				// Check position of the next Tile, if exists
				if (!tq.isEmpty()) {
					Point p1 = getPoint(t);
					Point p2 = getPoint(tq.peek());
					if (!isAdjacent(p1, p2)) {
						status = false;
						break;
					}
				}
				
				// Sum must not be over 6
				sum += t.getValue();
				if (sum > 6) {
					status = false;
					break;
				}
			}
			
			// Has to add up to 6
			if (sum != 6) {
				status = false;
			}
			
			// If passed all checks, perform the move
			if (status == true) {
				removeSelection();
				boardPack();
				boardFill();
			}
			
			clearSelection();		
			return status;
		}

		@Override
		public boolean undoMove() {
			// TODO Auto-generated method stub
			return false;
		}
		
		boolean isAdjacent(Point p1, Point p2) {
			if (p1 == null || p2 == null) {
				return false;
			}
			return (((p1.x == p2.x) && (Math.abs(p1.y - p2.y) == 1)) ||
					((p1.y == p2.y) && (Math.abs(p1.x - p2.x) == 1)));
		}
}
