package sw.builder.gui.layout;

import junit.framework.TestCase;
import sw.app.ApplicationLevelBuilder;

public class TestBuilderLayoutManager extends TestCase{
	LevelBuilderJFrame lbjf;
	BuilderLayoutManager blm;
	
	public void testSwitchToScreen(){
		ApplicationLevelBuilder.main(null);
		//lbjf = new LevelBuilderJFrame();
		blm = new BuilderLayoutManager(lbjf);
		
		blm.initailize();
		//blm.switchToLevelBuilder();
		//blm.switchToLevelBuilderMenu();
	}
	
	

}
