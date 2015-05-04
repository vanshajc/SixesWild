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
import sw.builder.gui.layout.BuilderLayoutManager;
import sw.builder.gui.layout.LevelBuilderView;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;
/**
 * @author scyevchak
 */
/** Controller for the display button */
public class DisplayBoardController implements ActionListener {
	/** Controls which screen is displayed */
	BuilderLayoutManager blm;
	/** The view that has the current board */
	LevelBuilderView lbv;
	/**
	 * Constructor to display the board created.
	 * @param blm view currently on.
	 * @param lbv the data containing the board.
	 */
	public DisplayBoardController(BuilderLayoutManager blm, LevelBuilderView lbv) {
		this.blm = blm;
		this.lbv = lbv;
	}
	/**
	 * Sets the board and displays it in a new view.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[][] b = lbv.getBoard();
		Board b1;
		try {
			b1 = setBoardView(b,lbv);
			blm.switchToScreen(LevelBuilderView.boardPanel);
			LevelBuilderView.boardPanel.getBoard().copy(b1);
			LevelBuilderView.boardPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					blm.switchToLevelBuilder();
				}
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * Sets the board to be displayed
	 * @param b the string array containing data about the board.
	 * @param lbv the level builder containing the board object.
	 * @return the Board set
	 * @throws Exception stops invalid boards from being displayed.
	 */
	public static Board setBoardView(String[][] b,LevelBuilderView lbv) throws Exception {
		Board b1 = new Board();
		Tile t1;
		int mult = -1;
		int value = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Point p1 = new Point(i, j);
				String val = b[i][j].substring(0, 1);
				String mul = b[i][j].substring(2);
				if (!val.equals("*") && !mul.equals("*")) {
					value = Integer.parseInt(val);
					mult = Integer.parseInt(mul);
				}
				if (mul.equals("*") || val.equals("*")) {
					if(!lbv.getModeList().equals("Release")){
						throw new Exception("Invalid board type for tile selection");
					}
					CreateButtonController.board.getSquare(p1).setTile(null);
					CreateButtonController.board.getSquare(p1).setOnlySix(true);
				} else if (value == 0 || mult == 0) {
					CreateButtonController.board.getSquare(p1).setTile(null);
				} else if(value != -1 || mult != -1) {
					if(value == 6 && lbv.getModeList().equals("Elimination") && lbv.getModeList().equals("Release")){
						throw new Exception("Invalid board type for tile selection");
					}
					t1 = new Tile(value, mult);
					CreateButtonController.board.getSquare(p1).setTile(t1);
					System.out.println(CreateButtonController.board.getSquare(p1).getTile());
				} else {
					
				}
			}
		}
		b1 = CreateButtonController.board;
		return b1;
	}
}
