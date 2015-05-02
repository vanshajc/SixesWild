package sw.common.model.controller;

import java.awt.Point;

import junit.framework.TestCase;
import sw.app.Application;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.app.gui.view.board.BoardPanel;
import sw.common.model.entity.Board;
import sw.common.model.entity.IBoard;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;
import sw.common.system.factory.TileFactory;
import sw.common.system.manager.IBoardSelectionManager;
import sw.common.system.manager.LevelManager;

public class TestMoveSelection extends TestCase{
	// testing this is kind of hard.. i dont really want to do this.. 
	Level testLevel;
	Board testBoard;
	Statistics testWinStats;
	BoardPanel boardPanel;
	ILevelController lc;
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
	


	public void testIsValid() {

		lc = SixesWildJFrame.getLevelManager().getLevelController();
		// The level info and win statistics should match
		assertEquals(testLevel.toString(), lc.getLevel().toString());
		assertEquals(testWinStats, lc.getLevel().getWinStats());
		
		Tile t = TileFactory.getTile(1, 1);
		IBoard b = lc.getBoardPanel().getBoard();
		b.replace(new Point(0,0), t);
		Tile t1 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,1), t1);
		Tile t2 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,2), t2);
		Tile t3 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,3), t3);
		Tile t4 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,4), t4);
		Tile t5 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,5), t5);
		
		IBoardSelectionManager s = lc.getBoardSelector();
		MoveSelection moveTester1 = new MoveSelection(lc);
		assertFalse(moveTester1.isValid());
		s.select(new Point(0,0));
		s.select(new Point(0,1));
		s.select(new Point(0,2));
		MoveSelection moveTester2 = new MoveSelection(lc);
		assertFalse(moveTester2.isValid());
		s.select(new Point(0,3));
		s.select(new Point(0,4));
		s.select(new Point(0,5));
		
		MoveSelection moveTester = new MoveSelection(lc);
		assertTrue(moveTester.isValid());
		
//		s.clearSelection();
//		s.select(new Point(0,0));
//		s.select(new Point(0,1));
//		MoveSwap m = new MoveSwap(lc, new MoveSelection(lc));
//		assertTrue(m.doMove());
//		s.clearSelection();
		

	}
	
	public void testDoMove(){

		lc = SixesWildJFrame.getLevelManager().getLevelController();
		// The level info and win statistics should match
		
		Tile t = TileFactory.getTile(2, 1);
		IBoard b = lc.getBoardPanel().getBoard();
		b.replace(new Point(0,0), t);
		Tile t1 = TileFactory.getTile(1, 1);
		b.replace(new Point(0,1), t1);
		Tile t2 = TileFactory.getTile(3, 1);
		b.replace(new Point(0,2), t2);

		IBoardSelectionManager s = lc.getBoardSelector();

		s.select(new Point(0,0));
		s.select(new Point(0,1));
		s.select(new Point(0,2));
		
		MoveSelection moveTester = new MoveSelection(lc);
		assertTrue(moveTester.doMove());
		
		
	}
		
	
	


}
