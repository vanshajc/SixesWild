package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.util.LinkedList;

public class BoardColumn extends JPanel {

	/** UID */
	private static final long serialVersionUID = 4340682500682810975L;

	int count = 9;	
	Dimension imgSize;  // Size of the image to be displayed, guaranteed to be the same for every Image
	
	int xPos = 0;
	int yPos = 0;	
	LinkedList<BoardSquare> img;  // We may want to remove an Image in the middle of the linked-list and have the rest pack down to fill its place
								  // We also want to associate the Image with a Position that can be updated individually
	
	/**
	 * Create the panel.
	 * @param imgSize 
	 */
	public BoardColumn(int count, Dimension imgSize) {		
		this.count = count;		
		this.imgSize = imgSize;		
		this.img = new LinkedList<BoardSquare>();		
		
		setLayout(null);
		setPreferredSize(new Dimension(imgSize.width, imgSize.height * count));
		setDoubleBuffered(true);		
	}	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(img[0], xPos, yPos, null);
		//Toolkit.getDefaultToolkit().sync();
	}

	/** Update the position of images */
	public void updatePosition() {
		// TODO Auto-generated method stub
		
	}
	
	public void add(BoardSquare square) {
		//ImgPosition ip = new ImgPosition(0, 0, img);
		//this.img.add(img);  // Add new image to the end of the list
		//updatePosition();   // Update position
	}
	
	private class ImgPosition {
		int x;
		int y;
		Image image;
		
		ImgPosition(int x, int y, Image image) {
			this.x = x;
			this.y = y;
			this.image = image;			
		}		
	}	
}
