package sw.app.gui.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.controller.PostGameMenuController;
import sw.app.gui.view.board.BoardPanel;
import sw.app.gui.view.board.GameInfoPanel;
import sw.app.gui.view.board.PowerUpPanel;
import sw.app.gui.view.board.ScorePanel;
import sw.app.gui.view.board.TimeMovePanel;
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.model.entity.Statistics;
import sw.common.system.manager.LevelManager;

import java.awt.Color;

public class GameplayView extends JPanel implements IView, ActionListener {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7540685505032159107L;
	
	Dimension size = new Dimension(630, 540);
	
	BoardPanel boardPanel;
	ScorePanel scorePanel;
	GameInfoPanel gameInfoPanel;
	TimeMovePanel timeMovePanel;
	PowerUpPanel powerUpPanel;
	
	Level level;
	LayoutManager manager;
	LevelManager levelManager;
	
	Image background = new ImageIcon(SplashScreenView.class.getResource("/sw/resource/image/SplashScreenResizedtest.png")).getImage();
	
	private JButton btnPostgamemenutest;
	
	JButton quitButton;	
	MainMenuController mmc;
	String quitBtnPath = "/sw/resource/image/button_quit.png";
	ImageIcon quitBtnImg;
	
	Timer refreshTimer;
	
	/**
	 * Create the panel.
	 */
	public GameplayView(LayoutManager layoutManager, LevelManager levelManager) {
		setBackground(Color.WHITE);
		this.manager = layoutManager;
		this.levelManager = levelManager;
		
		this.boardPanel    = new BoardPanel();
		this.timeMovePanel = new TimeMovePanel();
		this.scorePanel    = new ScorePanel();
		this.gameInfoPanel = new GameInfoPanel();
		this.powerUpPanel  = new PowerUpPanel(boardPanel, levelManager);
		
		this.quitButton    = new JButton();
		this.mmc           = new MainMenuController(manager);
		this.quitBtnImg    = new ImageIcon(GameplayView.class.getResource(quitBtnPath));
	
		this.refreshTimer  = new Timer(250, this);  // 250 msec
	}
	
	private void initializeLevel() {
		level = levelManager.getCurrent();
		if (level == null) {
			throw new IllegalStateException("Current level is null!");
		}
		
		level.initialize(); // Reset the state of the Board
		boardPanel.setLevel(level);
		gameInfoPanel.setLevelName(level.toString());		
	}
	
	private void initializeLayout() {
		setPreferredSize(new Dimension(685, 564));
		setMinimumSize(getPreferredSize());
		
		boardPanel.setBackground(Color.WHITE);		
		timeMovePanel.setBackground(Color.WHITE);		
		scorePanel.setBackground(Color.WHITE);				
		gameInfoPanel.setBackground(Color.WHITE);		
		powerUpPanel.setBackground(Color.WHITE);
		
		quitButton.setIcon(quitBtnImg);
		quitButton.addActionListener(mmc);
		
		btnPostgamemenutest = new JButton("PostGameMenuTest");
		btnPostgamemenutest.addActionListener(new PostGameMenuController(manager));		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(powerUpPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(timeMovePanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(gameInfoPanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(239)
							.addComponent(btnPostgamemenutest)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(gameInfoPanel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(timeMovePanel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(powerUpPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPostgamemenutest)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void initialize() {
		try {
			initializeLevel();
			initializeLayout();

			timeMovePanel.initialize();
			boardPanel.initialize();
			
			update();			
			
			refreshTimer.start();
			timeMovePanel.startTimer();
		} catch (IllegalStateException e) {
			System.err.println("Cannot initialize the Gameplay View!");
			manager.switchToMainMenu();
		}
	}
	
	public void update() {
		if (this.level != null) {
			Game game = level.getGame();
			
			Statistics stats = game.getStats();
			
			scorePanel.setScore(stats.getScore());
			scorePanel.setStar(level.getStars());
			
			timeMovePanel.setMove(level.countMove());
		}		
	}	

	@Override
	public void cleanup() {
		refreshTimer.stop();
		
		boardPanel.cleanup();
		
		// Remove all action listeners for this button
		ActionListener[] listeners = quitButton.getActionListeners();
		for (int i = 0; i < listeners.length; i++) {
			quitButton.removeActionListener(listeners[i]);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}

	/** Update stats on a timer tick */
	@Override
	public void actionPerformed(ActionEvent e) {
		update();		
	}
}
