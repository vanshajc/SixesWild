package sw.app.gui.layout.board;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class BoardColumn extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989466787176501882L;

	int imgWidth = 50;
	int imgHeight = 50;
	int count = 9;
	
	int xPos = 0;
	int yPos = 0;
	
	String resourcePath = "/sw/resource/image/icon50x50.png";
	
	/**
	 * Create the panel.
	 */
	public BoardColumn() {
		JLabel lblTest = new JLabel("");
		lblTest.setIcon(new ImageIcon(BoardColumn.class.getResource(resourcePath)));
		lblTest.setBounds(xPos, yPos, imgWidth, imgHeight);
		add(lblTest);
	}

}
