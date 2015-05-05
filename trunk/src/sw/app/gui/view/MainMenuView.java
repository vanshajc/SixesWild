/**
 * @file MainMenuView.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sw.app.gui.controller.CreditScreenController;
import sw.app.gui.controller.PlayGameScreenController;
import sw.app.gui.controller.ScoreboardScreenController;

public class MainMenuView extends JPanel implements IView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717902879125448300L;	

	public MainMenuView() {		
		//initialize();
	}

	@Override
	public void initialize() {
		setLayout(null);
		
		ImageIcon buttonPlay = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_play.png"));
		ImageIcon newBtnPlay = new ImageIcon(buttonPlay.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnPlayRollover = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_play_Rollover.png"));
		ImageIcon newBtnPlayRollover = new ImageIcon(btnPlayRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnPlayPressed = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_play_Pressed.png"));
		ImageIcon newBtnPlayPressed = new ImageIcon(btnPlayPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnPlay = new JButton(newBtnPlay);
		btnPlay.setBorderPainted(false);
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setBounds(280, 220, 227, 59);
		btnPlay.setBorder(null);
		btnPlay.setContentAreaFilled(false);
		btnPlay.addActionListener(new PlayGameScreenController());
		btnPlay.setRolloverEnabled(true);
		btnPlay.setRolloverIcon(newBtnPlayRollover);
		btnPlay.setPressedIcon(newBtnPlayPressed);
		add(btnPlay);
		
		ImageIcon buttonScoreboard = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_scoreboard.png"));
		ImageIcon newBtnScoreboard = new ImageIcon(buttonScoreboard.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnScoreboardRollover = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_scoreboard_Rollover.png"));
		ImageIcon newBtnScoreboardRollover = new ImageIcon(btnScoreboardRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnScoreboardPressed = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_scoreboard_Pressed.png"));
		ImageIcon newBtnScoreboardPressed = new ImageIcon(btnScoreboardPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		JButton btnScoreboard = new JButton(newBtnScoreboard);
		btnScoreboard.setBorderPainted(false);
		btnScoreboard.setBackground(Color.WHITE);
		btnScoreboard.setBounds(280, 310, 227, 69);
		btnScoreboard.setBorder(null);
		btnScoreboard.setContentAreaFilled(false);
		btnScoreboard.addActionListener(new ScoreboardScreenController());
		btnScoreboard.setRolloverEnabled(true);
		btnScoreboard.setRolloverIcon(newBtnScoreboardRollover);
		btnScoreboard.setPressedIcon(newBtnScoreboardPressed);
		add(btnScoreboard);
		
		ImageIcon buttonCredits = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_credits.png"));
		ImageIcon newBtnCredits = new ImageIcon(buttonCredits.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnCreditsRollover = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_credits_Rollover.png"));
		ImageIcon newBtnCreditsRollover = new ImageIcon(btnCreditsRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnCreditsPressed = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_credits_Pressed.png"));
		ImageIcon newBtnCreditsPressed = new ImageIcon(btnCreditsPressed.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));		
		JButton btnCredits = new JButton(newBtnCredits);
		btnCredits.setBorderPainted(false);
		btnCredits.setBackground(Color.WHITE);
		btnCredits.setBounds(280, 400, 227, 69);
		btnCredits.setBorder(null);
		btnCredits.setContentAreaFilled(false);
		btnCredits.addActionListener(new CreditScreenController());
		btnCredits.setRolloverEnabled(true);
		btnCredits.setRolloverIcon(newBtnCreditsRollover);
		btnCredits.setPressedIcon(newBtnCreditsPressed);
		add(btnCredits);

		ImageIcon backgroundImg = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/splashScreen.png"));
		ImageIcon newBackground = new ImageIcon(backgroundImg.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		JLabel background = new JLabel(newBackground);
		background.setVerticalAlignment(SwingConstants.TOP);
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 800, 600);
		add(background);
	}

	public Dimension getPrefferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	public void cleanup() {

	}
}
