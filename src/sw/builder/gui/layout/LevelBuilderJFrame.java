package sw.builder.gui.layout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

public class LevelBuilderJFrame extends JFrame {
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
