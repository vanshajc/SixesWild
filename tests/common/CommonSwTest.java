/**
 * @file CommonSwTest.java
 * @date Apr 30, 2015 10:09:16 AM
 * @author Tony Vu (quangvu@wpi.edu)
 */
package common;

import sw.app.Application;
import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SixesWildJFrame;
import junit.framework.TestCase;

/**
 *
 */
public class CommonSwTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		Application.main(null);
		
		try {
			LayoutManager.switchToGameplayView(false);
			
			// This is for runtime testing
			LayoutManager.initCurrentView();			
			SixesWildJFrame.getLevelManager().startLevel();
		} catch (Exception e) {
			//fail("Should not have failed here!");
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

}
