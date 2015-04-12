package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import sw.app.gui.layout.board.BoardPanel;
import sw.common.system.manager.LayoutManager;
import sw.common.system.manager.LevelManager;

import javax.swing.JPanel;
import javax.swing.JButton;

public class SixesWildJFrame_BoardPanel extends JFrame implements ActionListener {
	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -3162315874662880626L;

	private LayoutManager layoutManager;
	private LevelManager levelManager;
	
	Dimension size = new Dimension(800, 600);
	GameplayView panel;
	
	public SixesWildJFrame_BoardPanel() {
		layoutManager = new LayoutManager();
		levelManager = new LevelManager();
		
		panel = new GameplayView(layoutManager, levelManager);
		
		setResizable(false);
		setTitle("Sixes Wild");
		setPreferredSize(panel.getPreferredSize());
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		this.layoutManager = new LayoutManager();
		panel.initialize();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
