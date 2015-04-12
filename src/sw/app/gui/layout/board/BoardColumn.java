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
	
	String resourcePath = "/sw/resource/image/icon50x50.png";
	
	IResourceManager resourceManager;
	
	Square squares[] = new Square[count];
	int rows[] = new int[count];
	
	int stop;
	
	public BoardColumn(IResourceManager resManager, int stop) {
		Dimension size = new Dimension(imgWidth, imgHeight * count);
		setPreferredSize(size);
		
		String path = resManager.getImage(new Square(TileFactory.createTile()));
		ImageIcon ii = new ImageIcon(BoardColumn.class.getResource(path));		
		img = ii.getImage();
		
		// Calculate rows
		for (int i = 0; i < count; i++) {
			rows[i] = size.height - ((i+1)*imgHeight);
		}
		this.stop = stop;
	}

	public void updatePosition() {
		if (yPos < rows[stop]) {
			yPos++;		
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, xPos, yPos, null);
	}

}
