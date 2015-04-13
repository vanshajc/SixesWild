/**
 *  @file   Release.java
 *  @author Tony Vu
 *  @since  Apr 11, 2015
 */
package sw.mode.release;

import java.awt.Dimension;

import sw.common.model.controller.IMode;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

/**
 * 
 */
public class Release extends CommonResourceManager implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Release";
	}

}
