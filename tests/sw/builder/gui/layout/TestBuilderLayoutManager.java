package sw.builder.gui.layout;

import org.junit.After;

import junit.framework.TestCase;
import sw.app.ApplicationLevelBuilder;

public class TestBuilderLayoutManager extends TestCase{
	LevelBuilderJFrame lbjf;
	
	protected void setUp(){
	ApplicationLevelBuilder.main(null);
	lbjf = new LevelBuilderJFrame();
	BuilderLayoutManager blm = new BuilderLayoutManager(lbjf);
	
	
	}
	
	@After
	protected void tearDown(){
		
	}
	
	public void testSwitchToScreen(){
		
	}
	
	

}