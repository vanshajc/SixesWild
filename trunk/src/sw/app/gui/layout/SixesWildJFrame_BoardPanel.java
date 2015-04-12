package sw.app.gui.layout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import sw.app.gui.layout.board.BoardPanel;
import sw.common.system.manager.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JButton;

public class SixesWildJFrame_BoardPanel extends JFrame implements ActionListener {
	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -3162315874662880626L;

	private LayoutManager layoutManager;
	
	Dimension size = new Dimension(800, 600);
	
	JButton resetButton;
	BoardPanel panel;
	
	public SixesWildJFrame_BoardPanel() {
		setResizable(false);
		setTitle("Sixes Wild");
		setPreferredSize(size);
		
		panel = new BoardPanel();
		
		resetButton = new JButton("Reset");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(resetButton)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(resetButton)
					.addGap(43)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		this.layoutManager = new LayoutManager();
		panel.initialize();
		
		resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.clear();
	}
}
