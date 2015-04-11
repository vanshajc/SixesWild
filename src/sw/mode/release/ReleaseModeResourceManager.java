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

	HashMap<Square, Image> resources = new HashMap<Square, Image>();
	
	public ReleaseModeResourceManager() {
		// load all images
	}

	/* (non-Javadoc)
	 * @see sw.resource.IResourceManager#getImages()
	 */
	@Override
	public HashMap<Square, Image> getImages() {
		return resources;
	}
	
	private Image loadImage(String fileName) {
		return null;
	}

}
