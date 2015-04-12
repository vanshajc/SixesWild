package sw.app.gui.layout;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import sw.app.gui.layout.board.BoardPanel;
import sw.common.system.manager.LayoutManager;

import javax.swing.JPanel;

public class SixesWildJFrame_BoardPanel extends JFrame {
	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -3162315874662880626L;

	private LayoutManager layoutManager;
	
	Dimension size = new Dimension(800, 600);
	
	public SixesWildJFrame_BoardPanel() {
		setResizable(false);
		setTitle("Sixes Wild");
		setPreferredSize(size);
		
		BoardPanel panel = new BoardPanel();
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(142)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(292, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		this.layoutManager = new LayoutManager();
		panel.initialize();
	}
}
