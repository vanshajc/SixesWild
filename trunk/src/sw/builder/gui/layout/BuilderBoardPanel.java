package sw.builder.gui.layout;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sw.app.gui.controller.PlayGameScreenController;
import sw.app.gui.view.board.BoardPanel;
import sw.builder.gui.controller.CreateButtonController;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuilderBoardPanel extends JPanel {

	BuilderLayoutManager blm;
	BoardPanel boardPanel;
	Level l;
	
	Board b = new Board();

	public BuilderBoardPanel(BuilderLayoutManager blm) {
		setLayout(null);
		this.blm = blm;
		boardPanel  = new BoardPanel(b);

		boardPanel.setBounds(0, 0, 500, 500);
		boardPanel.setBorder(null);
		add(boardPanel);
		
		initialize();
	}

	public void initialize() {		
		//l = LevelFactory.getPuzzleLevel(0, null, new Statistics(), null);
		//boardPanel.setLevel(l);
		boardPanel.disableAnimation();
		boardPanel.setBoardController(null);
		boardPanel.initialize();
		
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
				Tile t1 = new Tile(value, mult);
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
