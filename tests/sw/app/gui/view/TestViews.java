package sw.app.gui.view;

import junit.framework.TestCase;
import sw.app.Application;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;

public class TestViews extends TestCase{
	
	public void testView(){
		Application.main(null);
		
		ScoreBoardView sbv = new ScoreBoardView();
		sbv.initialize();
		
		Board testBoard = new Board();
		Statistics testWinStats = new Statistics();
		
		Level testLevel = LevelFactory.getPuzzleLevel(0, testBoard, testWinStats, null);
		
		sbv.addLevelStats(testLevel);
		
		PostGameView pgv = new PostGameView(testLevel);
		pgv.initialize();
		pgv.setLevel(testLevel);
		
		CreditScreenView csv = new CreditScreenView();
		csv.initialize();
		
		PlayGameScreenView pgs = new PlayGameScreenView();
		pgs.initialize();
		pgs.addLevel(testLevel);
	}

}
