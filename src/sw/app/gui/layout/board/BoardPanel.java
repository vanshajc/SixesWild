package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = 5914218859027914106L;
	
	int numCol = 9;
	
	BoardColumn columns[] = new BoardColumn[numCol];
	
	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		
		int x = 0;
		for (int i = 0; i < numCol; i++) {
			columns[i] = new BoardColumn();
			Rectangle rec = new Rectangle(columns[i].getPreferredSize());
			rec.setLocation(x, 0);
			columns[i].setBounds(rec);
			x += rec.width;
			add(columns[i]);
		}
		
	}
}
