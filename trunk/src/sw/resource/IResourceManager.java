/**
 *  @file   IResourceManager.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.resource;

import java.awt.Image;
import java.util.HashMap;

import sw.common.model.entity.Square;

/** Every game mode will need to get its own resource manager */
public interface IResourceManager {

	/** Get image file path for every possible state of every Tile.
	 *  
	 * @return the hash map of all images, keyed by the Square
	 */
	HashMap<Square, String> getImages();
	
	/** Get image for a particular state of the Tile */
	String getImage(Square square);
	
}
