/**
 * @file CommonResourceManager.java
 * @date Apr 11, 2015 5:11:30 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;

import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.factory.TileFactory;

/**
 * Class for getting locations of different images
 */
public class CommonResourceManager implements IResourceManager {
	
	static HashMap<Tile, String> tileMap = new HashMap<Tile, String>();
	static HashMap<Square, String> squareMap = new HashMap<Square, String>();
	
	static HashMap<String, Image> imageMap = new HashMap<String, Image>();
	
	static Dimension imgSize = new Dimension(50,50);
	
	static String imagePath = "/sw/resource/image/";
	
	public CommonResourceManager() {
		// initialize the tile map
		for (int i = Tile.minValue; i <= Tile.maxValue; i++) {
			for (int m = Tile.minMultiplier; m <= Tile.maxMultiplier; m++) {
				Tile t = TileFactory.getTile(i, m);
				if (!tileMap.containsKey(t)) {
					tileMap.put(t, getImage(t));
				}
			}
		}
		
		// TODO: initialize square map
		
		// load all images
		Collection<String> c = tileMap.values();
		for (String s : c) {
			getImage(s);
		}		
	}

	/* (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImage()
	 */
	@Override
	public HashMap<Tile, String> getTileImage() {		
		return tileMap;
	}
	
	@Override
	public HashMap<Square, String> getSquareImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(Square square) {
		if (square.isOnlySix())
			return imagePath.concat("tile_release.png");
		return getUnusedImage(square.getTile().getValue());		
	}
	
	public String getImage(Tile tile) {
		return getTileImage(tile.getValue(), tile.getMultiplier());
	}
	
	String getUnusedImage(int i) {
		return imagePath.concat(String.format("%d_unused.png", i));
	}
	
	String getTileImage(int val, int mul) {
		return imagePath.concat(String.format("tile_%dx%d.png", val, mul));
	}

	@Override
	public Dimension getImageSize() {
		return imgSize;
	}
	
	public String getStarImage() {
		return imagePath.concat("star.png");
	}	
	
	public String getPowerUpImage(String name) {
		return imagePath.concat("button_"+name+".png");
	}

	@Override
	public Image getImage(String path) {
		if (imageMap.containsKey(path)) {
			return imageMap.get(path);
		} else {
			try {
				Image img = new ImageIcon(CommonResourceManager.class.getResource(path)).getImage();
				imageMap.put(path, img);
				return img;
			} catch (Exception e) {
				System.err.println("Cannot load image!");
			}
		}
		return null;
	}	

}
