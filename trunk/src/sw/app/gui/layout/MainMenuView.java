package sw.app.gui.layout;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainMenuView extends JPanel {
	public MainMenuView() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		
		JButton btnNewButton = new JButton("Play");
		
		JButton btnNewButton_1 = new JButton("Scoreboard");
		
		JButton btnCredits = new JButton("Credits");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(196)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(172)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(189)
							.addComponent(btnCredits)))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(103)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnCredits)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
}
