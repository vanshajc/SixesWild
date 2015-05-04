package sw.builder.gui.layout;

import java.util.ArrayList;

import javax.swing.JButton;

import junit.framework.TestCase;
import sw.app.ApplicationLevelBuilder;
import sw.builder.gui.controller.LoadButtonController;
import sw.builder.gui.controller.SaveButtonController;

public class TestControllers extends TestCase{
	
	
	public void test1(){
	LevelBuilderJFrame lbjf;
	ApplicationLevelBuilder a = new ApplicationLevelBuilder();
	lbjf = a.getFrame();
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
	
	
	

}