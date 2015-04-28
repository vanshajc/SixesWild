package sw.builder.gui.controller;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		//bbp = new BuilderBoardPanel(blm);
//		String[][] b = lbv.getBoard();
		//setBoardView(b);
		//blm.switchToBuilderBoard();
		String[][] b = LevelBuilderView.getBoard();
		Board b1 = setBoardView(b);
		blm.switchToScreen(LevelBuilderView.boardPanel);
		LevelBuilderView.boardPanel.getBoard().copy(b1);
		System.out.println("here");
		LevelBuilderView.boardPanel.addMouseListener(new MouseAdapter() {			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("in click event");
				blm.switchToLevelBuilder();
			}			
		});
		//bbp.setBoardView(b);
	}
	public static Board setBoardView(String[][] b) {
		Board b1 = new Board();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String val = b[i][j].substring(0, 1);
				int value = Integer.parseInt(val);
				String mul = b[i][j].substring(2);
				int mult = Integer.parseInt(mul);
				Point p1 = new Point(i, j);
				Tile t1 = null;
				if (value != 0 && mult != 0) {
					t1 = new Tile (value, mult);
				}
				CreateButtonController.board.getSquare(p1).setTile(t1);
			}
		}		
		b1 = CreateButtonController.board;
		return b1;
		//b.copy(b1);
		
		//boardPanel.setBoard(b1);
		//boardPanel.initialize();
		
		
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				Point p1 = new Point(i, j);
//				System.out.print(b1.getSquare(p1).getTile().getValue() + " ");
//			}
//			System.out.println("");
//		}
		
	}

}
