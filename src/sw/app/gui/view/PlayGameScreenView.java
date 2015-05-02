/**
 * @file PlayGameScreenView.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.plaf.ComboBoxUI;

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
	
	public PlayGameScreenView() {
		this.lvlm = SixesWildJFrame.getLevelManager();	
		this.lvlList = lvlm.getLevels();
		setLayout(null);
	}
	
	public void initialize() {
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(120, 124, 100, 45);
		lblLevel.setForeground(new Color(184, 134, 11));
		lblLevel.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		add(lblLevel);
		
		levelList = new JComboBox<String>();
		levelList.setUI(new MyComboBoxUI());
		((JLabel)levelList.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		levelList.setBounds(280, 124, 400, 45);
		levelList.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		levelList.setForeground(new Color(184, 134, 11));
		levelList.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		levelList.setBackground(Color.WHITE);
		add(levelList);
		
		// Load all unlocked levels to the combobox
		int highest = lvlm.getHighestLevel().getLevelNum();
		for (int i = 0; i < lvlList.size(); i++) {
			Level l = lvlList.get(i);
			if (l.getLevelNum() <= highest) {
				String name = lvlList.get(i).toString();
				levelList.addItem(name);
			}
		}		
//		levelList.setRenderer(new DisabledItemsRenderer<String>());

		ImageIcon buttonBack = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back.png"));
		ImageIcon newBtnBack = new ImageIcon(buttonBack.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackRollover = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back_Rollover.png"));
		ImageIcon newBtnBackRollover = new ImageIcon(btnBackRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackPressed = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_back_Pressed.png"));
		ImageIcon newBtnBackPressed = new ImageIcon(btnBackPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnBack = new JButton(newBtnBack);
		btnBack.setBounds(20, 500, 227, 69);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBorder(null);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(new MainMenuController());
		btnBack.setRolloverEnabled(true);
		btnBack.setRolloverIcon(newBtnBackRollover);
		btnBack.setPressedIcon(newBtnBackPressed);
		add(btnBack);
		
		ImageIcon buttonStart = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_startGame.png"));
		ImageIcon newBtnStart = new ImageIcon(buttonStart.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnStartRollover = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_startGame_Rollover.png"));
		ImageIcon newBtnStartRollover = new ImageIcon(btnStartRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnStartPressed = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/button_startGame_Pressed.png"));
		ImageIcon newBtnStartPressed = new ImageIcon(btnStartPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnStartGame = new JButton(newBtnStart);
		btnStartGame.setBounds(550, 500, 227, 69);
		btnStartGame.setBorderPainted(false);
		btnStartGame.setBackground(Color.WHITE);
		btnStartGame.setBorder(null);
		btnStartGame.setContentAreaFilled(false);
		btnStartGame.addActionListener(new StartGameController());
		btnStartGame.setRolloverEnabled(true);
		btnStartGame.setRolloverIcon(newBtnStartRollover);
		btnStartGame.setPressedIcon(newBtnStartPressed);
		add(btnStartGame);

		ImageIcon backgroundImg = new ImageIcon(PlayGameScreenView.class.getResource("/sw/resource/image/secondBackground.png"));
		ImageIcon newBackground = new ImageIcon(backgroundImg.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		JLabel background = new JLabel(newBackground);
		background.setVerticalAlignment(SwingConstants.TOP);
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 800, 600);
		add(background);
		/*
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
		);*/
		setLayout(null);
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
