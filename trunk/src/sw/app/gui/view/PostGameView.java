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
import sw.common.model.entity.Level;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PostGameView extends JPanel implements IView {
	
	Level level;
	public PostGameView(Level level) {
		this.level = level;
		setBackground(Color.WHITE);
		setSize(new Dimension(800, 600));
		
		initialize();
	}

	@Override
	public void initialize() {
		
		ImageIcon buttonMainMenu = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_mainMenu.png"));
		ImageIcon newBtnMainMenu = new ImageIcon(buttonMainMenu.getImage().getScaledInstance(152, 64, java.awt.Image.SCALE_SMOOTH));
		JButton btnMainmenu = new JButton(newBtnMainMenu);
		btnMainmenu.setBorder(null);
		btnMainmenu.addActionListener(new MainMenuController());
		
		ImageIcon buttonNextLevel = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_next.png"));
		ImageIcon newBtnNextLevel = new ImageIcon(buttonNextLevel.getImage().getScaledInstance(152, 64, java.awt.Image.SCALE_SMOOTH));
		JButton btnNextLevel = new JButton(newBtnNextLevel);
		btnNextLevel.setBorder(null);
		btnNextLevel.addActionListener(new PostGameController());
		
		ImageIcon buttonReplay = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_replay.png")); 
		ImageIcon newBtnReplay = new ImageIcon(buttonReplay.getImage().getScaledInstance(152, 64, java.awt.Image.SCALE_SMOOTH));
		JButton btnReplay = new JButton(newBtnReplay);
		btnReplay.addActionListener(new StartGameController());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addComponent(btnMainmenu, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addComponent(btnReplay, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addComponent(btnNextLevel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(525, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMainmenu, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNextLevel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnReplay, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		// Nothing to do
	}
}
