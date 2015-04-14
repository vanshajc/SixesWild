package sw.app.gui.view.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.common.model.entity.Board;
import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;

public class BoardColumn extends JPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7989466787176501882L;

	int count = 9;
	
	int xPos = 0;
	int yPos = 0;
	
	Dimension imgSize;
	
	int rows[] = new int[count];
	
	Board board;
	
	/** The column of Square to display */
	ArrayList<Square> col;
	
	/** Keep a cached copy of the column so when updatePosition is called, we know what changed */
	ArrayList<Square> cache;
	
	BoardPanel panel;
	
	// Need to translate Board discreet position into XY explicit position

	public BoardColumn(BoardPanel boardPanel, int i) {
		this.panel = boardPanel;
		this.board = boardPanel.board;
		this.col = board.getColumn(i);		
		this.imgSize = boardPanel.resManager.getImageSize();
		
		// Create a cache copy of the column
		this.cache = new ArrayList<Square>(col);
		
		Dimension size = new Dimension(imgSize.width, imgSize.height * count);
		setPreferredSize(size);
		
		// Calculate row positions
		for (int idx = 0; idx < count; idx++) {
			rows[idx] = size.height - ((idx+1)*imgSize.height);
		}
		
		// Load the images we need, will add in more as needed
		for (int y = 0; y < Board.ROW; y++) {
			Square s = col.get(y);
			if (!panel.imageMap.containsKey(s)) {
				Image img = loadImage(s);
				panel.imageMap.put(s, img);
			}
			
		}
		
		// Create BoardTile
		
		
	}

	public void updatePosition() {
		if (yPos == 0) {
			yPos = 1;
		} else if (yPos < rows[0]) {
			yPos += 2;		
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// paint the squares
		paintSquares(g);
		
		// paint the tiles
		//g.drawImage(img, xPos, yPos, null);
	}
	
	void paintSquares(Graphics g) {
		for (int y = 0; y < Board.ROW; y++) {
			Square s = col.get(y);
			Image img = loadImage(s);
			g.drawImage(img, 0, rows[y], null);
		}
	}
	
	Image loadImage(Square s) {
		Image img;
		if (!panel.imageMap.containsKey(s)) {
			img = new ImageIcon(BoardColumn.class.getResource(panel.resManager.getImage(s))).getImage();
			panel.imageMap.put(s, img);
		} else {
			img = panel.imageMap.get(s);
		}
		return img;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	class BoardTile {
		int prevBoardPos = 0;
		int currBoardPos = 0;
		int prevXYPos = 0;
		int currXYPos = 0;
		Tile tile;		
	}

}
