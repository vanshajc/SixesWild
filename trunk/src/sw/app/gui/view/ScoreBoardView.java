package sw.app.gui.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Scrollbar;
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
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;

public class ScoreBoardView extends JPanel implements IView {
	
	int yPos = 30;
	int gap = 10;
	int count = 0;
	
	int levelX = 50;
	int scoreX = 250;
	int moveX  = 450;
	int timeX  = 650;
	
	Dimension fieldSize = new Dimension(100, 36);
	
	JScrollPane scrollPane;
	
	public ScoreBoardView() {
		setSize(new Dimension(800, 600));
		//initialize();
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
	
	public Dimension getPrefferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	public void cleanup() {
		removeAll();
		invalidate();
	}
	
	public void paintComponent(Graphics g) {

		ImageIcon backgroundImg = new ImageIcon(ScoreBoardView.class.getResource("/sw/resource/image/secondBackground.png"));
		ImageIcon newBackground = new ImageIcon(backgroundImg.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);;
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}
	
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
		levelNum.setLocation(new Point(levelX-35, yPos + (fieldSize.height * count) + gap));
		add(levelNum);
		
		JLabel score = new JLabel();
		score.setForeground(new Color(184, 134, 11));
		score.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		score.setText(Integer.toString(level.getGame().getStats().getScore()));		
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setSize(fieldSize);
		score.setLocation(new Point(scoreX, yPos + (fieldSize.height * count) + gap));
		add(score);
		
		JLabel move = new JLabel();
		move.setForeground(new Color(184, 134, 11));
		move.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		move.setText(Integer.toString(level.getGame().getStats().getNumMoves()));		
		move.setHorizontalAlignment(SwingConstants.CENTER);
		move.setSize(fieldSize);
		move.setLocation(new Point(moveX, yPos + (fieldSize.height * count) + gap));
		add(move);
		
		JLabel time = new JLabel();
		time.setForeground(new Color(184, 134, 11));
		time.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		time.setText(level.getGame().getStats().getTime().toString());		
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setSize(fieldSize);
		time.setLocation(new Point(timeX, yPos + (fieldSize.height * count) + gap));
		add(time);
		
		invalidate();
		repaint();
	}
}
