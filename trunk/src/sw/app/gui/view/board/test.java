package sw.app.gui.view.board;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import sw.common.model.entity.Board;

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
		
		board = new Board();
		try {
			boardPanel = new BoardPanel(board);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boardPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		boardPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(boardPanel);		
		
		boardPanel.disableAnimation();
		boardPanel.setBoardController(null);
		
		boardPanel.initialize();
	}

}
