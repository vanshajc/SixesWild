/**
 *  @file   ReleaseModeResourceManager.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.mode.release;

import java.awt.Image;
import java.util.HashMap;

import sw.common.model.entity.Square;
import sw.resource.IResourceManager;

/**
 * 
 */
public class ReleaseModeResourceManager implements IResourceManager {

	HashMap<Square, String> resources = new HashMap<Square, String>();
	
	public ReleaseModeResourceManager() {
		// load all images
	}

	/* (non-Javadoc)
	 * @see sw.resource.IResourceManager#getImages()
	 */
	@Override
	public HashMap<Square, String> getImages() {
		return resources;
	}

	@Override
	public String getImage(Square square) {
		// TODO Auto-generated method stub
		return null;
	}

}
