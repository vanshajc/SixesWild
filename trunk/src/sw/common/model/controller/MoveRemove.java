/**
 * @file MoveRemove.java
 * @author Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sw.common.model.entity.Level;
import sw.common.model.entity.Tile;

public class MoveRemove extends BoardController implements IMove {
	
	BoardController prev;
	
	public MoveRemove(ILevelController lc, BoardController prev) {
		super(lc);
		this.prev = prev;
	}
	
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

	@Override
	public boolean undoMove() {
		// TODO Auto-generated method stub
		return false;
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

	/**
	 * @return the tile selected on the board to be removed, null if no tile selected
	 */
	public Tile getRemoveTile(){
		return this.selector.getSelectedTile().peek();
	}

}
