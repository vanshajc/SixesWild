/**
 *  @file   IResourceManager.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.manager;

import java.util.HashMap;

import sw.common.model.entity.Square;


/** Every game mode will need to get its own resource manager */
public interface IResourceManager {
	
	/** Get the image file path for every possible Square
	 * @return the hashmap with Square as key
	 */
	HashMap<Square, String> getImage();
	
	/** Get image file path for a particular Square */
	String getImage(Square square);
	
}
