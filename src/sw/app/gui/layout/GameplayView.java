package sw.app.gui.layout;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import sw.app.gui.layout.board.BoardPanel;
import sw.app.gui.layout.board.GameInfoPanel;
import sw.app.gui.layout.board.PowerUpPanel;
import sw.app.gui.layout.board.ScorePanel;
import sw.app.gui.layout.board.TimeMovePanel;
import sw.common.model.entity.Level;
import sw.common.system.manager.LayoutManager;
import sw.common.system.manager.LevelManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class GameplayView extends JPanel implements IView {

	/** GENERATED DO NOT CHANGE */
	private static final long serialVersionUID = -7540685505032159107L;
	
	Dimension size = new Dimension(630, 540);
	
	BoardPanel boardPanel;
	ScorePanel scorePanel;
	GameInfoPanel gameInfoPanel;
	TimeMovePanel timeMovePanel;
	PowerUpPanel powerUpPanel;
	JButton quitButton;
	
	LayoutManager manager;
	LevelManager levelManager;
	
	/**
	 * Create the panel.
	 */
	public GameplayView(LayoutManager manager, LevelManager levelManager) {
		this.manager = manager;
		this.levelManager = levelManager;
		
		Level level = levelManager.getCurrent();
		this.boardPanel    = new BoardPanel(level);
		this.timeMovePanel = new TimeMovePanel();
		this.scorePanel    = new ScorePanel();
		this.gameInfoPanel = new GameInfoPanel(level.toString());
		
		this.powerUpPanel  = new PowerUpPanel();
		this.quitButton    = new JButton("");		
		quitButton.setIcon(new ImageIcon(GameplayView.class.getResource("/sw/resource/image/button_quit.png")));
		
		initializeLayout();
	}
	
	private void initializeLayout() {
		setPreferredSize(new Dimension(685, 564));
		setMinimumSize(getPreferredSize());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(powerUpPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(timeMovePanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(220)
							.addComponent(gameInfoPanel, GroupLayout.PREFERRED_SIZE, 196, Short.MAX_VALUE)
							.addGap(290)))
					.addGap(0))
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
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(powerUpPanel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(quitButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		boardPanel.initialize();
		
		scorePanel.setMinimum(0);
		scorePanel.setMaximum(1000);
		scorePanel.setScore(300);
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		boardPanel.cleanup();
	}
}
