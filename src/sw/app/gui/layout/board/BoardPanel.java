package sw.app.gui.layout.board;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class BoardPanel extends JPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;

	int imgWidth = 48;
	int imgHeight = 48;
	int count = 9;
	
	int xPos = 0;
	int yPos = 0;
	
	Dimension size = new Dimension(imgWidth, imgHeight * count);
	
	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setLayout(null);
		setPreferredSize(size);
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(xPos, yPos, imgWidth, imgHeight);
		add(lblTest);
	}
}
