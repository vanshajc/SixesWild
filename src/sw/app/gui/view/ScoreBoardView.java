package sw.app.gui.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import sw.app.gui.controller.MainMenuController;
import sw.common.model.entity.Level;

/**
 * @file ScoreBoardView.java
 * @author Vanshaj Chowdhary, Trung-Nghia N. Huynh.
 */

/**
 * Class for representing the scoreboard view.
 */
public class ScoreBoardView extends JPanel implements IView {
	
	/** Coordinates of the entries. */
	int yPos = 10;
	int gap = 10;
	int count = 0;
	
	int levelX = 50;
	int scoreX = 250;
	int moveX  = 450;
	int timeX  = 650;
	
	Dimension fieldSize = new Dimension(100, 36);
	
	JScrollPane scrollPane;
	
	/**
	 * ScoreBoardView constructor.
	 */
	public ScoreBoardView() {
		setSize(new Dimension(800, 600));
		//initialize();
	}
	
	/**
	 * Initialize the view for the scoreboard screen.
	 */
	public void initialize(){
		setLayout(null);
		
		ImageIcon buttonBack = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_back.png"));
		ImageIcon newBtnBack = new ImageIcon(buttonBack.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackRollover = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_back_Rollover.png"));
		ImageIcon newBtnBackRollover = new ImageIcon(btnBackRollover.getImage().getScaledInstance(227, 69, java.awt.Image.SCALE_SMOOTH));
		ImageIcon btnBackPressed = new ImageIcon(MainMenuView.class.getResource("/sw/resource/image/button_back_Pressed.png"));
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
		
		ImageIcon title = new ImageIcon(ScoreBoardView.class.getResource("/sw/resource/image/title_scoreboard.png"));
		ImageIcon newTitle = new ImageIcon(title.getImage().getScaledInstance(249, 84, java.awt.Image.SCALE_SMOOTH));
		JLabel lblTitle = new JLabel(newTitle);
		lblTitle.setBounds(550, 480, 249, 84);
		add(lblTitle);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(184, 134, 11));
		lblLevel.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblLevel.setBounds(levelX, yPos, fieldSize.width, fieldSize.height);
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblLevel);

		JLabel lblStars = new JLabel("Score");
		lblStars.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblStars.setForeground(new Color(184, 134, 11));
		lblStars.setBounds(scoreX, yPos, fieldSize.width, fieldSize.height);
		lblStars.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStars);

		JLabel lblTime = new JLabel("Move");
		lblTime.setForeground(new Color(184, 134, 11));
		lblTime.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblTime.setBounds(moveX, yPos, fieldSize.width, fieldSize.height);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTime);

		JLabel lblScore = new JLabel("Time");
		lblScore.setForeground(new Color(184, 134, 11));
		lblScore.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblScore.setBounds(timeX, yPos, fieldSize.width, fieldSize.height);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblScore);
		
		List<Level> past = SixesWildJFrame.getLevelManager().getHighScore();
		if (past != null) {
			Iterator<Level> li = past.iterator();
			while (li.hasNext()) {
				addLevelStats(li.next());
				li.remove();
			}
		}
	
	}
	
	/**
	 * Set the size of the scoreboard.
	 * @return Size of the JPanel.
	 */
	public Dimension getPrefferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	public void cleanup() {
		removeAll();
		invalidate();
	}
	
	/**
	 * Used the loaded image to draw the background.
	 */
	public void paintComponent(Graphics g) {

		ImageIcon backgroundImg = new ImageIcon(ScoreBoardView.class.getResource("/sw/resource/image/secondBackground.png"));
		ImageIcon newBackground = new ImageIcon(backgroundImg.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);;
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}
	
	/**
	 * Use the completed levels to display the statistics on the scoreboard screen.
	 * @param level Level to be used.
	 */
	public void addLevelStats(Level level) {
		
		if (level == null) {
			return;
		}
		
		// Limit to 16 entries
		if (count > 16) {
			return;
		}
		
		// Add new entry
		count++;
		
		JLabel levelNum = new JLabel();
		levelNum.setForeground(new Color(184, 134, 11));
		levelNum.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		levelNum.setText(level.toString());		
		levelNum.setHorizontalAlignment(SwingConstants.CENTER);
		levelNum.setSize(175, 36);
		levelNum.setLocation(new Point(levelX-35, yPos - 10 + (fieldSize.height * count) + gap));
		add(levelNum);
		
		JLabel score = new JLabel();
		score.setForeground(new Color(184, 134, 11));
		score.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		score.setText(Integer.toString(level.getGame().getStats().getScore()));		
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setSize(fieldSize);
		score.setLocation(new Point(scoreX, yPos - 10 + (fieldSize.height * count) + gap));
		add(score);
		
		JLabel move = new JLabel();
		move.setForeground(new Color(184, 134, 11));
		move.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		move.setText(Integer.toString(level.getGame().getStats().getNumMoves()));		
		move.setHorizontalAlignment(SwingConstants.CENTER);
		move.setSize(fieldSize);
		move.setLocation(new Point(moveX, yPos - 10 + (fieldSize.height * count) + gap));
		add(move);
		
		JLabel time = new JLabel();
		time.setForeground(new Color(184, 134, 11));
		time.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		time.setText(level.getGame().getStats().getTime().toString());		
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setSize(fieldSize);
		time.setLocation(new Point(timeX, yPos - 10 + (fieldSize.height * count) + gap));
		add(time);
		
		invalidate();
		repaint();
	}
}
