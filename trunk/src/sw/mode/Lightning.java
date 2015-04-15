package sw.mode;

import sw.common.model.controller.IMode;
import sw.common.system.manager.CommonResourceManager;
import sw.common.system.manager.IResourceManager;

public class Lightning extends CommonResourceManager implements IMode {

	@Override
	public IResourceManager getResourceManger() {
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lightning";
	}

}
