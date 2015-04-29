/**
 * @file GameplayView.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.controller.PostGameMenuController;
import sw.app.gui.view.board.BoardPanel;
import sw.app.gui.view.board.GameInfoPanel;
import sw.app.gui.view.board.IBoardPanel;
import sw.app.gui.view.board.IMovePanel;
import sw.app.gui.view.board.IScorePanel;
import sw.app.gui.view.board.ITimePanel;
import sw.app.gui.view.board.PowerUpPanel;
import sw.app.gui.view.board.ScorePanel;
import sw.app.gui.view.board.TimeMovePanel;
import sw.common.model.entity.Game;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;

import java.awt.Color;

@SuppressWarnings("serial")
public class GameplayView extends JPanel implements IGameplayView, IView {
	
	// Panels for displaying the Level
	BoardPanel boardPanel;	
	ScorePanel scorePanel;
	GameInfoPanel gameInfoPanel;
	TimeMovePanel timeMovePanel;
	PowerUpPanel powerUpPanel;
	
	// The Level to display
	Level level = null;	
	LevelManager lvlm;
	
	// Quit button
	JButton quitButton;	
	MainMenuController mmc;
	String quitBtnPath = "/sw/resource/image/button_quit.png";
	ImageIcon quitBtnImg;	
	
	
	
	private JButton btnPostgamemenutest;
	
	public GameplayView() {		
		this.lvlm          = SixesWildJFrame.getLevelManager();
		
		this.boardPanel    = new BoardPanel();
		
		this.timeMovePanel = new TimeMovePanel();
		this.scorePanel    = new ScorePanel();
		this.gameInfoPanel = new GameInfoPanel();
		this.powerUpPanel  = new PowerUpPanel();
		
		this.quitButton    = new JButton();
		this.mmc           = new MainMenuController();
		this.quitBtnImg    = new ImageIcon(GameplayView.class.getResource(quitBtnPath));
		setLayout(null);
	}
	
	//////////////////////////////////////////////////////////
	// Initialization methods
	//
	public void setLevel(Level lvl) {
		this.level = lvl;
		initializeLevel();
	}
	
	private void initializeLevel() {		
		if (level == null) {
			throw new IllegalStateException("Current level is null!");
		}		
		
		boardPanel.setLevel(level);
		
		scorePanel.setScore(level.getGame().getStats().getScore());
		timeMovePanel.setMove(level.getGame().getStats().getNumMoves());
		powerUpPanel.setPwrUp(level.getGame());
		
		gameInfoPanel.setLevelName(level.toString());
	}
	
	private void initializeLayout() {
		setBackground(Color.WHITE);
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
		btnPostgamemenutest.addActionListener(new PostGameMenuController(lvlm));		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(powerUpPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(timeMovePanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(250)
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
	
	//////////////////////////////////////////////////////////
	// IView methods
	//
	
	@Override
	public void initialize() {
		try {
			//initializeLevel();
			initializeLayout();

			//timeMovePanel.initialize(level.getGame().getStats());
			boardPanel.initialize();			
		} catch (IllegalStateException e) {
			System.err.println("Cannot initialize the Gameplay View!");
			LayoutManager.switchToMainMenu(true);
		}
	}	

	@Override
	public void cleanup() {		
		
		boardPanel.cleanup();
		timeMovePanel.cleanup();
		scorePanel.cleanup();
		
		// Remove all action listeners for this button
		ActionListener[] listeners = quitButton.getActionListeners();
		for (int i = 0; i < listeners.length; i++) {
			quitButton.removeActionListener(listeners[i]);
		}
		
		// Reset state
		level = null;
	}
	
	//////////////////////////////////////////////////////////
	// IGameplayView methods
	//
	
	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getBoardPanel()
	 */
	@Override
	public IBoardPanel getBoardPanel() {
		return boardPanel;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getScorePanel()
	 */
	@Override
	public IScorePanel getScorePanel() {
		return scorePanel;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getTimePanel()
	 */
	@Override
	public ITimePanel getTimePanel() {
		return timeMovePanel;
	}

	/* (non-Javadoc)
	 * @see sw.app.gui.view.IGameplayView#getMovePanel()
	 */
	@Override
	public IMovePanel getMovePanel() {
		return timeMovePanel;
	}	
	
	//////////////////////////////////////////////////////////
	// Paint the background
	//
	
	@Override
	public void paintComponent(Graphics g) {
		ImageIcon background = new ImageIcon(GameplayView.class.getResource("/sw/resource/image/firstBackground.png"));
		ImageIcon newBackground = new ImageIcon(background.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}	
	
}
