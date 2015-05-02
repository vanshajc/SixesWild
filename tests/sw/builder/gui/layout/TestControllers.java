package sw.builder.gui.layout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import org.junit.After;

import junit.framework.TestCase;
import sw.app.ApplicationLevelBuilder;
import sw.builder.gui.controller.LoadButtonController;
import sw.builder.gui.controller.SaveButtonController;

public class TestControllers extends TestCase{
	
	
	protected void setUp(){
	LevelBuilderJFrame lbjf;
	ApplicationLevelBuilder.main(null);
	lbjf = new LevelBuilderJFrame();
	BuilderLayoutManager blm = new BuilderLayoutManager(lbjf);
	LevelBuilderView lbv = lbjf.blm.lbv;
	ArrayList<String> input  = new ArrayList<String>();
	
	input.add("20");
	input.add("Release");
	input.add("0");
	input.add("0");
	input.add("2");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3,13,13,13,13,13,13,13,13,1");
	input.add("3");
	input.add("3");
	input.add("3");
	LoadButtonController lbc = new LoadButtonController(lbv);
	lbc.setFields(input);
	JButton save = new JButton();
	save.addActionListener(new SaveButtonController(blm, lbv));
	save.doClick();
	}
	
	@After
	protected void tearDown(){
		
	}
	
	public void testLoadButton(){
	}
	
	

}