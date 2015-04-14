package sw.builder.gui.layout;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import sw.app.gui.view.LayoutManager;
import sw.app.gui.view.SplashScreenView;
import sw.common.system.manager.LevelManager;

public class LevelBuilderJFrame extends JFrame implements IView{
	LayoutManager lm = new LayoutManager(this);
	SplashScreenView ssv = new SplashScreenView(lm);
	
	Container pane = getContentPane();
	long startTime;
	
	
	public LevelBuilderJFrame() {
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 726, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 484, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}

}
