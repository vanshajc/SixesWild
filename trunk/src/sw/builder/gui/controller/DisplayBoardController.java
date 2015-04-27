package sw.builder.gui.controller;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import sw.app.gui.view.board.BoardPanel;
import sw.builder.gui.layout.BuilderBoardPanel;
import sw.builder.gui.layout.BuilderLayoutManager;
import sw.builder.gui.layout.LevelBuilderView;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;

public class DisplayBoardController implements ActionListener {

	BuilderLayoutManager blm;
	LevelBuilderView lbv;
	BuilderBoardPanel bbp = new BuilderBoardPanel(blm);

	public DisplayBoardController(BuilderLayoutManager blm, LevelBuilderView lbv) {
		this.blm = blm;
		this.lbv = lbv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		bbp = new BuilderBoardPanel(blm);
		String[][] b = lbv.getBoard();
		//setBoardView(b);
		blm.switchToBuilderBoard();
		bbp.setBoardView(b);
	}
	/*
	 * public void setBoardView(String[][] b) { for (int i = 0; i < 9; i++) {
	 * for (int j = 0; j < 9; j++) { String val = b[i][j].substring(0, 1); int
	 * value = Integer.parseInt(val); String mul = b[i][j].substring(2); int
	 * mult = Integer.parseInt(mul); Point p1 = new Point(i, j); Tile t1 = new
	 * Tile(value, mult);
	 * CreateButtonController.board.getSquare(p1).setTile(t1); } } for (int i =
	 * 0; i < 9; i++) { for (int j = 0; j < 9; j++) { Point p1 = new Point(i,
	 * j);
	 * System.out.print(CreateButtonController.board.getSquare(p1).getTile().
	 * getValue() + " "); } System.out.println(""); } }
	 */

}
