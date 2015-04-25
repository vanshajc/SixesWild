package sw.app.gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.controller.PostGameController;
import sw.app.gui.controller.StartGameController;

@SuppressWarnings("serial")
public class PostGameView extends JPanel implements IView {
		
	public PostGameView() {
		setBackground(Color.WHITE);
		setSize(new Dimension(800, 600));
		
		initialize();
	}

	@Override
	public void initialize() {
		
		JButton btnMainmenu = new JButton("MainMenu");
		btnMainmenu.addActionListener(new MainMenuController());
		
		JButton btnNextlevel = new JButton("NextLevel");
		btnNextlevel.addActionListener(new PostGameController());
		
		JButton btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new StartGameController());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMainmenu, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(150)
					.addComponent(btnReplay, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
					.addComponent(btnNextlevel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(263, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMainmenu)
						.addComponent(btnReplay)
						.addComponent(btnNextlevel))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		// Nothing to do
	}
}
