package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -8762701255976920190L;
	
	Timer timer;
	Dimension size;
	Dimension imgSize;  // The size of the image
	BoardColumn columns[];
	
	int refreshPeriod = 25;  // msec
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(Dimension size, Dimension imgSize) {
		
		this.size = size;
		this.imgSize = imgSize;
		
		columns = new BoardColumn[size.width];  // The y-count will be used to initialize the BoardColumn
		timer = new Timer(refreshPeriod, this); // Create timer
		
		setLayout(null);
		
		int x = 0;
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new BoardColumn(size.height, imgSize);
			// Use the preferred size
			Dimension cd = columns[i].getPreferredSize();
			columns[i].setBounds(x, 0, cd.width, cd.height);
			add(columns[i]);
			x += cd.width; // put the columns next to each other
		}		
		
		timer.start(); // Start the timer
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Update the position for each column
		for (int i = 0; i < columns.length; i++) {
			columns[i].updatePosition();
		}
		// Repaint every column
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < columns.length; i++) {
			columns[i].repaint();
		}
	}
}
