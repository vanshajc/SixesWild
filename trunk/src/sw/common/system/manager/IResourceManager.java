/**
 *  @file   IResourceManager.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.common.system.manager;

import sw.common.model.entity.Square;


/** Every game mode will need to get its own resource manager */
public interface IResourceManager {
	
	/** Get image for a particular state of the Tile */
	String getImage(Square square);
	
}
