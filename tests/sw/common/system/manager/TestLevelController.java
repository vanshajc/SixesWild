package sw.common.system.manager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sw.app.Application;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.controller.ILevelController;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;
import sw.common.system.factory.TileFrequency;

/**
 *  @file   TestLevelController.java
 *  @author Tony Vu
 *  @since  Apr 25, 2015
 */

/** Test for the LevelController class */
public class TestLevelController {
	
	Level testLevel;
	Board testBoard;
	Statistics testWinStats;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {		
		Application.main(null);
		
		LevelManager lm = SixesWildJFrame.getLevelManager();
		lm.clear();  // clear all default levels
		
		testBoard = new Board();
		testWinStats = new Statistics();
		
		testLevel = LevelFactory.getPuzzleLevel(0, testBoard, testWinStats, new TileFrequency());
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

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link sw.common.model.controller.LevelController#setLevel(sw.common.model.entity.Level)}.
	 */
	@Test
	public void testSetLevel() {
		ILevelController lc = SixesWildJFrame.getLevelManager().getLevelController();
		
		// The level info and win statistics should match
		assertEquals(testLevel.toString(), lc.getLevel().toString());
		assertEquals(testWinStats, lc.getLevel().getWinStats());
		
		// Initial board layout should match with the one we generated
		IBoardLocationManager bl = lc.getBoardLocator();
		Dimension boardSize = lc.getBoardPanel().getBoard().size();		
		for (int x = 0; x < boardSize.getWidth(); x++) {
			for (int y = 0; y < boardSize.getHeight(); y++) {
				Point p = new Point(x, y);
				assertEquals(testBoard.getSquare(p), bl.getSquare(p));
			}
		}
	}

	

}
