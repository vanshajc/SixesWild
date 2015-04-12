package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import sw.common.model.entity.Square;
import sw.common.system.factory.TileFactory;
import sw.common.system.manager.IResourceManager;

public class BoardColumn extends JPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7989466787176501882L;

	int imgWidth = 50;
	int imgHeight = 50;
	int count = 9;
	
	int xPos = 0;
	int yPos = 0;
	
	Image img;	
	
	IResourceManager resourceManager;
	
	Square squares[] = new Square[count];
	int rows[] = new int[count];
	
	int stop;
	
	/** Design note:
	 *  Should treat each column like a queue, add in from tail, take from head, but we can also
	 *  remove square from somewhere in the middle, the next one will take its place, so it's also like 
	 *  a doubly-linked list
	 * 
	 * @param resManager
	 * @param stop
	 */

	
	public BoardColumn(IResourceManager resManager, int stop) {
		Dimension size = new Dimension(imgWidth, imgHeight * count);
		setPreferredSize(size);
		
		String path = resManager.getImage(new Square(TileFactory.getTile()));
		ImageIcon ii = new ImageIcon(BoardColumn.class.getResource(path));		
		img = ii.getImage();
		
		// Calculate rows
		for (int i = 0; i < count; i++) {
			rows[i] = size.height - ((i+1)*imgHeight);
		}
		this.stop = stop;
	}

	public void updatePosition() {
		if (yPos == 0) {
			yPos = 1;
		} else if (yPos < rows[stop]) {
			yPos += 2;		
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.copyArea(xPos, yPos, imgWidth, imgHeight, 0, 0);
		g.drawImage(img, xPos, yPos, null);
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	private class BoardSquare {
		int yPos; // y position, in term of index, 0 is the lowest position
		Square square;
		
		public BoardSquare(Square square) {
			this.yPos = count - 1;  // insert at the top
			this.square = square;
		}
	}

}
