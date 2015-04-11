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

	/** Get images for every possible state of every Tile.
	 *  
	 *  We load all images when application start as 
	 *  an optimization
	 *  
	 * @return the hash map of all images, keyed by the Square
	 */
	HashMap<Square, Image> getImages();
	
}
