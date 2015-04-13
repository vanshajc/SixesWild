/**
 * @file CommonResourceManager.java
 * @date Apr 11, 2015 5:11:30 PM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package sw.mode;

import java.awt.Dimension;
import java.util.HashMap;

import sw.common.model.entity.Square;
import sw.common.system.manager.IResourceManager;

/**
 *
 */
public abstract class CommonResourceManager implements IResourceManager {
	
	Dimension imgSize = new Dimension(50,50);
	
	String imagePath = "/sw/resource/image/";

	/* (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImage()
	 */
	@Override
	public HashMap<Square, String> getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(Square square) {
		return getUnusedImage(square.getTile().getValue());		
	}
	
	String getUnusedImage(int i) {
		return imagePath.concat(String.format("%d_unused.png", i));
	}

	/* (non-Javadoc)
	 * @see sw.common.system.manager.IResourceManager#getImageSize()
	 */
	@Override
	public Dimension getImageSize() {
		return imgSize;
	}

}
