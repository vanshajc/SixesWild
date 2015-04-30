package sw.mode;

import junit.framework.TestCase;
import sw.common.model.controller.BoardController;
import sw.common.model.controller.IMove;
import sw.common.model.controller.MoveSelection;

public class TestModes extends TestCase{
	IMove m;
	
	void setup(){
		m = new MoveSelection();
	}
	
	public void testElimination(){
		Elimination e = new Elimination();
		e.getBoardController();
		assertEquals("Elimination", e.toString());
		assertTrue(e.isValid(m));
		
	}
	public void testRelease(){
		Release mode = new Release();
		assertTrue(mode.getBoardController() instanceof BoardController);
		assertEquals("Release", mode.toString());
		assertTrue(mode.isValid(m));
	}
	public void testLightning(){
		Lightning mode = new Lightning();
		assertTrue(mode.getBoardController() instanceof BoardController);
		assertEquals("Lightning", mode.toString());
		assertTrue(mode.isValid(m));
		
	}
	public void testPuzzle(){
		Puzzle mode = new Puzzle();
		assertTrue(mode.getBoardController() instanceof BoardController);
		assertEquals("Puzzle", mode.toString());
		assertTrue(mode.isValid(m));
		
	}
	
}
