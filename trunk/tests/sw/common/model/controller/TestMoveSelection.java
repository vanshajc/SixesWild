package sw.common.model.controller;

import java.awt.event.MouseEvent;

import sw.app.gui.view.board.BoardPanel;
import junit.framework.TestCase;

public class TestMoveSelection extends TestCase{
	// testing this is kind of hard.. i dont really want to do this.. 
	
	BoardPanel boardPanel;
	protected void setUp(){
		boardPanel = new BoardPanel();
	}
	
	protected void tearDown(){
		
	}
	
	public void testMoves(){
		MouseEvent press = new MouseEvent(boardPanel, MouseEvent.MOUSE_PRESSED,System.currentTimeMillis(), 0, 50, 50, 0, false);
		//mousePressed(press);
	}

}
