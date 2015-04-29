/**
 * @file PlayGameScreenView.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.controller.StartGameController;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;

public class PlayGameScreenView extends JPanel implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LevelManager lvlm;
	ArrayList<Level> lvlList;
	
	JComboBox<String> levelList;
	
	JButton btnStartGame;
	
	public PlayGameScreenView() {
		this.lvlm = SixesWildJFrame.getLevelManager();	
		this.lvlList = lvlm.getLevels();
		setLayout(null);
	}
	
	public void initialize() {
		setBackground(Color.WHITE);		
		
		JLabel lblLevel = new JLabel("Level");
		
		levelList = new JComboBox<String>();
		levelList.setBackground(Color.WHITE);
		
		// Load all available levels to the combobox
		for (int i = 0; i < lvlList.size(); i++) {
			String name = lvlList.get(i).toString();
			levelList.addItem(name);
		}		
//		levelList.setRenderer(new DisabledItemsRenderer<String>());

		ImageIcon buttonBack = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back.png"));
		ImageIcon newBtnBack = new ImageIcon(buttonBack.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackRollover = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back_Rollover.png"));
		ImageIcon newBtnBackRollover = new ImageIcon(btnBackRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackPressed = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back_Pressed.png"));
		ImageIcon newBtnBackPressed = new ImageIcon(btnBackPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnBack = new JButton(newBtnBack);
		btnBack.setBounds(10, 500, 227, 69);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(new MainMenuController());
		btnBack.setRolloverEnabled(true);
		btnBack.setRolloverIcon(newBtnBackRollover);
		btnBack.setPressedIcon(newBtnBackPressed);
		add(btnBack);
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new StartGameController());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
					.addComponent(btnStartGame, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(lblLevel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(levelList, 0, 143, Short.MAX_VALUE)
					.addGap(146))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnStartGame))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	@Override
	public void cleanup() {
		levelList.setSelectedIndex(0);		
	}
	
	void addLevel(Level level) {
		if (level != null) {
			levelList.addItem(level.toString());
		}
	}
	
	public Level getSelectedLevel() {
		return lvlm.getLevels().get(levelList.getSelectedIndex());
	}

//	private class DisabledItemsRenderer<String> extends BasicComboBoxRenderer {
//		public Component getListCellRendererComponent(JList list, Object value,
//				int index, boolean isSelected, boolean cellHasFocus) {
//			setText(value.toString());
//			if (index > lvlm.getHighestLevel().getLevelNum()) {
//				setEnabled(false);
//			}
//			return this;
//		}
//	}

}
