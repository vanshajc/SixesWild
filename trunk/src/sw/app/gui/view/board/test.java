package sw.app.gui.view.board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;

public class test extends JFrame {

	Board board;
	BoardPanel boardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		boardPanel = new BoardPanel();
		boardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		boardPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(boardPanel);
		
		board = new Board();
		Level l = LevelFactory.getPuzzleLevel(0, board, new Statistics());
		boardPanel.setLevel(l);
		boardPanel.disableAnimation();
		boardPanel.setBoardController(null);
		
		boardPanel.initialize();
	}

}
