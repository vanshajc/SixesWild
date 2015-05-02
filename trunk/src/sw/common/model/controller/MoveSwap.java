/**
 * @file MoveSwap.java
 * @date Apr 16, 2015 2:49:37 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.model.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.factory.TileFactory;

/** Move for swapping 2 Tiles on the Board */
public class MoveSwap extends BoardController implements IMove {
	
	// Keep track of these Tiles for undo
	Tile t1;
	Tile t2;
	
	Point p1;
	Point p2;
	boolean moveStarted = false;
	
	BoardController prev;
	
	/**
	 * Constructor for a swap powerup move.
	 * @param bp the board panel
	 * @param level the current level being played
	 */
	public MoveSwap(ILevelController lc, BoardController prev) {
		super(lc);
		this.prev = prev;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.controller.BoardColumnController#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!panel.isAnimating()) {
			try {
				if (!moveStarted) {
					moveStarted = true;
					p1 = panel.xyToPoint(e.getPoint());
					select(p1);
				} else {
					moveStarted = false;
					p2 = panel.xyToPoint(e.getPoint());
					select(p2);
					requestPushMove(this);
					clearSelection();
				}
			} catch (Exception e1) {				
				System.err
				.println("Out of bound error in MoveSwap::mouseClicked!");
			}
		}
	}

	/* (non-Javadoc)
	 * @see sw.common.model.controller.IMove#doMove()
	 */
	@Override
	public boolean doMove() {
		setBoardController(prev);
		
		return swap(p1, p2);
	}

	// hmmm... will not work if board changed
	@Override
	public boolean undoMove() {
		if (getPoint(t1).equals(p2) && locator.getPoint(t2).equals(p1)) {
			return swap(p1, p2);  
			// invalidate t1 and t2?
		}
		return false;		
	}
	
	/** Exchange the Tile of 2 positions
	 * @param s1
	 * @param s2
	 */
	boolean swap(Point p1, Point p2) {
		if (!this.lvlCtrl.getLevel().getMode().isValid(this)){
			System.out.println("Went through?");
			return false;
		}
		Square s1 = getSquare(p1);
		Square s2 = getSquare(p2);
		if (s1 != null && s2 != null) {
			// need to create new Tiles instead of swapping existing ones
			// because we don't want animation to happen
			t1 = TileFactory.getTile(s1.getTile());
			t2 = TileFactory.getTile(s2.getTile());			
			s1.setTile(t2);
			s2.setTile(t1);
			return true;
		}		
		return false;
	}

}
