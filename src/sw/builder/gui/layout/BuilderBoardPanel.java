package sw.builder.gui.layout;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sw.app.gui.view.board.BoardPanel;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.model.entity.Tile;
import sw.common.system.factory.LevelFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuilderBoardPanel extends JPanel {

	Board board;
	BuilderLayoutManager blm;
	BoardPanel boardPanel = new BoardPanel();

	public BuilderBoardPanel(BuilderLayoutManager blm) {
		this.blm = blm;

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE,
								800, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(111, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE,
								600, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(68, Short.MAX_VALUE)));
		setLayout(groupLayout);
		initialize();
	}

	public void initialize() {

		board = new Board(false);

		Level l = LevelFactory.getPuzzleLevel(0, board, new Statistics(), null);
		boardPanel.setLevel(l);
		boardPanel.disableAnimation();
		boardPanel.setBoardController(null);
		boardPanel.initialize();
	}


}
