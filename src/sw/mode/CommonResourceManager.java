/**
 * @file CommonResourceManager.java
 * @date Apr 11, 2015 5:11:30 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.mode;

import sw.common.model.entity.Square;
import sw.common.system.manager.IResourceManager;

/**
 *
 */
public abstract class CommonResourceManager implements IResourceManager {
	
	String imagePath = "/sw/resource/image/";

	@Override
	public String getImage(Square square) {
		return getUnusedImage(square.getTile().getValue());		
	}
	
	String getUnusedImage(int i) {
		return imagePath.concat(String.format("%d_unused.png", i));
	}

}
