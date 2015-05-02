package sw.common.model.controller;

import java.awt.event.MouseEvent;

import sw.app.Application;
import sw.app.gui.view.GameplayView;
import sw.app.gui.view.GameplayViewAccessor;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.app.gui.view.board.BoardPanel;
import sw.app.gui.view.board.IBoardPanel;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;
import sw.common.system.manager.LevelManager;
import junit.framework.TestCase;

public class TestMoveSelection extends TestCase{
	Level testLevel;
	Board testBoard;
	Statistics testWinStats; 
	
	protected void setUp(){
		Application.main(null);
		
		LevelManager lm = SixesWildJFrame.getLevelManager();
		lm.clear();  // clear all default levels
		
		testBoard = new Board();
		testWinStats = new Statistics();
		
		testLevel = LevelFactory.getPuzzleLevel(0, testBoard, testWinStats, null);
		lm.addLevel(testLevel);
		
		try {
			LayoutManager.switchToGameplayView(false);
			lm.setCurrent(testLevel);
			
			// This is for runtime testing
			LayoutManager.initCurrentView();			
			lm.startLevel();
		} catch (Exception e) {
			fail("Should not have failed here!");
		}
	}
	
	protected void tearDown(){
		
	}
	
	public void testMoves() {
		ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
		
		GameplayView gpv = (GameplayView) SixesWildJFrame.getLayoutManager().getCurrentView();
		BoardPanel bp = GameplayViewAccessor.getBoardPanel(gpv);
		
		MouseEvent me = new MouseEvent(bp, MouseEvent.MOUSE_PRESSED,System.currentTimeMillis(), 0, 0, 0, 1, false);
		BoardController bc = bp.getBoardController();
		bc.mouseClicked(me);
		
		assertFalse(lc.getBoardSelector().getSelectedTile().isEmpty());
	}

}
