/**
 * @file GameplayView.java
 * @author Vanshaj Chowdhary
 */
package sw.app.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import sw.app.gui.controller.MainMenuController;
import sw.app.gui.view.board.BoardPanel;
import sw.app.gui.view.board.GameInfoPanel;
import sw.app.gui.view.board.IBoardPanel;
import sw.app.gui.view.board.IMovePanel;
import sw.app.gui.view.board.IScorePanel;
import sw.app.gui.view.board.ITimePanel;
import sw.app.gui.view.board.PowerUpPanel;
import sw.app.gui.view.board.ScorePanel;
import sw.app.gui.view.board.TimeMovePanel;
import sw.common.model.entity.Level;
import sw.common.system.manager.LevelManager;

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
		setPreferredSize(new Dimension(800, 600)); //was 685, 564
		setMinimumSize(getPreferredSize());
		
		boardPanel.setBackground(Color.WHITE);		
		timeMovePanel.setBackground(Color.WHITE);		
		scorePanel.setBackground(Color.WHITE);				
		gameInfoPanel.setBackground(Color.WHITE);		
		powerUpPanel.setBackground(Color.WHITE);

		ImageIcon buttonQuit = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_mainMenu.png"));
		ImageIcon newBtnQuit = new ImageIcon(buttonQuit.getImage().getScaledInstance(114, 48, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonQuitRollover = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_mainMenu_Rollover.png"));
		ImageIcon newBtnQuitRollover = new ImageIcon(buttonQuitRollover.getImage().getScaledInstance(114, 48, java.awt.Image.SCALE_SMOOTH));
		ImageIcon buttonQuitPressed = new ImageIcon(PostGameView.class.getResource("/sw/resource/image/button_mainMenu_Pressed.png"));
		ImageIcon newBtnQuitPressed = new ImageIcon(buttonQuitPressed.getImage().getScaledInstance(114, 48, java.awt.Image.SCALE_SMOOTH));
		quitButton = new JButton(newBtnQuit);
		quitButton.setOpaque(false);
		quitButton.setBackground(Color.WHITE);
		quitButton.setBorderPainted(false);
		quitButton.setBounds(25, 505, 114, 48);
		quitButton.setBorder(null);
		quitButton.setContentAreaFilled(false);
		quitButton.addActionListener(mmc);
		quitButton.setRolloverEnabled(true);
		quitButton.setRolloverIcon(newBtnQuitRollover);
		quitButton.setPressedIcon(newBtnQuitPressed);
		add(quitButton);
		
		gameInfoPanel.setBounds(0, 15, 200, 36);
		add(gameInfoPanel);
		
		powerUpPanel.setBounds(40, 100, 77, 300);
		add(powerUpPanel);
		
		timeMovePanel.setBounds(200, 15, 450, 25);
		add(timeMovePanel);
		
		boardPanel.setBounds(170, 65, 450, 450);
		add(boardPanel);
		
		scorePanel.setBounds(650, 65, 102, 450);
		add(scorePanel);

		setLayout(null);
	}
	
	//////////////////////////////////////////////////////////
	// IView methods
	//
	
	@Override
	public void initialize() {
		try {
			initializeLayout();

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
		ImageIcon background = new ImageIcon(GameplayView.class.getResource("/sw/resource/image/secondBackground.png"));
		ImageIcon newBackground = new ImageIcon(background.getImage().getScaledInstance(800, 573, java.awt.Image.SCALE_SMOOTH));
		super.paintComponent(g);
		g.drawImage(newBackground.getImage(), 0, 0, null);
	}	
	
}
