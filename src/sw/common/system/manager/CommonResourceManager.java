/**
 * @file CommonResourceManager.java
 * @date Apr 11, 2015 5:11:30 PM
 * @author Tony Vu (quangvu@wpi.edu), Vanshaj Chowdhary
 */
package sw.common.system.manager;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.ImageIcon;

import sw.common.model.entity.Square;
import sw.common.model.entity.Tile;
import sw.common.system.factory.TileFactory;

/**
 * Class for getting locations of different images
 */
public class CommonResourceManager implements IResourceManager {

	/** Holds the file name for the picture of each tile. */
	static HashMap<Tile, String> tileMap = new HashMap<Tile, String>();
	
	/** Holds the file name for the picture of a square. */
	static HashMap<Square, String> squareMap = new HashMap<Square, String>();

	/** Holds the image for each file name. */
	static HashMap<String, Image> imageMap = new HashMap<String, Image>();

	/** Holds the default image size. */
	static final Dimension imgSize = new Dimension(50, 50);

	/** Holds the base location for all images. */
	static final String imagePath = "/sw/resource/image/";

	/**
	 * Constructor for the Manager.
	 */
	public CommonResourceManager() throws IOException {
		// initialize the tile map
		for (int i = Tile.minValue; i <= Tile.maxValue; i++) {
			for (int m = Tile.minMultiplier; m <= Tile.maxMultiplier; m++) {
				Tile t = TileFactory.getTile(i, m);
				if (!tileMap.containsKey(t)) {
					String img = getImage(t);
					if (img != null) {
						tileMap.put(t, img);
					} else {
						System.err.println(String.format(
								"Missing file path for Tile %dx%d",
								t.getValue(), t.getMultiplier()));
					}
				}
			}
		}

		// TODO: initialize square map

		// load all images
		Collection<String> c = tileMap.values();
		for (String s : c) {
			Image img = getImage(s);
			if (img == null) {
				throw new IOException(String.format("Can't load image for %s", s));
			}
		}
	}

	/** (non-Javadoc) 
	 * @see sw.common.system.manager.IResourceManager#getImage()
	 */
	@Override
	public HashMap<Tile, String> getTileImage() {
		return tileMap;
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getSquareImage()
	 */
	@Override
	public HashMap<Square, String> getSquareImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImage(sw.common.model.entity.Square)
	 */
	@Override
	public String getImage(Square square) {
		if (square.isOnlySix())
			return imagePath.concat("tile_release.png");
		return getUnusedImage(square.getTile().getValue());
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImage(sw.common.model.entity.Tile)
	 */
	public String getImage(Tile tile) {
		return getTileImage(tile.getValue(), tile.getMultiplier());
	}

	/**
	 * @param i the tile value
	 * @return the string location of the image
	 */
	String getUnusedImage(int i) {
		return imagePath.concat(String.format("%d_unused.png", i));
	}

	/**
	 * @param val the tile value
	 * @param mul the tile multiplier
	 * @return the string location of the image
	 */
	String getTileImage(int val, int mul) {
		return imagePath.concat(String.format("tile_%dx%d.png", val, mul));
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImageSize()
	 */
	@Override
	public Dimension getImageSize() {
		return imgSize;
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getStarImage()
	 */
	public String getStarImage() {
		return imagePath.concat("star.png");
	}

	/**
	 * @param name the name of the powerup
	 * @return the stirng location of the powerup
	 */
	public String getPowerUpImage(String name) {
		return imagePath.concat("button_" + name + ".png");
	}

	/** (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImage(java.lang.String)
	 */
	@Override
	public Image getImage(String path) {
		if (imageMap.containsKey(path)) {
			return imageMap.get(path);
		} else {
			Image img = new ImageIcon(
					CommonResourceManager.class.getResource(path)).getImage();
			if (img != null) {
				imageMap.put(path, img);				
			}
			return img;
		}
	}

}
