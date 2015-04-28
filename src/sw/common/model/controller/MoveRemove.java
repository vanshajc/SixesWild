/**
 * @file MoveRemove.java
 * @author Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sw.common.model.entity.Level;
import sw.common.model.entity.Tile;
import sw.mode.Release;

public class MoveRemove extends BoardController implements IMove {	

	ILevelController lc;

	public MoveRemove() {
		super();
	}

	public MoveRemove(ILevelController lc) {
		super(lc);
		this.lc = lc;
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
		Level level = lc.getLevel();
		if (this.getSelectedTile().isEmpty()) return false;
		//System.out.println(level.getMode());
		if (!level.getMode().isValid(this)){
			setBoardController(new MoveSelection());
			return false;
		}

		Point p = this.getPoint(this.getSelectedTile().peek());
		this.board.remove(p);

		//TODO remove the instance of later....
		if (this.lvlCtrl.getLevel().getMode() instanceof Release)
			this.board.releasePack();
		else
			this.board.pack();
		this.board.fill();

		setBoardController(new MoveSelection());

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
