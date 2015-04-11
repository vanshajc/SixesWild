package sw.app.gui.layout;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import sw.common.system.manager.LayoutManager;

public class SixesWildJFrame extends JFrame {
	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -3162315874662880626L;

	private LayoutManager layoutManager;
	
	Dimension size = new Dimension(800, 600);
	
	public SixesWildJFrame() {
		setResizable(false);
		setTitle("Sixes Wild");
		setPreferredSize(size);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 432, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		this.layoutManager = new LayoutManager();
	}

}
