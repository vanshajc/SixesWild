package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Level;
import sw.common.model.entity.Tile;
import sw.common.system.manager.LevelManager;

public class MoveRemove extends BoardController implements IMove{
	LevelManager lm;
	
	public MoveRemove(){
		super();
	}
	
	public MoveRemove(LevelManager lm, IBoardPanel bp){
		super(bp);
		this.panel = bp;
		this.lm = lm;
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
		Level level = lm.getCurrent();
		if (this.getSelectedTile().isEmpty()) return false;
		System.out.println(level.getMode());
		if (!level.getMode().isValid(this))
			return false;
		
		Point p = this.getPoint(this.getSelectedTile().peek());
		this.board.remove(p);
		this.board.pack();
		this.board.fill();
		
		BoardController bc = new MoveSelection(panel);
		panel.setBoardController(bc);
		
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
