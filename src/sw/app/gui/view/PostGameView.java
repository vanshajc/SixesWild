/**
 * @file PostGameView.java
 * @author Vanshaj Chowdhary, ANDREW PUT YOUR NAME HERE
 */
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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PostGameView extends JPanel implements IView {
	
	Level level;
	
	JLabel lblLevelDisplay;
	JLabel lblTimeDisplay;
	JLabel lblScoreDisplay;
	
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
		btnMainmenu.setBounds(86, 504, 152, 64);
		btnMainmenu.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMainmenu.setBorder(null);
		btnMainmenu.addActionListener(new MainMenuController());
		
		ImageIcon buttonNextLevel = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_next.png"));
		ImageIcon newBtnNextLevel = new ImageIcon(buttonNextLevel.getImage().getScaledInstance(152, 64, java.awt.Image.SCALE_SMOOTH));
		JButton btnNextLevel = new JButton(newBtnNextLevel);
		btnNextLevel.setBounds(562, 504, 152, 64);
		btnNextLevel.setBorder(null);
		btnNextLevel.addActionListener(new PostGameController());
		
		ImageIcon buttonReplay = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_replay.png")); 
		ImageIcon newBtnReplay = new ImageIcon(buttonReplay.getImage().getScaledInstance(152, 64, java.awt.Image.SCALE_SMOOTH));
		JButton btnReplay = new JButton(newBtnReplay);
		btnReplay.setBounds(324, 504, 152, 64);
		btnReplay.setBorder(null);
		btnReplay.addActionListener(new StartGameController());
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(210, 349, 150, 36);
		lblTime.setForeground(new Color(184, 134, 11));
		lblTime.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(210, 396, 150, 36);
		lblScore.setForeground(new Color(184, 134, 11));
		lblScore.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		
		lblLevelDisplay = new JLabel("LevelDisplay");
		lblLevelDisplay.setBounds(300, 301, 250, 36);
		lblLevelDisplay.setForeground(new Color(184, 134, 11));
		lblLevelDisplay.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		
		lblTimeDisplay = new JLabel("TimeDisplay");
		lblTimeDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeDisplay.setBounds(410, 349, 201, 36);
		lblTimeDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblTimeDisplay.setForeground(new Color(184, 134, 11));
		lblTimeDisplay.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		
		lblScoreDisplay = new JLabel("ScoreDisplay");
		lblScoreDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreDisplay.setBounds(410, 396, 201, 36);
		lblScoreDisplay.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblScoreDisplay.setForeground(new Color(184, 134, 11));
		lblScoreDisplay.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		
		ImageIcon goodjobImg = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/Goodjob2.png"));
		JLabel lblGoodjob = new JLabel(goodjobImg);
		lblGoodjob.setBounds(29, 11, 747, 250);
		
//		ImageIcon starImg1 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
//		JLabel lblstar1 = new JLabel(starImg1);
//		lblstar1.setBounds(317, 443, 50, 50);
//		lblstar1.setHorizontalAlignment(SwingConstants.LEFT);
//		
//		ImageIcon starImg2 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
//		JLabel lblstar2 = new JLabel(starImg2);
//		lblstar2.setBounds(377, 443, 46, 50);
//		
//		ImageIcon starImg3 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
//		JLabel lblstar3 = new JLabel(starImg3);
//		lblstar3.setBounds(433, 443, 46, 50);
		
		setLayout(null);
		add(lblGoodjob);
		add(lblLevelDisplay);
		add(lblTime);
		add(lblTimeDisplay);
		add(lblScore);
		add(lblScoreDisplay);
//		add(lblstar1);
//		add(lblstar2);
//		add(lblstar3);
		add(btnMainmenu);
		add(btnReplay);
		add(btnNextLevel);
		
		setLevel(level);
	}

	@Override
	public void cleanup() {
		// Nothing to do
	}
	
	public void setLevel(Level l) {
		lblLevelDisplay.setText(l.toString());
		lblScoreDisplay.setText(String.valueOf(l.getGame().getStats().getScore()));
		lblTimeDisplay.setText(l.getGame().getStats().getTime().toString());
		
		// add stars
		int numStars = l.getStars();
		if (numStars >= 1) {
			ImageIcon starImg1 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
			JLabel lblstar1 = new JLabel(starImg1);
			lblstar1.setBounds(317, 443, 50, 50);
			lblstar1.setHorizontalAlignment(SwingConstants.LEFT);
			add(lblstar1);
		}
		
		if (numStars >= 2) {
			ImageIcon starImg2 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
			JLabel lblstar2 = new JLabel(starImg2);
			lblstar2.setBounds(377, 443, 46, 50);
			add(lblstar2);
		}
		
		if (numStars >= 3) {
			ImageIcon starImg3 = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/star.png"));
			JLabel lblstar3 = new JLabel(starImg3);
			lblstar3.setBounds(433, 443, 46, 50);
			add(lblstar3);
		}
		
		invalidate();
		repaint();		
	}
}
