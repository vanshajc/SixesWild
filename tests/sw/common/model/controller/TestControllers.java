package sw.common.model.controller;

import javax.swing.JButton;

import junit.framework.TestCase;
import sw.app.Application;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.MainMenuView;
import sw.app.gui.view.SixesWildJFrame;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;
import sw.common.system.manager.LevelManager;
public class TestControllers extends TestCase{

	LayoutManager lm;
	LevelManager lvlm;
	Board board;
	protected void setUp(){
		Application.main(null);
		lm = SixesWildJFrame.getLayoutManager();
		lvlm = SixesWildJFrame.getLevelManager();
		System.out.println("Level manager is "+lvlm);
		board = new Board();
		Level testLevel = LevelFactory.getPuzzleLevel(90, board, new Statistics(), null);
		lvlm.getLevels().add(testLevel);
		lvlm.setCurrent(testLevel);
		lvlm.startLevel();
		LayoutManager.switchToGameplayView(false);
	}
	protected void tearDown(){
		
	}
	
	public void test1(){
		JButton quit = new JButton();
		quit.addActionListener(new ButtonQuitActionListener(lm));
		quit.doClick();
		assertTrue(LayoutManager.getCurrentView() instanceof MainMenuView);
	}
	
//	public void testPowerup(){
//		JButton shuff = new JButton();
//		shuff.addActionListener(new PwrUpShuffleActionListener());
//		shuff.doClick();
//		
//		JButton rem = new JButton();
//		rem.addActionListener(new PwrUpRemoveActionListener());
//		rem.doClick();
//		
//		JButton swap = new JButton();
//		swap.addActionListener(new PwrUpSwapActionListener());
//		swap.doClick();
//		
//	}
	
	
}
