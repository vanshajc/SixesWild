package sw.app.gui.layout.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import sw.common.model.entity.Board;
import sw.common.model.entity.Square;
import sw.common.system.manager.IResourceManager;

public class BoardColumn extends JPanel {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7989466787176501882L;

	int count = 9;
	
	int xPos = 0;
	int yPos = 0;
	
	Dimension imgSize;
	IResourceManager resourceManager;
	
	Square squares[] = new Square[count];
	int rows[] = new int[count];
	
	ArrayList<Square> col;
	
	HashMap<Square, Image> imageMap;
	
	/** Design note:
	 *  Should treat each column like a queue, add in from tail, take from head, but we can also
	 *  remove square from somewhere in the middle, the next one will take its place, so it's also like 
	 *  a doubly-linked list
	 * 
	 * @param resManager
	 * @param imageMap 
	 * @param column
	 */

	
	public BoardColumn(IResourceManager resManager, HashMap<Square, Image> imageMap, ArrayList<Square> column) {
		this.resourceManager = resManager;
		this.imageMap = imageMap;
		this.col = column;		
		this.imgSize = resManager.getImageSize();
		
		Dimension size = new Dimension(imgSize.width, imgSize.height * count);
		setPreferredSize(size);
		
		// Calculate row positions
		for (int i = 0; i < count; i++) {
			rows[i] = size.height - ((i+1)*imgSize.height);
		}
		
		// Load the images we need, will add in more as needed
		for (int y = 0; y < Board.ROW; y++) {
			Square s = column.get(y);
			if (!imageMap.containsKey(s)) {
				Image img = new ImageIcon(BoardColumn.class.getResource(resManager.getImage(s))).getImage();
				imageMap.put(s, img);
			}
		}		
		
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
		//g.copyArea(xPos, yPos, imgSize.width, imgSize.height, 0, 0);
		//g.drawImage(img, xPos, yPos, null);
	}
	
	void paintSquares(Graphics g) {
		Image img;
		for (int y = 0; y < Board.ROW; y++) {
			Square s = col.get(y);
			if (!imageMap.containsKey(s)) {
				img = new ImageIcon(BoardColumn.class.getResource(resourceManager.getImage(s))).getImage();
				imageMap.put(s, img);
			} else {
				img = imageMap.get(s);
			}
			g.drawImage(img, 0, rows[y], null);
		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
