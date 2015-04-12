package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.SplashScreen;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;

import org.omg.CORBA.INITIALIZE;
import javax.swing.JPanel;

public class SixesWildJFrame extends JFrame implements IView{
	
	public static void main(String[] args) {
		SixesWildJFrame swj = new SixesWildJFrame();
		
		swj.setVisible(true);
		swj.ssv.initialize();
	}
	
	
	SplashScreenView ssv = new SplashScreenView();
	
	
	public SixesWildJFrame() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1006, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 724, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.add(ssv);
		setSize(1060, 850);
		getContentPane().setLayout(groupLayout);

	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}
}

