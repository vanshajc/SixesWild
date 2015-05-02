/**
 * @file MoveRemove.java
 * @author Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sw.common.model.entity.Level;
import sw.common.model.entity.Tile;

/**
 * Class for representing the remove powerup.
 */
public class MoveRemove extends BoardController implements IMove {
	
	BoardController prev;
	
	/**
	 * Construct a remove move.
	 * @param lc the level controller
	 * @param prev the previous board controller
	 */
	public MoveRemove(ILevelController lc, BoardController prev) {
		super(lc);
		this.prev = prev;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		try {
			selectionHandler(e);
			requestPushMove(this);
			clearSelection();
		} catch (IndexOutOfBoundsException e1) {
			System.err
			.println("Out of bound error in BoardColumnController::mouseClicked!");
		}
	}
	
	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMove#doMove()
	 */
	@Override
	public boolean doMove() {
		Level level = lvlCtrl.getLevel();
		if (this.getSelectedTile().isEmpty()) return false;
		//System.out.println(level.getMode());
		if (!level.getMode().isValid(this)){
			setBoardController(prev);
			return false;
		}
		
		Point p = this.getPoint(this.getSelectedTile().peek());
		this.board.remove(p);
		this.board.pack();
		this.board.fill();
		
		setBoardController(prev);
		
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
	 * Handles the selection based on the mouse event.
	 * @param e the mouse event.
	 */
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

	/**
	 * @return the tile selected on the board to be removed, null if no tile selected
	 */
	public Tile getRemoveTile(){
		return this.selector.getSelectedTile().peek();
	}

}
