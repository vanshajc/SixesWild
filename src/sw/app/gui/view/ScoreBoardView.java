package sw.app.gui.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import sw.app.gui.controller.MainMenuController;
import sw.common.model.entity.Board;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.factory.LevelFactory;
import java.awt.Font;

public class ScoreBoardView extends JPanel implements IView {
	
	int yPos = 77;
	int gap = 22;
	int count = 0;
	
	int levelX = 40;
	int scoreX = 230;
	int moveX  = 420;
	int timeX  = 610;
	
	Dimension fieldSize = new Dimension(150,15);
	
	public ScoreBoardView() {
		initialize();
	}
	
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

		JButton btnNewButton_1 = new JButton("Add score test");
		btnNewButton_1.setBounds(567, 507, 103, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				addLevelStats(LevelFactory.getLightningLevel(0, new Board(), new Statistics(), null));
			}
		});
		add(btnNewButton_1);

		JLabel lblLevel = new JLabel("Level");
		lblLevel.setForeground(new Color(184, 134, 11));
		lblLevel.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblLevel.setBounds(42, 96, 77, 36);
		add(lblLevel);

		JLabel lblStars = new JLabel("Stars");
		lblStars.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblStars.setForeground(new Color(184, 134, 11));
		lblStars.setBounds(220, 103, 81, 23);
		add(lblStars);

		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(new Color(184, 134, 11));
		lblTime.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblTime.setBounds(425, 103, 74, 23);
		add(lblTime);

		JLabel lblScore = new JLabel("Score");
		lblScore.setForeground(new Color(184, 134, 11));
		lblScore.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		lblScore.setBounds(647, 103, 87, 23);
		add(lblScore);
		
		ImageIcon backgroundImg = new ImageIcon(ScoreBoardView.class.getResource("/sw/resource/image/secondBackground.png"));
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
		// TODO Auto-generated method stub
		
	}
	
	public void addLevelStats(Level level) {
		
		// Limit to 25 entries
		if (count > 25) {
			return;
		}
		
		// Add new entry
		count++;
		
		JLabel levelNum = new JLabel();
		levelNum.setText(level.toString());		
		levelNum.setHorizontalAlignment(SwingConstants.CENTER);
		levelNum.setSize(fieldSize);
		levelNum.setLocation(new Point(levelX, yPos + (fieldSize.height * count) + gap));
		add(levelNum);
		
		JLabel score = new JLabel();
		score.setText(Integer.toString(level.getGame().getStats().getScore()));		
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setSize(fieldSize);
		score.setLocation(new Point(scoreX, yPos + (fieldSize.height * count) + gap));
		add(score);
		
		JLabel move = new JLabel();
		move.setText(Integer.toString(level.getGame().getStats().getNumMoves()));		
		move.setHorizontalAlignment(SwingConstants.CENTER);
		move.setSize(fieldSize);
		move.setLocation(new Point(moveX, yPos + (fieldSize.height * count) + gap));
		add(move);
		
		JLabel time = new JLabel();
		time.setText(level.getGame().getStats().getTime().toString());		
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setSize(fieldSize);
		time.setLocation(new Point(timeX, yPos + (fieldSize.height * count) + gap));
		add(time);
		
		invalidate();
		repaint();
	}
}
